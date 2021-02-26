// https://www.acmicpc.net/problem/1003
package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class ID1003 {

    static int[][] val;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            max = Integer.max(max, nums[i]);
        }
        
        val = new int[max+1][2];
        for (int i = 0; i < max+1; i++) {
            Arrays.fill(val[i], -1);
        }

        // print
        // for (int[] arr : val) {
        //     System.out.println(Arrays.toString(arr));
        // }

        for (int e : nums) {
            fibo(e);
            System.out.println(val[e][0]+ " " + val[e][1]);
        }
        

        // print
        // for (int[] arr : val) {
        //     System.out.println(Arrays.toString(arr));
        // }
    }

    private static int[] fibo(int n) {
        if (n == 0) {
            // zero++;
            val[0][0] = 1;
            val[0][1] = 0;
            return new int[]{1, 0};
        } else if (n == 1) {
            // one++;
            val[1][0] = 0;
            val[1][1] = 1;
            return new int[]{0, 1};
        } else {

            if (val[n][0] != -1) {
                return new int[]{val[n][0], val[n][1]};
            }

            int[] a = fibo(n-1);
            int[] b = fibo(n-2);
            val[n][0] = a[0] + b[0];
            val[n][1] = a[1] + b[1];

            return new int[]{val[n][0], val[n][1]};
        }
    }
}

/**
 * In terms of Performance: BufferedReader is better than Scanner
 */