# linked-list

+ [Reverse Linked List](#reverse-linked-list)
+ [Middle of the Linked List](#middle-of-the-linked-list)
+ [Palindrome Linked List](#palindrome-linked-list)
+ [Merge Two Sorted Lists](#merge-two-sorted-lists)
+ [Intersection of Two Linked Lists](#intersection-of-two-linked-lists)
+ [Sort List](#sort-list)

## Reverse Linked List

https://leetcode.com/problems/reverse-linked-list/

<details><summary>Test Cases</summary><blockquote>

``` java
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution solution;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void reverseList() {
        ListNode expected = createLinkedList(List.of(5, 4, 3, 2, 1));
        var listToTest = createLinkedList(List.of(1, 2, 3, 4, 5));
        var actual = solution.reverseList(listToTest);
        assertEquals(expected, actual);
    }

    @Test
    void reverseNullList() {
        assertNull(solution.reverseList(null));
    }

    @org.junit.jupiter.api.Test
    void reverseListNegative() {
        var expected = createLinkedList(List.of(3, 7, 19));
        var listToTest = createLinkedList(List.of(19, 7, 10));
        var actual = solution.reverseList(listToTest);
        assertNotEquals(expected, actual);
    }

    private ListNode createLinkedList(List<Integer> lst){
        var head = new ListNode();
        var cur = head;
        for(int val: lst){
            ListNode next = new ListNode();
            next.val = val;
            cur.next = next;
            cur = cur.next;
        }
        return head.next;
    }
}
```

``` java
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val && Objects.equals(next, listNode.next);
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
```

</blockquote></details>

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        var cur = head;
        ListNode next = null;
        ListNode prev = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
```

## Middle of the Linked List

https://leetcode.com/problems/middle-of-the-linked-list/

<details><summary>Test Cases</summary><blockquote>

``` java
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void middleNode() {
        var list = List.of(1, 2, 3, 4);
        var linkedList = createLinkedList(list);
        var actual = new Solution().middleNode(linkedList);
        var expected = createLinkedList(list.subList(list.size()/2, list.size()));
        assertEquals(expected, actual);
    }

    @Test
    public void notMiddleNode()
    {
        var list = List.of(1, 2, 3);
        var actual = new Solution().middleNode(createLinkedList(List.of(1, 2, 3, 4)));
        var unexpected = createLinkedList(list.subList(list.size()/2, list.size()));
        assertNotEquals(unexpected, actual);
    }

    private ListNode createLinkedList(List<Integer> lst){
        var head = new ListNode();
        var cur = head;
        for(int val: lst){
            ListNode next = new ListNode();
            next.val = val;
            cur.next = next;
            cur = cur.next;
        }
        return head.next;
    }
}
```

``` java
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val && Objects.equals(next, listNode.next);
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
```

</blockquote></details>

```java
class Solution {
    public ListNode middleNode(ListNode head) {
        var slow = head;
        var fast = head;
        while(fast.next != null){
            if(fast.next.next == null)
                return slow.next;
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
```

## Palindrome Linked List

https://leetcode.com/problems/palindrome-linked-list/

<details><summary>Test Cases</summary><blockquote>

``` java
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void isPalindrome() {
        var linkedList = createLinkedList(List.of(1, 2, 3, 4, 3, 2, 1));
        assertTrue(new Solution().isPalindrome(linkedList));
    }

    @Test
    void isNotPalindrome() {
        var linkedList = createLinkedList(List.of(1, 2, 3, 4, 4, 2, 1));
        assertFalse(new Solution().isPalindrome(linkedList));
    }

    private ListNode createLinkedList(List<Integer> lst){
        var head = new ListNode();
        var cur = head;
        for(int val: lst){
            ListNode next = new ListNode();
            next.val = val;
            cur.next = next;
            cur = cur.next;
        }
        return head.next;
    }
}

```

``` java
import java.util.Objects;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val && Objects.equals(next, listNode.next);
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
```

</blockquote></details>

```java
class Solution {
    private ListNode middleNode(ListNode head) {
        var slow = head;
        var fast = head;
        while(fast.next != null){
            if(fast.next.next == null)
                return slow.next;
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        var cur = head;
        ListNode next = null;
        ListNode prev = null;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private boolean compareLists(ListNode head, ListNode secondHead){
        while(secondHead != null){
            if(secondHead.val != head.val){
                return false;
            }
            secondHead = secondHead.next;
            head = head.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        var secondHead = middleNode(head);
        secondHead = reverseList(secondHead);
        return compareLists(head, secondHead);
    }
}
```

## Merge Two Sorted Lists

https://leetcode.com/problems/merge-two-sorted-lists/

<details><summary>Test Cases</summary><blockquote>

``` java
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void mergeTwoLists() {
        var expected = createLinkedList(List.of(1, 2, 3, 7));
        var actual = new Solution().mergeTwoLists(createLinkedList(List.of(1, 7)), createLinkedList(List.of(2, 3)));
        assertEquals(expected, actual);
    }

    @Test
    void mergeTwoNullLists() {
        assertNull(new Solution().mergeTwoLists(null, null));
    }

    private ListNode createLinkedList(List<Integer> lst){
        var head = new ListNode();
        var cur = head;
        for(int val: lst){
            ListNode next = new ListNode();
            next.val = val;
            cur.next = next;
            cur = cur.next;
        }
        return head.next;
    }
}
```

``` java
import java.util.Objects;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val && Objects.equals(next, listNode.next);
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
```

</blockquote></details>

```java
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        if(list1.val < list2.val){
            var justNode = list1;
            list1 = list2;
            list2 = justNode;
        }
        var head = list2;
        var cur = head;
        list2 = list2.next;
        while(list1 != null && list2 != null){
            if (list1.val > list2.val) {
                list2 = list2.next;
                cur = cur.next;
            } else {
                var next1 = list1.next;
                cur.next = list1;
                list1.next = list2;
                list1 = next1;
                cur = cur.next;
            }
        }
        cur.next = list1 == null ? list2 : list1;
        return head;
    }
}
```

## Intersection of Two Linked Lists

https://leetcode.com/problems/intersection-of-two-linked-lists/

<details><summary>Test Cases</summary><blockquote>

``` java
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
public class SolutionTest {

    @Test
    public void getIntersectionNode() {
    var expected = createLinkedList(List.of(1, 2, 3));;
    var headA = createLinkedList(List.of(1, 2, 1, 2, 3));
    var headB = createLinkedList(List.of(2, 1, 2, 3));
    intersectLists(headA, headB, 2, 1);
    var actual = new Solution().getIntersectionNode(headA, headB);
    assertEquals(expected, actual);
    }

    @Test
    public void getNullIntersectionNode(){
        var headA = createLinkedList(List.of(11, 2, 3, 2, 7));
        var headB = createLinkedList(List.of(22, 3, 2, 7));
        assertNull(new Solution().getIntersectionNode(headA, headB));
    }

    private ListNode createLinkedList(List<Integer> lst){
        var head = new ListNode();
        var cur = head;
        for(int val: lst){
            ListNode next = new ListNode();
            next.val = val;
            cur.next = next;
            cur = cur.next;
        }
        return head.next;
    }

    private void intersectLists(ListNode headA, ListNode headB, int skipA, int skipB){
        var headA2 = headA;
        while(skipA != 0){
            headA2 = headA2.next;
            skipA--;
        }
        var headB2 = headB;
        while(skipB < 1){
            headB2 = headB2.next;
            skipB--;
        }
        headB2.next = headA2;
    }
}
```

``` java
import java.util.Objects;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val && Objects.equals(next, listNode.next);
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
```

</blockquote></details>

```java
class Solution {
    private ListNode reverseLinkedList(ListNode head){
        ListNode next;
        ListNode prev = null;
        var cur = head;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private int numOfNodes(ListNode head){
        var numOfNodes = 0;
        while(head != null){
            numOfNodes++;
            head = head.next;
        }
        return numOfNodes;
    }

    private boolean areListsIntersected(ListNode headA, ListNode headB){
        var num1 = numOfNodes(headA);
        var num2 = numOfNodes(headB);
        var headC = reverseLinkedList(headB);
        var head = headC;
        while(head.next != null){
            head = head.next;
        }
        head.next = headA;
        var counter = 0;
        while(counter < num1 + 2 && headA != null){
            headA = headA.next;
            counter++;
        }
        var headC2 = headC;
        while(num2 != 1){
            headC2 = headC2.next;
            num2--;
        }
        headC2.next = null;
        reverseLinkedList(headC);
        return headA == null ? false : true;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(areListsIntersected(headA, headB) == false){
            return null;
        }
        var num1 = numOfNodes(headA);
        var num2 = numOfNodes(headB);
        var headC = reverseLinkedList(headB);
        var num3 = numOfNodes(headA);
        reverseLinkedList(headC);
        var indexOfIntersectionA = (num3-num2+num1-1)/2;
        var head = headA;
        for(int i = 0; i < indexOfIntersectionA; i++){
            head = head.next;
        }
        return head;
    }
}
```

## Sort List

https://leetcode.com/problems/sort-list/

<details><summary>Test Cases</summary><blockquote>

``` java
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void sortList() {
        var expected = createLinkedList(List.of(1, 2, 2, 7, 8));
        var actual = new Solution().sortList(createLinkedList(List.of(2, 7, 1, 8, 2)));
        assertEquals(expected, actual);
    }

    @Test
    public void sortSortedList(){
        var expected = createLinkedList(List.of(1, 2, 2, 7, 8, 8, 8, 12, 1000));
        var actual = new Solution().sortList(createLinkedList(List.of(1, 2, 2, 7, 8, 8, 8, 12, 1000)));
        assertEquals(expected, actual);
    }

    private ListNode createLinkedList(List<Integer> lst){
        var head = new ListNode();
        var cur = head;
        for(int val: lst){
            ListNode next = new ListNode();
            next.val = val;
            cur.next = next;
            cur = cur.next;
        }
        return head.next;
    }
}
```

``` java
import java.util.Objects;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val && Objects.equals(next, listNode.next);
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
```

</blockquote></details>

```java
public class Solution {
    private ListNode middleNode(ListNode head) {
        var slow = head;
        var fast = head;
        var prev = head;
        while(fast!=null && fast.next != null){
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        prev.next = null;
        return slow;
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        if(list1.val < list2.val){
            var justNode = list1;
            list1 = list2;
            list2 = justNode;
        }
        var head = list2;
        var cur = head;
        list2 = list2.next;
        while(list1 != null && list2 != null){
            if (list1.val > list2.val) {
                list2 = list2.next;
                cur = cur.next;
            } else {
                var next1 = list1.next;
                cur.next = list1;
                list1.next = list2;
                list1 = next1;
                cur = cur.next;
            }
        }
        cur.next = list1 == null ? list2 : list1;
        return head;
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode head2 = sortList(middleNode(head));
        ListNode head1 = sortList(head);
        return mergeTwoLists(head1,head2);
    }
}
```
