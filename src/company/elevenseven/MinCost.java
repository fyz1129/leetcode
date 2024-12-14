package company.elevenseven;

public class MinCost {

    public static int minCost(int n, int[][] a) {
        // 初始化 dp 数组，dp[i][j] 表示前 i 个人中，去 a 地的人的数量为 j 时的最小花费
        int[][] dp = new int[n + 1][n + 1];

        // 初始化 dp 数组，dp[i][j] 默认值是无穷大
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        // 边界条件
        dp[0][0] = 0;  // 没有人时，花费为 0

        // 动态规划转移
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {  // 去 a 地的人数为 j 时，最多有 i 个人
                if (Math.abs(j - (i - j)) > 1) {  // 如果人数差超过 1，跳过
                    continue;
                }

                // 第 i 个人选择去 a 地
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + a[i - 1][0]);
                }

                // 第 i 个人选择去 b 地
                if (j < i) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + a[i - 1][1]);
                }
            }
        }

        // 返回去 a 地和去 b 地人数差不超过 1 时的最小花费
        return Math.min(dp[n][n / 2], dp[n][(n + 1) / 2]);
    }

    public static void main(String[] args) {
        // 示例
        int n = 4;
        int[][] a = {
                {1, 2},
                {2, 1},
                {3, 4},
                {4, 3}
        };

        System.out.println(minCost(n, a));  // 输出最小花费
    }
}

