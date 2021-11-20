# array

+ [Reverse Integer](#reverse-integer)
+ [Palindrome Number](#palindrome-number)
+ [Fizz Buzz](#fizz-buzz)
+ [Middle of the Linked List](#middle-of-the-linked-list)

## Reverse Integer

https://leetcode.com/problems/reverse-integer/

```java
def reverse(self, x: int) -> int:
    a = 0
    t = x
    if x < 0:
        x = x*(-1)
    while x > 0:
        a = a*10 + x%10
        x = x // 10
    if t < 0:
        a = a*(-1)
    if (a > 2147483647) or (a < -2147483648):
        return 0
    return a
```

## Palindrome Number

https://leetcode.com/problems/palindrome-number/

```java
def isPalindrome(self, x: int) -> bool:
    a = 0   
    t = x
    ret = 1
    if x < 0:
        return 0
    while x > 0:
        a = a*10 + x%10
        x = x // 10
    if t < 0:
        a = a*(-1)
    while t > 0:
        if t%10 != a%10:
            ret = 0          
        t = t // 10
        a = a // 10
    return ret
```

## Fizz Buzz

https://leetcode.com/problems/fizz-buzz/

```java
def fizzBuzz(self, n: int) -> List[str]:
    sch = 1
    lst = []       
    while sch <= n:
        if (sch % 3 == 0) and (sch % 5 == 0) :
            lst.append("FizzBuzz")
        else:
            if sch % 3 == 0:
                lst.append("Fizz")
            else:
                if sch % 5 == 0:
                    lst.append("Buzz")
                else:      
                    a = str(sch)
                    lst.append(a)
        sch = sch + 1   
    return lst
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

