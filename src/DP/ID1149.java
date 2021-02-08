// https://www.acmicpc.net/problem/1149
package DP;

class Main {
    int[][] val;

    public static void main(String[] args) {
        int n = 3;

        String[] inputs = { // ans is 26 + 57 + 13 = 96;
            "26 40 83",
            "49 60 57",
            "13 89 99"
        };

        int[][] table = new int[n][3];
        for (int i = 0; i < n; i++) {
            String[] input = inputs[i].split(" ");
            for (int j = 0; j < 3; j++) {
                table[i][j] = Integer.parseInt(input[j]);
            }
        }

        Main m = new Main();
        m.val = new int[n][3]; // [n][RGB]
        int result = m.solve(table, n, -1);  
        System.out.println(result);
    }

    // (table, 3, -1): -1 means nothing is its previous one.
    public int solve(int[][] table, int n, int previous) {
        int N = table.length;
        if (n == 0)
            return 0;

        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (i != previous) {
                int comp = 0;
                if (val[N-n][i] != 0) {
                    comp = val[N-n][i]; 
                } else {
                    comp = table[N-n][i] + solve(table, n-1, i);
                }

                if (comp < minVal) {
                    minVal = comp;
                    val[N-n][i] = minVal; // update
                }
            }
        }

        return minVal;
    }

}
