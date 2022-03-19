package question239;

import java.util.LinkedList;

/**
 * @author Dell
 */
public class Question239 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, -1};
        int[] maxSlidingWindow = solution.maxSlidingWindow(nums, 1);
        for (int i : maxSlidingWindow) {
            System.out.println("i = " + i);
        }

    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            while(!queue.isEmpty() && nums[i] > queue.peekLast()){
                queue.pollLast();
            }
            queue.offer(nums[i]);
            if(queue.size() > k){
                queue.poll();
            }
            if(i >= k - 1){
                ans[i - k + 1] = queue.peek();
            }
            for (int j = 0; j < queue.size(); j++) {
                System.out.print(queue.get(j) + ",");
            }
            System.out.println();
        }
        return ans;
    }
}
