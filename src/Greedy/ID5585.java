// https://www.acmicpc.net/problem/5585
package Greedy;

import java.util.Scanner;

class ID5585 { 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 1000 - sc.nextInt();
        sc.close();

        int result = returnChange(n);
        System.out.println(result);

    }

    private static int returnChange(int n) {
        final int[] changes = {500, 100, 50, 10, 5, 1};
        int cnt = 0;
        int remainder = n;
        for (int i = 0; i < changes.length; i++) {
            if (remainder >= changes[i]) {
                cnt += remainder/changes[i];
                remainder = remainder%changes[i];
            }
        }

        return cnt;
    }
}