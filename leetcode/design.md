# Design

+ [Min Stack](#min-stack)

## Min Stack

https://leetcode.com/problems/min-stack/

<details><summary>Test Cases</summary><blockquote>

``` java
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class MinStackTest {

    @Test
    void pushPopTop() {
        var testList = new ArrayList<Integer>();
        testList.addAll(List.of(1, 2, 3, 4, 5));
        var actualStack = createMinStackFromList(testList);
        Collections.reverse(testList);
        for (var expectedVal: testList) {
            assertEquals(expectedVal, actualStack.top());
            actualStack.pop();
        }
    }

    @Test
    void getMin() {
        var testList = new ArrayList<Integer>();
        testList.addAll(List.of(5, 2, 3, 4, 5));
        var actualStack = createMinStackFromList(testList);
        assertEquals(actualStack.getMin(), testList.stream().min((o1, o2) -> o1.compareTo(o2)).get());
    }

    private MinStack createMinStackFromList(List<Integer> lst){
        var stack = new MinStack();
        for (var val: lst) {
            stack.push(val);
        }
        return stack;
    }
}
```

</blockquote></details>

```java
public class MinStack {

    private Node topNode;

    public MinStack() {
        topNode = null;
    }

    public void push(int val) {
        if (topNode == null) {
            topNode = new Node(val, val);
        }
        else {
            Node newNode = new Node(val, Math.min(topNode.min, val));
            newNode.next = topNode;
            topNode = newNode;
        }
    }

    public void pop() {
        topNode = topNode.next;
    }

    public int top() {
        return topNode.val;
    }

    public int getMin() {
        return topNode.min;
    }

    private class Node{
        int val;
        int min;
        Node next;
        private Node(int val, int min){
            this.val = val;
            this.min = min;
            this.next = null;
        }
    }
}
```
