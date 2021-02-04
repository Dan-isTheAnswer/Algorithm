// https://www.acmicpc.net/problem/1010
package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ID1010{

    public static void main(String[] args) throws IOException {
        // int n = 13;
        // int m = 29;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        ID1010 bridge = new ID1010();
        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            int result = bridge.solve(n, m);
            System.out.println(result);
        }

    }

    public int solve(int n, int m) {
        int[][] val = new int[n+1][m+1];
        for (int i = 1; i < m+1; i++) {
            val[1][i] = i;
        }

        for (int i = 2; i < n+1; i++) {
            for (int j = i; j < m+1; j++) {
                if (val[i][j-1] != 0) {
                    val[i][j] = val[i][j-1] + val[i-1][j-1];
                } else {
                    val[i][j] = 1;
                }
                
            }
        }

        return val[n][m];
    }
}

/**
 * (n\m) = val[n][m-1] + val[n-1][m-1]
 *  n\m 1 2 3 4 5 6 
 *  1   1 2 3 4 5 6 
 *  2   / 1 3 6 10 15
 *  3   / / 1 4 10 20
 * 
 * For example, in the case of n = 2 (a1, a2) and m = 3 (b1, b2, b3), 
 * if a bride is set between a1 and b1, you get the num of cases for n = 1 and m = 2.
 * If a bride is set between a1 and b2, you get the num of cases for n = 1 and m = 1.
 * In the end, the num of cases for n = 2 and m = 3 is 1 + 2. 
 */