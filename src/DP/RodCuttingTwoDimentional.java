package DP;


class RodCuttingTwoDimentional {
    
    private static int[][] cutRod(int[] price, int size) {
        int[][] val = new int[size+1][size+1];


        for (int i=1; i<size+1; i++) { // i: 1...size for val
            for (int j=0; j<size+1; j++) { // j: 1...size for val
                int maxVal = val[i-1][j];
                if (i==0 || j==0) {
                    maxVal = 0;
                } else if (i<=j){
                    int remaining = j-i;  
                    maxVal = Math.max(maxVal, price[i-1] + val[i][remaining]);
                } else {
                    maxVal = val[i-1][j]; 
                }

                val[i][j] = maxVal;
            }
        }

        return val;
    }

    public static void main(String[] args) {
        int[] price = {2, 5, 13, 19, 20};
        int size = 3;

        int[][] ans = cutRod(price, size);
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