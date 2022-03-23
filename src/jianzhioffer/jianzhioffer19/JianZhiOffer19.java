package jianzhioffer.jianzhioffer19;

/**
 * @author Dell
 */
public class JianZhiOffer19 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean match = solution.isMatch("aa", "a*");
        //System.out.println(match);
    }
}

class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        //dp[0][0]表示当s，p均为空字符串时可以匹配
        dp[0][0] = true;
        //dp[0][1]表示s="",p有一个字符，这肯定不能匹配，只有一个字符是不能为*
        //初始化s为空字符串时，p能否匹配
        for(int i = 2; i <= n; i += 2) {
            //p的下标为0~i-3个字符能否匹配空字符串，并且p下标i-1的字符是否为*,这样可以把p下标为i-2的字符令为零个
            dp[0][i] = dp[0][i - 2] && p.charAt(i - 1) == '*';
            //System.out.println(p.charAt(i - 1) == '*');
        }

        for(int j = 1; j <= m; j++) {
            for(int k = 1; k <= n; k++) {
                //如果p下标k-1的字符为*
                if(p.charAt(k - 1) == '*') {
                    //如果p.substring[0, k - 2)能匹配当前的s.substring[0, j), 则p下标为k-2的字符令为零个即可
                    if(dp[j][k - 2]) {
                        dp[j][k] = true;
                    }
                    //如果p.substring[0, k)能匹配当前的s.substring[0, j - 1), 则让s下标为j-1的字符等于p下标为k-2的字符
                    //'*'号的作用是让p下标为k-2的字符多一个
                    else if(dp[j - 1][k] && s.charAt(j - 1) == p.charAt(k - 2)){
                        //System.out.println("fyz");
                        dp[j][k] = true;
                    }
                    //如果p.substring[0, k)能匹配当前的s.substring[0, j - 1), p下标为k-2的字符为'.'（'*'前面的字符为'.'）
                    //可以让'.'多一个即可
                    else if(dp[j - 1][k] && p.charAt(k - 2) == '.'){
                        dp[j][k] = true;
                    }
                }
                //如果p下标k-1的字符不为*
                else{
                    //如果p.substring[0, k - 1)能匹配当前的s.substring[0, j - 1), 则让s下标为j-1的字符等于p下标为k-1的字符
                    if(dp[j - 1][k - 1] && s.charAt(j - 1) == p.charAt(k - 1)){
                        dp[j][k] = true;
                    }
                    //如果p.substring[0, k - 1)能匹配当前的s.substring[0, j - 1), 则让p下标为k-1的字符为'.'即可
                    else if(dp[j - 1][k - 1] && p.charAt(k - 1) == '.') {
                        dp[j][k] = true;
                    }
                }
            }
        }
        for (boolean[] booleans : dp) {
            for (boolean b : booleans) {
                System.out.print(b + ",");
            }
            System.out.println();
        }
        return dp[m][n];
    }
}
