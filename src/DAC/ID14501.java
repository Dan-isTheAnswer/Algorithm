// https://www.acmicpc.net/problem/14501
package DAC;

import java.util.ArrayList;
import java.util.List;

class ID14501 {

    private static class Consult {
        int time;
        int value;

        public Consult(int time, int value) {
            this.time = time;
            this.value = value;
        }

    }

    public static void main(String[] args) {
        int n = 10;
        List<Consult> inputs = new ArrayList<>(n);
        inputs.add(new Consult(1, 1));
        inputs.add(new Consult(1, 2));
        inputs.add(new Consult(1, 3));
        inputs.add(new Consult(1, 4));
        inputs.add(new Consult(1, 5));
        inputs.add(new Consult(1, 6));
        inputs.add(new Consult(1, 7));
        inputs.add(new Consult(1, 8));
        inputs.add(new Consult(1, 9));
        inputs.add(new Consult(1, 10));

        
        ID14501 m = new ID14501();
        int result = m.solve(n, inputs, 0);
        System.out.println(result);
    }

    // (n, inputs, 0)
    public int solve(int n, List<Consult> inputs, int next) {
        if (n == next) 
            return 0;

        int maxVal = 0;
        for (int i = next; i < n; i++) {
            if (inputs.get(i).time + i <= n) {
                maxVal = Integer.max(maxVal, inputs.get(i).value + solve(n, inputs, i + inputs.get(i).time));
            }
        }

        return maxVal;
    }
}

/**
 * DAC or DP: i.e. number of cases or optimized value
 * 1) Draw a table
 * 2) According to case 1, think
 * 3) Code
 */