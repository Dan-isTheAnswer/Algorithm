package DP;

import java.util.Arrays;

/**
 * A DynamicProgramming solution for Rod cutting problem Returns the best
 * obtainable price for a rod of length n and price[] as prices of different
 * pieces
 */
class RodCutting {

    private static int[] cutRod(int[] price, int n) {
        int[] val = new int[n+1];
        val[0] = 0;

        for (int i = 1; i <= n; i++) {
            int max_val = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) max_val = Math.max(max_val, price[j] + val[i-1 -j]);

            val[i] = max_val;
        }

        return val;
    }

    public static void main(String[] args) {
        // Let's see the whole result!!
        int[] arr = new int[] {2, 5, 13, 19, 20};
        for (int arrSize = 1; arrSize<= arr.length; arrSize++) {
            int[] limitedArr = Arrays.copyOf(arr, arr.length);
            Arrays.fill(limitedArr, arrSize, arr.length, 0);

            System.out.println("Item " + arrSize + " available: ");
            int n = 5; // price length. 
            int[] result = cutRod(limitedArr, n);
            for (int i=1; i<arr.length+1; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
        }
        
    }
}

