package question42;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Dell
 */
public class Question42 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int trap = solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(trap);
    }
}

class Solution {
    public int trap(int[] height) {
        Deque<Integer> monoStack = new ArrayDeque<>();
        int n = height.length;
        int result = 0;
        if (n <= 1) {
            return result;
        }
        int[] bigger = new int[n];
        for (int i = 0; i < n; i++) {
            while (!monoStack.isEmpty() && height[i] >= height[monoStack.peek()]) {
                int index = monoStack.pop();
                bigger[index] = i;
            }
            monoStack.push(i);
        }
        for (int j = 0; j < n; j++) {
            if (height[j] == 0) {
                continue;
            }
            int biggerIndex = bigger[j];
            for (int k = j + 1; k < biggerIndex; k++) {
                //System.out.println(height[j] - height[k]);
                result += height[j] - height[k];
            }
            j = biggerIndex - 1;
            System.out.println(j);
        }
        return result;
    }
}