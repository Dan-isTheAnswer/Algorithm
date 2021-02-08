// https://www.acmicpc.net/problem/2579
package DP;

class ID2579 {
    int[][] val;
    
    public static void main(String[] args) {
        int n = 6;
        int[] inputs = {10, 20, 15, 25, 10, 20};

        ID2579 m = new ID2579();
        m.val = new int[n][3]; // [n][count of sequential steps]
        int result = m.solve(inputs, 1, n-1);
        System.out.println(result);
    }

    // from Top to Bottom
    // (inputs, 1, n-1)
    public int solve(int[] inputs, int cnt, int n) {
        if (n < 0) 
            return 0;

        
        int maxVal = Integer.MIN_VALUE;

        int comp1 = 0;
        if (cnt != 2) {
            if (val[n][cnt+1] != 0) {
                comp1 = val[n][cnt+1];
            } else {
                comp1 = inputs[n] + solve(inputs, cnt+1, n-1);
                if (val[n][cnt+1] < comp1) // update
                    val[n][cnt+1] = comp1;
            }
        }
        int comp2 = 0;
        if (val[n][1] != 0) {
            comp2 = val[n][1];
        } else {
            comp2 = inputs[n] + solve(inputs, 1, n-2);
            if (val[n][1] < comp2) // update 
                val[n][1] = comp2;
        }

        int comp = Math.max(comp1, comp2);
        maxVal = Math.max(maxVal, comp);
             
        return maxVal;
    }
}

/**
 * int[][] val should be easily referenced like I did here.
 * For example, new val[n][count of steps]. 
 * Thus, I can easily refer to val[n] based on count of steps!!
 * 
 * The same goes for ID1149. 
 * From the case of ID1149, new val[n][RGB].
 * Thus, I can refer to val[n] based on its color. 
 */