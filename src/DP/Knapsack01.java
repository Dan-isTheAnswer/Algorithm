package DP;

/** A Brute-force-based solution for 0-1 Knapsack problem */
public class Knapsack01 {

    // Brute-force
    private static int knapSack(int w, int[] values, int[] weights, int numItems) {

            // precondition: weights must be in ascending order. 
            if (numItems == 0 || w < weights[0]) return 0; //base case

            int maxVal = Integer.MIN_VALUE;
            for (int i = 0; i < numItems; i++) {
                int valWithout = knapSack(w, values, weights, numItems-1 -i);
                if (w >= weights[numItems-1]) {
                    int valWith = values[numItems-1] + knapSack(w-weights[numItems-1], values, weights, numItems-1 -i);

                    // maxVal vs value without the current item vs value with the current item
                    maxVal = Integer.max(maxVal, valWithout);
                    maxVal = Integer.max(maxVal, valWith);
                }
                else {
                    maxVal = Integer.max(maxVal, valWithout);
                }
            }

            return maxVal;
    }

  // Driver program to test above function
  public static void main(String args[]) {
    int val[] = new int[] {50, 100, 130};
    int wt[] = new int[] {10, 20, 40};
    int W = 50;
    int n = val.length;
    System.out.println(knapSack(W, val, wt, n));
  }
}
