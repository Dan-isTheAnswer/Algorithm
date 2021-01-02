// https://www.acmicpc.net/problem/2156
package DP;

// DP Top-down
class ID2156 {

    public static void main(String[] args) {
        int n = 6;
        // int[] values = new int[] {0, 6, 10, 13, 9, 8, 1};
        int[] values = new int[] {0, 999, 999, 1, 1, 999, 999};

        int result = answer(n, values);
        System.out.println(result);
    }


    public static int answer(int n, int[] values) {
        int[] dp = new int[10001];
        
        dp[1] = values[1];
        dp[2] = dp[1] + values[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Integer.max(Integer.max(dp[i-1], dp[i-2] + values[i]), dp[i-3] + values[i-1] + values[i]);
            // System.out.println(dp[i]);
        }

        return dp[n];
    }
}
/**
 * three cases:
 * 1) dp[i-1]
 * 2) dp[i-2] + values[i]
 * 3) dp[i-3] + values[i-1] + values[i]
 */