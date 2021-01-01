// https://www.acmicpc.net/problem/1932
package DP;

import java.util.ArrayList;
import java.util.List;
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
        List<Integer> values = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(s[i]);
            while (st.hasMoreTokens()) {
                Integer e = Integer.parseInt(st.nextToken());
                values.add(e);
            }
        }
        int[]val = new int[values.size()];

        int result = maxVal(val, n, 0, 0, 0, values);
        System.out.println(result);

    }

    /**
     * 
     * @param val is array of DP values
     * @param N is total level (flag 1).
     * @param n is hierarchical level from 0 to N-1 (flag 2)  
     * @param order is indicator. If order == 0, left. If order == 1, right. 
     * @param parent is parent index. 
     * @param input is array of input values. 
     * @return max value
     */
    public static int maxVal(int[] val, int N, int n, int order, int parent, List<Integer> input) {
        int child = n + order + parent; // child of the parent

        if (N == n+1) { // base case
            val[child] = input.get(child);
            return val[child];
        }

        if (val[child] != 0) {
            return val[child];
        }

        int max = 0;
        max = Integer.max(maxVal(val, N, n+1, 0, child, input), maxVal(val, N, n+1, 1, child, input));
        val[child] = max + input.get(child);

        return val[child];
    }
}

/**
 * Rule of Thumb: Fomula must be simple. 
 * The reason why the hierarchical level is from 0 to N-1, not from 1 to N, 
 * is that by doing so predictable and less changeable:)
 */

/**
 * Look at the position of parent index and child index in the maxVal method. 
 * Parent index is considered a parameter 
 * while child index is considered the processing index. 
 */

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