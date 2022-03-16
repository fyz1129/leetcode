package question1143;


/**
 * @author Dell
 */
public class Question1143 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.longestCommonSubsequence("ezupkr", "ubmrapg");
        System.out.println(i);
    }
}

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        if (len1 == 0 || len2 == 0) {
            return 0;
        }
        int result = 0;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            //dp[i][0] = dp[i - 1][len2];
            for (int j = 1; j <= len2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    //System.out.println(text1.charAt(i - 1));
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
                if (dp[i][j] > result) {
                    result = dp[i][j];
                }
            }
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                System.out.print(dp[i][j] + ",");
            }
            System.out.println();
        }
        return result;
    }
}

