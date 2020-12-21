package DP;

/** Refactored: A Brute-force-based solution for 0-1 Knapsack problem */
public class Knapsack01 {

    // Brute-force
    private static int knapSack(int w, int[] values, int[] weights, int numItems) {

            if (numItems == 0 || w == 0) return 0; // base case

            // Value without the current item vs Value with the current item
            int valWithout = knapSack(w, values, weights, numItems-1);
            if (weights[numItems-1] > w) 
                return valWithout;
            else 
                return Integer.max(values[numItems-1] + knapSack(w-weights[numItems-1], values, weights, numItems-1), 
                                        valWithout);
            
    }

  // Driver program to test above function
  public static void main(String args[]) {
        int[] values = new int[] {24, 18, 18, 10};
        int[] weights = new int[] {24, 10, 10, 7};
        int w = 25;
        int result = knapSack(w, values, weights, 4);
        System.out.println(result);
  }
}

// https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/