package question84;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Dell
 */
public class Answer {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.largestRectangleArea(new int[]{1}));
    }
}

class Solution1 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int result = 0;
        int[] newHeights = new int[n + 2];
        newHeights[0] = 0;
        newHeights[n + 1] = 0;
        for (int j = 1; j < n + 1; j++) {
            newHeights[j] = heights[j - 1];
        }
        //单调栈中记录的是数组元素的下标,找每一个元素左右两边第一个小于该元素的下标
        Deque<Integer> monoStack = new ArrayDeque<>();
        monoStack.push(0);
        for (int i = 1; i < n + 2; i++) {
            while (newHeights[i] < newHeights[monoStack.peek()]) {
                int mid = monoStack.pop();
                int left = monoStack.peek();
                //w代表每一个元素左右两边第一个小于该元素的两个元素之间的宽度
                int w = i - left - 1;
                //h代表该元素的下标
                int h = newHeights[mid];
                //在(i, left)之间的元素均大于h,所以此时的矩形面积为w*h
                result = Math.max(w * h, result);
            }
            monoStack.push(i);
        }
        return result;
    }
}
