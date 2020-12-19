package DP;

class RodCutting_Fin {

    // DP: Bottom-up
    private static int cutRod(int[] prices, int size) {
        int[] val = new int[size+1];

        val[0] = 0;
        for (int i = 1; i < size+1; i++) { // i for controling size and index of each val.
            int maxVal = Integer.MIN_VALUE; // flag
            for (int j = 0; j < i; j++) {
                maxVal = Math.max(maxVal, prices[j] + val[i-1 -j]);
            }
            val[i] = maxVal;
        }

        return val[size];
    }

    public static void main(String[] args) {
        int[] prices = new int[] {2,5,13,19,20};
        int size = 5;
        int result = cutRod(prices, size);
        
        System.out.println(result);
    }
}