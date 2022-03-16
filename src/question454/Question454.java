package question454;

import java.util.HashMap;

/**
 * @author Dell
 */
public class Question454 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] n1 = {-1, -1};
        int[] n2 = {-1, 1};
        int[] n3 = {-1, 1};
        int[] n4 = {1, -1};
        System.out.println(solution.fourSumCount(n1, n2, n3, n4));
    }
}

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        HashMap<Integer, Integer> set = new HashMap<>();
        for (int value : nums1) {
            for (int j = 0; j < n; j++) {
                int sum = value + nums2[j];
                set.put(sum, set.getOrDefault(sum, 0) + 1);
            }
        }
    int result = 0;
        for(int m = 0; m < n; m++){
            for(int k = 0; k < n; k++){
                if(!set.isEmpty() && set.containsKey(-nums3[m] - nums4[k])){
                    result += set.get(-nums3[m] - nums4[k]);
                }
            }
        }
        return result;
    }
}
