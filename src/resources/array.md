# array

+ [Middle of the Linked List](#middle-of-the-linked-list)
+ [Middle of the Linked List](#middle-of-the-linked-list)

## Middle of the Linked List

https://leetcode.com/problems/middle-of-the-linked-list/

```java
def middleNode(self, head: ListNode) -> ListNode:
    one = head
    two = head
    while (two != None) and (two.next != None):
        one = one.next
        if two.next == None:
            two = two.next
        else:
            two = two.next.next
    return one
```

## Middle of the Linked List

https://leetcode.com/problems/middle-of-the-linked-list/

```java
def middleNode(self, head: ListNode) -> ListNode:
    one = head
    two = head
    while (two != None) and (two.next != None):
        one = one.next
        if two.next == None:
            two = two.next
        else:
            two = two.next.next
    return one
```

