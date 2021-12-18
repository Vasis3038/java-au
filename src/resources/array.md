# array

+ [Squares of a Sorted Array](#squares-of-a-sorted-array)

## Squares of a Sorted Array

https://leetcode.com/problems/squares-of-a-sorted-array/

<details><summary>Test Cases</summary><blockquote>

```java
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
```java
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

    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i]*nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
```

