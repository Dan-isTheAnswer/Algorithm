// https://www.acmicpc.net/problem/2293
package DAC;

import java.util.Scanner;

class ID2293{
    static int n, k;
    static int[] coins;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); k = sc.nextInt();
        coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt(); 
        }
        sc.close();
        
        // n = 3; k = 10;
        // coins = new int[] {1, 2, 5};
        int result = dac(n, k);
        System.out.println(result);
    }

    private static int dac(int lev, int val) {
        if (lev == 1 && val%coins[lev-1] == 0) // base case
            return 1;
        else if (lev == 1) // if not val%coins[lev-1] is 0
            return 0;
        
        int num = 0;
        for (int i = 0; i*coins[lev-1] <= val; i++) {
            num += dac(lev-1, val - i*coins[lev-1]);
        }

        return num;
    }

}

/**
 * DP (Bottom-up) is required since lack of memory (4mb) and filter duplication
 * 
 *  (3, 10):10
 * [(2, 10)]:6      [(2, 5)]:3      [(2, 0)]:1
 * [(1, 10)  (1, 8)  (1, 6)  (1, 4)  (1, 2)  (1, 0)]   [(1, 5)  (1, 3)  (1, 1)]     []
 */