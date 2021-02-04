// https://www.acmicpc.net/problem/1010
package DAC;

class ID1010 {

    public static void main(String[] args) {
        int n = 13;
        int m = 29;

        int result = dac(n, m);
        System.out.println(result);
    }

    private static int dac(int n, int m) {
        if (n == 1) {
            return m;
        }

        int total = 0;
        for (int i = n-1; i < m; i++) {
            total += dac(n-1, i);
        }
        return total;
    }
}
// If u got in any trouble, plz look at DP/ID1010.java 