package DP;


class RodCutting {

    private static int cutRod(int[] prices, int size) {
        int[] val = new int[size+1];
        val[0] = 0;

        for (int i = 1; i <= size; i++) {
            int max_val = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) { // j for price
                int ceiling = i-1;
                int remaining = ceiling -j; // from ceiling to 0
                int newVal = prices[j] + val[remaining];
                max_val = Math.max(max_val, newVal); // from prices[0] to prices[ceiling]
            }
            val[i] = max_val;
        }

        return val[size];
    }

    public static void main(String[] args) {
        int[] prices = new int[] {2, 5, 13, 19, 20};
        int size = 5;
        int result = cutRod(prices, size);

        System.out.println(result);
    }
}

// val[0] = 0
/* i\j  0   1   2   3   4   
 * 1    2   -   -   -   -   
 * 2    4   5   -   -   -   
 * 3    7   7   13  -   -   
 * 4    15  15  15  19  -   
 * 5    21  21  21  21  21  
 */
