package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 120
 */
public class MinimumTotal {

    public static void main(String[] args) {
        args = new String[]{"1", "2"};
        System.out.println(Arrays.stream(args).min(String::compareToIgnoreCase).get());
    }

    List<List<Integer>> res;
    int n;
    int[][] dp = new int[n][n];

    public int minimumTotal(List<List<Integer>> triangle) {
        res = triangle;
        n = triangle.size();
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        return dfs(0, 0);
    }

    private int dfs(int row, int col) {
        if (row == n - 1) {
            return res.get(row).get(col);
        }
        if (dp[row][col] != Integer.MIN_VALUE) {
            return dp[row][col];
        }
        return Math.min(dfs(row + 1, col), dfs(row + 1, col + 1)) + res.get(row).get(col);
    }
}
