# Stream

+ [Top K Frequent Words](#top-k-frequent-words)

## Top K Frequent Words

https://leetcode.com/problems/top-k-frequent-words/

<details><summary>Test Cases</summary><blockquote>

```java
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void topKFrequent() {
        var expected = List.of("the","is","sunny","day");
        String [] words= {"the","day","is","sunny","the","the","the","sunny","is","is"};
        var actual = new Solution().topKFrequent(words, 4);
        assertEquals(expected, actual);
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
    public List<String> topKFrequent(String[] words, int k) {
        return Arrays.stream(words)
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String,Long>comparingByValue().reversed()
                        .thenComparing(Map.Entry.<String,Long>comparingByKey()))
                .map(Map.Entry::<String,Long>getKey)
                .limit(k)
                .collect(Collectors.toList());
    }
}
```
