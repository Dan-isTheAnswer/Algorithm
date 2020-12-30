// https://www.acmicpc.net/problem/2579
package DP;

// DP
class ID2579 {
    
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int N = sc.nextInt();
        // int[] values = new int[N];
        // for (int i = 0; i < N; i++) {
        //     values[i] = sc.nextInt();
        // }
        // sc.close();
        
        int N = 5;
        int[] values = new int[] {10, 20, 15, 25, 10, 20};

        int[] val = new int[N+1];
        int result = whatIsTheMaxVal(N, values, val);
        System.out.println(result);
    }

    public static int whatIsTheMaxVal(int n, int[] values, int[] val) {

        if (n <= 0) return 0; // base case;
        else if (n == 1) return values[0];

        
        if (val[n] != 0) return val[n];

        int a = 0;
        int b = 0;
        if (n >= 2) {
            a = whatIsTheMaxVal(n-2, values, val) + values[n-1];
            b = whatIsTheMaxVal(n-3, values, val) + values[n-2] + values[n-1]; 
        }

        val[n] = Math.max(a,b);

        return val[n];
    }
}
/**
 * 3 Conditions
 * 1. You can step on first step or second step from the start.
 * 2. You can't step on three steps in a row.
 * 3. You must step on the destinations's step. 
 */

/**
 * Steps : cases
 * 0: 0
 * 1: 1 case= values[1];
 * 2: 2 cases= values[2];    values[1]+values[2];
 * 3: 2 cases= values[1]+values[3];    values[2]+values[3];
 * 4: 3 cases= values[1]+values[2]+values[4];    values[1]+values[3]+values[4];    values[2]+values[4];
 * 5: 4 cases= case(3) + values[5];    case(2) + values[4]+values[5];
 * 
 * n: case(n-2)+case(n-3) cases= case(n-2) + values[n]; case(n-3) + values[n-1]+values[n];
 */