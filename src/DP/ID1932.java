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
        int[] values = new int[totalNum(n)];

        int index = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(s[i]);
            while (st.hasMoreTokens()) {
                values[index++] = Integer.parseInt(st.nextToken());
            }
        }
        int[]val = new int[values.length];

        int result = maxVal(val, n, 0, 0, 0, values);
        System.out.println(result);

    }

    private static int totalNum (int n) {
        int total = 0;
        for (int i = 1; i <= n; i++) 
            total += i;

        return total;
    }


    public static int maxVal(int[] val, int N, int n, int order, int pIndex, int[] input) {
        if (N == n+1) {
            val[n+order+pIndex] = input[n+order+pIndex];
            return val[n+order+pIndex];
        }

        if (val[n+order+pIndex] != 0) {
            return val[n+order+pIndex];
        }

        int max = 0;
        max = Integer.max(maxVal(val, N, n+1, 0, n+order+pIndex, input), maxVal(val, N, n+1, 1, n+order+pIndex, input));
        val[n+order+pIndex] = max + input[n+order+pIndex];

        return val[n+order+pIndex];
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