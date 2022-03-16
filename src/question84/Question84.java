package question84;


import java.util.ArrayDeque;
import java.util.Deque;

public class Question84 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.largestRectangleArea(new int[]{5, 4, 3, 2, 1});
        System.out.println(i);
    }
}

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int result = 0;
        if (n == 1) {
            return heights[0];
        }
        //单调栈中记录的是数组元素的下标
        Deque<Integer> monoStack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!monoStack.isEmpty() && heights[i] >= heights[monoStack.peek()]) {
                int index = monoStack.pop();
                if (result < heights[index] * (i - index + 1)) {
                    result = heights[index] * (i - index + 1);
                }
            }
            monoStack.push(i);
        }
        return result;
    }
}
