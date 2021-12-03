# Linked List

+ [Reverse Linked List](#reverse-linked-list)

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
 public ListNode reverseList(ListNode head) {
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
```
