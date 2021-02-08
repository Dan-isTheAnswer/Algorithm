// https://www.acmicpc.net/problem/1149
package DAC;

class ID1149 {

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

        ID1149 m = new ID1149();
        int result = m.dac(table, n, -1);
        System.out.println(result);
    }

    // (table, 3, -1)
    public int dac(int[][] table, int n, int previous) {
        int N = table.length;
        if (n == 0)
            return 0;

        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (i != previous) {
                int comp = table[N-n][i] + dac(table, n-1, i);
                minVal = comp < minVal ? comp : minVal;
            }
        }

        return minVal;
    }

}
