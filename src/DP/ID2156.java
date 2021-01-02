// https://www.acmicpc.net/problem/2156
package DP;

// DP Top-down
class ID2156 {

    public static void main(String[] args) {
        int n = 6;
        // int[] values = new int[] {6, 10, 13, 9, 8, 1};
        int[] values = new int[] {999, 999, 1, 1, 999, 999};

        int result = answer(n, values);
        System.out.println(result);
    }


    public static int answer(int N, int[] values) {
        int[] val1 = new int[N]; // not seq
        int[] val2 = new int[N]; // seq

        int a = maxVal(N, false, 0, values, val1, val2);
        int b = maxVal(N, false, 1, values, val1, val2);
        // System.out.println(Arrays.toString(val1));
        // System.out.println();
        // System.out.println(Arrays.toString(val2));
        return Integer.max(a, b);
    }
    
    /**
     * DNC
     * Run (N, false, 0, values) and (N, false, 1, values) together.
     */
    public static int maxVal(int N, boolean isSeq, int index, int[] values, int[] val1, int[] val2) {
        if (N == 0 || index >= values.length) return 0; // values.length

        if (!isSeq && val1[index] != 0) {
            return val1[index];
        } else if (isSeq && val2[index] != 0) {
            return val2[index];
        }


        int max = 0;
        if (isSeq) {
            max = maxVal(N-1, false, index+2, values, val1, val2);
            max += values[index];
            val2[index] = max;

            return val2[index];
        } else {
            max = Integer.max(maxVal(N-1, true, index+1, values, val1, val2), maxVal(N-1, false, index+2, values, val1, val2));
            max += values[index];
            val1[index] = max;

            return val1[index];
        }
    }
}
// e.g. index: (1 -> 3 -> 4) > (2 -> 3 -> 4) 

