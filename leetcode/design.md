# Design

+ [Min Stack](#min-stack)
+ [Implement Stack using Queues](#implement-stack-using-queues)

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

## Implement Stack using Queues

https://leetcode.com/problems/implement-stack-using-queues/submissions/

<details><summary>Test Cases</summary><blockquote>

``` java
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    @Test
    void pushPop() {
        var testList = createRandomList(10);
        var actualStack = createMyStackFromList(testList);
        Collections.reverse(testList);
        for (var val: testList) {
            assertEquals(val, actualStack.pop());
        }
    }

    @Test
    void top() {
        var testList = createRandomList(10);
        var actualStack = createMyStackFromList(testList);
        Collections.reverse(testList);
        for (var val: testList) {
            assertEquals(val, actualStack.top());
            actualStack.pop();
        }
    }

    @Test
    void empty() {
        var actualStack = createMyStackFromList(List.of());
        assertTrue(actualStack.empty());
    }

    @Test
    void notEmpty() {
        var actualStack = createMyStackFromList(createRandomList(5));
        assertFalse(actualStack.empty());
    }

    private MyStack createMyStackFromList(List<Integer> lst){
        var stack = new MyStack();
        for (var val: lst) {
            stack.push(val);
        }
        return stack;
    }

    private ArrayList<Integer> createRandomList(int size){
        var lst = new ArrayList<Integer>();
        for(int i = 0; i < size; i++){
            lst.add((int)(Math.random() * 10));
        }
        return lst;
    }
}
```

</blockquote></details>

```java
public class MyStack {
    Queue q1 = null;
    Queue q2 = null;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }
        while (!q2.isEmpty()) {
            q1.add(q2.poll());
        }
    }

    public int pop() {
        return (Integer)q1.poll();
    }

    public int top() {
        return (Integer)q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
```
