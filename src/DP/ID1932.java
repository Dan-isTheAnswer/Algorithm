// https://www.acmicpc.net/problem/1932
package DP;

import java.util.StringTokenizer;

// DP: Bottom-up
class ID1932 {

    public static void main(String[] args) {
        int n = 4;
        String tree1 = "7";
        String tree2 = "3 8 ";
        String tree3 = "8 1 0 ";
        String tree4 = "2 7 4 4 ";
        String[] s = new String[n];
        s[0] = tree1;
        s[1] = tree2;
        s[2] = tree3;
        s[3] = tree4;


        
        int[][] list = new int[n][n];
        int[][] dp = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(s[i]);
            for (int j = 0; j <= i; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());

                if (i == n -1) {
                    dp[i][j] = list[i][j]; // values in the last line. 
                }
            }
        }

        for (int i = n -2; i>= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = list[i][j] + Math.max(dp[i+1][j], dp[i+1][j+1]);
            }
        }

        System.out.println(dp[0][0]);

    }
}

/**
 * recommend DAC -> DP 
 * because, the less num of parameters you have, the easier to implement. 
 */

 /**
  * parameters: flag, input[], DP-val[]. 
  * if flag comes down to 0, you have one flag. 
  * e.g. if (flag == 0) return;
  * if not, you have two flags. 
  * e.g. if (neverChangedFlag == flag) return; 
  */

  /**
   * you can use 2D-Array (Grid) and 1D-Array (optimzied values).
   * I think using 2D-Array is easier to solve DP. 
   */