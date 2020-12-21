package DP;

/** A DynamicProgramming based solution for 0-1 Knapsack problem */
public class Knapsack01 {

  private static int knapSack(int w, int values[], int[] weights, int numItems) throws IllegalArgumentException {
    if (weights == null || values == null) throw new IllegalArgumentException();
    int rv[][] = new int[numItems + 1][w + 1]; // rv means return value

    // Build table rv[][] in bottom up manner
    for (int i = 0; i <= numItems; i++) { // i for index of items.
      for (int j = 0; j <= w; j++) { // j for index of weights. 
        if (i == 0 || j == 0) rv[i][j] = 0;
        else if (weights[i - 1] <= j)
          rv[i][j] = Math.max(values[i - 1] + rv[i - 1][j - weights[i - 1]], rv[i - 1][j]);
        else rv[i][j] = rv[i - 1][j];
      }
    }

    return rv[numItems][w];
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
