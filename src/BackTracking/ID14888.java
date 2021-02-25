// https://www.acmicpc.net/problem/14888
package BackTracking;


class ID14888 {
    static int n;
    static int[] input;
    static int[] ops;
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) {
        n = 3;
        input = new int[]{3, 4, 5};
        ops = new int[]{1, 0, 1, 0}; // + - * /
        // n = 6;
        // input = new int[]{1,2,3,4,5,6};
        // ops = new int[]{2, 1, 1, 1};


        solve(0, input[0]);
        System.out.println(MAX);
        System.out.println(MIN);

    }

    // recursive
    // (tmpops, 0, 0) 
    private static void solve(int pos, int val) {
        if (pos == input.length-1) {
            if (val > MAX) MAX = val;
            if (val < MIN) MIN = val;
            return;
        }
            
        int result = 0;
        for (int i = 0; i < ops.length; i++) {
            if (ops[i] == 0) continue;
            ops[i]--;
            if (i == 0) result = val+ input[pos+1]; 
            if (i == 1) result = val- input[pos+1];
            if (i == 2) result = val* input[pos+1];
            if (i == 3) result = val/ input[pos+1];

            solve(pos+1, result);
            ops[i]++; //backtracking
        }

    }
}
/**
 * Note that you don't need to copy of the val array
 * For example, int[] tmpops = Arrays.copyOf(operations, operations.length);
 * is unnecessary since we backtrack the array. 
 */