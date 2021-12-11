# linked-list

+ [Reverse Linked List](#reverse-linked-list)
+ [Middle of the Linked List](#middle-of-the-linked-list)
+ [Palindrome Linked List](#palindrome-linked-list)

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
