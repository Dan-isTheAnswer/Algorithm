package DP;

class RodCutting_Fin {

    // Brute-force
    private static int cutRod(int[] prices, int size) {
        if (size == 0) return 0; // base case 

        int maxVal = Integer.MIN_VALUE; // flag
        for (int i = 0; i < size; i++) {
            maxVal = Math.max(maxVal, prices[i] + cutRod(prices, size-1 -i));
        }

        return maxVal;
    }

    public static void main(String[] args) {
        int[] prices = new int[] {2,5,13,19,20};
        int size = 5;
        int result = cutRod(prices, size);
        
        System.out.println(result);
    }
}