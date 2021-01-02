// https://www.acmicpc.net/problem/2156
package Recursive;

// Divide and Conquer 
class ID2156 {

    public static void main(String[] args) {
        int n = 6;
        // int[] values = new int[] {6, 10, 13, 9, 8, 1};
        int[] values = new int[] {999, 999, 1, 1, 999, 999};

        int result = answer(n, values);
        System.out.println(result);
    }


    public static int answer(int N, int[] values) {

        int a = maxVal(N, false, 0, values);
        int b = maxVal(N, false, 1, values);

        return Integer.max(a, b);
    }
    
    /**
     * DNC
     * Run (N, false, 0, values) and (N, false, 1, values) together.
     */
    public static int maxVal(int N, boolean isSeq, int index, int[] values) {
        if (N == 0 || index >= values.length) return 0;

        int max = 0;
        if (isSeq) {
            // max = Integer.max(0, maxVal(N-1, false, index+2, values));
            max = Integer.max(maxVal(N-1, false, index+2, values), maxVal(N-1, false, index+3, values));
        } else {
            max = Integer.max(maxVal(N-1, true, index+1, values), maxVal(N-1, false, index+2, values));
        }
        max += values[index];

        return max;
    }
}
