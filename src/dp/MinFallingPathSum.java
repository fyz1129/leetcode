package dp;

import java.util.Arrays;

public class MinFallingPathSum {

    public static void main(String[] args) {
        MinFallingPathSum mfp = new MinFallingPathSum();
        System.out.println(mfp.minFallingPathSum(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}));
    }

    int n;

    int[][] memo;

    int[][] m;

    public int minFallingPathSum(int[][] matrix) {
        n = matrix.length;
        int res = Integer.MAX_VALUE;
        m = matrix;
        for(int i = 0; i < n; i++) {
            memo = new int[n][n];
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }
        for(int i = 0; i < n; i++) {
            dfs(0, i);
        }
        return Arrays.stream(memo[0]).min().getAsInt();
    }

    private int dfs(int row, int col) {
        if(row == n - 1) {
            //System.out.println(row + " " + col);
            return memo[row][col] = m[row][col];
        }
        if(memo[row][col] != Integer.MAX_VALUE) {
            return memo[row][col];
        }
        return memo[row][col] = Math.min(Math.min(dfs(row + 1, col - 1), dfs(row + 1, col)), dfs(row + 1, col + 1)) + m[row][col];
    }
}
