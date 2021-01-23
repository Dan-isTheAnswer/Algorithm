package DP;

class RodCutting_Fin {

    // DP: 2D-array
    private static int[][] cutRod(int[] prices, int size) {
        int[][] val = new int[size+1][size+1];


        for (int i=1; i<size+1; i++) { // i: 1...size for val
            for (int j=0; j<size+1; j++) { // j: 1...size for val
                int maxVal = val[i-1][j];
                if (i==0 || j==0) {
                    maxVal = 0;
                } else if (i<=j){
                    int remaining = j-i;  
                    maxVal = Math.max(maxVal, prices[i-1] + val[i][remaining]);
                } else {
                    maxVal = val[i-1][j]; 
                }

                val[i][j] = maxVal;
            }
        }

        return val;
    }

    public static void main(String[] args) {
        int[] prices = new int[] {2,5,13,19,20};
        int size = 5;
        int[][] ans = cutRod(prices, size);
        int result = ans[5][5];
        
        System.out.println(result);
    }

    public static void printAns(int[][] ans, int size) {
        for (int i=0; i<size+1; i++) {
            System.out.println(i + "\'s row: ");
            int[] a = ans[i];
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }
}
