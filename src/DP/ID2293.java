// https://www.acmicpc.net/problem/2293
package DP;

class ID2293 {
    static int n, k;
    static int[] coins;
    static int[] dp;


    public static void main(String[] args) {
        n = 3; k = 10;
        coins = new int[] {1, 2, 5};

        ID2293 m = new ID2293();
        m.solve(); 
    }

    // bottom-up
    public void solve() {
        dp = new int[k+1];
        dp[0] = 1;
        for(int i=0; i<n; i++){
            for(int j=coins[i]; j<=k; j++){
                dp[j] += dp[j-coins[i]];
            }
        }
        System.out.println(dp[k]);
    }
}


