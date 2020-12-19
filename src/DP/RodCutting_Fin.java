package DP;

class RodCutting_Fin {

    // DP: Top-down
    private static int cutRod(int[] prices, int[] val, int size) {
        if (size == 0) return 0; // base case

        if (val[size] > 0) {
            return val[size];
        } 

        int maxVal = Integer.MIN_VALUE; // flag
        for (int i = 0; i < size; i++) {
            maxVal = Math.max(maxVal, prices[i] + cutRod(prices, val, size-1 -i));
        }
        val[size] = maxVal;

        return val[size];
    }

    public static void main(String[] args) {
        int[] prices = new int[] {2,5,13,19,20};
        int size = 5;
        int[] val = new int[size+1];
        int result = cutRod(prices, val, size);
        
        System.out.println(result);
    }
}