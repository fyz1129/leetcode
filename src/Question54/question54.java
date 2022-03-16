package Question54;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dell
 */
public class question54 {
    public static void main(String[] args) {
        Solution s = new Solution();
        //List<Integer> integers = s.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        List<Integer> integers = s.spiralOrder(new int[][]{{6, 9, 7}});
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        int top = 0;
        int left = 0;
        int bottom = m - 1;
        int right = n - 1;
        while(top <= bottom && left <= right){
            for(int i = left; i <= right; i++){
                System.out.println("top = " + top);
                System.out.println("bottom = " + bottom);
                //System.out.println(i);
                result.add(matrix[top][i]);
            }

            for(int j = top + 1; j <= bottom; j++){
                result.add(matrix[j][right]);
            }
            if(left < right && top < bottom){
                for(int k = right - 1; k > left; k--){
                    result.add(matrix[bottom][k]);
                }

                for(int l = bottom; l > top; l--){
                    result.add(matrix[l][left]);
                }
            }
            left++;
            top++;
            bottom--;
            right--;
        }
        return result;
    }
}