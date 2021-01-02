// https://www.acmicpc.net/problem/1932
package DP;

import java.util.StringTokenizer;

// DP: Top-down
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

        StringTokenizer st;
        int[] values = new int[totalNum(4)];

        int index = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(s[i]);
            while (st.hasMoreTokens()) {
                values[index++] = Integer.parseInt(st.nextToken());
            }
        }
        int[]val = new int[values.length];

        int result = maxVal(n, n, 0, values, val);
        System.out.println(result);

    }

    private static int totalNum(int n) {
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total += i;
        }

        return total;
    }

    public static int maxVal(int N, int n, int index, int[] input, int[] val) {
        if (n == 0 || index >= input.length) return 0; // base case

        if (val[index] != 0) return val[index];

        int level = N -n; // from 0 to 3

        int max = 0; 
        max = Integer.max(maxVal(N, n-1, level + index +1, input, val), 
                          maxVal(N, n-1, level + index +2, input, val));
        max += input[index];
        val[index] = max;

        return val[index];
    }

}

/**
 * Rule of Thumb: Fomula must be simple. 
 * The reason why the hierarchical level is from 0 to N-1, not from 1 to N, 
 * is that by doing so predictable and less changeable:)
 */

/**
 * Look at the position of current index and child index in the maxVal method. 
 * Current index is handed over through a method parameter. 
 * And, child index will be handed over recursively. 
 */

/**
 * recommend DAC -> DP 
 * because, the less num of parameters you have, the easier to implement. 
 */


/**
 * you can use 2D-Array (Grid) and 1D-Array (optimzied values).
* I think using 2D-Array is easier to solve DP. 
*/