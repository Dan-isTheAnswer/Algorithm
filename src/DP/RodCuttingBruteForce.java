package DP; 

class RodCuttingBruteForce {

    private static int rodCutting(int[] price, int len) {
        if (len<=0) return 0;
        int max_len = Integer.MIN_VALUE;
        for (int i=0; i<len; i++) {
            max_len = Math.max(max_len, price[i] + rodCutting(price, len-(i+1)));
        }

        return max_len;
    }

    public static void main(String[] args) {
        int[] price = {2,5,13,19,20};
        int rod_len = 5;
        System.out.println(rodCutting(price, rod_len));
    }
}