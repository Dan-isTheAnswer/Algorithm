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
        dp[0] = 1; // **for itself

        for (int coin : coins) {
            for (int i = coin; i <= k; i++) {
                dp[i] = dp[i] + dp[i-coin];
            }
        }
        printDP(dp);
        System.out.println(dp[k]);
    }

    private static void printDP(int[] dp) {
        for (int n : dp) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
// "사용한 동전의 구성이 같은데, 순서만 다른 것은 같은 경우이다." == optimal substructure

/** 
 * For example, we want to know how many cases for the specific total(k) are 
 * with coin 1 and 2.
 *  
 * If k = 10,
 * The cases depends on the number of cases with coin 1.
 * i.e. 2 occurrs once equals to num of cases for 8 with coin 1.
 * i.e. 2 occurrs twice equals to num of cases for 6 with coin 1. 
 * i.e. 2 occurs fifth times equals to num of cases for 0 with coin 1.
 */

/**
 * The main key to this problem is how you think of grid
 * and dp[0] = 1.
 */
