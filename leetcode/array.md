# Array

+ [Squares of a Sorted Array](#squares-of-a-sorted-array)

## Squares of a Sorted Array

https://leetcode.com/problems/squares-of-a-sorted-array/

<details><summary>Test Cases</summary><blockquote>

``` java
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void sortedSquares() {
        var testArray = createRandomArray(10);
        var actual = new Solution().sortedSquares(testArray);
        var expected = sortedSquares(testArray);
        assertArrayEquals(expected, actual);
    }

    private int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i]*nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    private int[] createRandomArray(int size){
        var arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = (int)(Math.random() * 10 * Math.pow(-1, (int)(Math.random()*2)));
        }
        return arr;
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

