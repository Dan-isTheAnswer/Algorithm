// Fibonacci 
package Recursive;

import java.util.Scanner;

class ID10870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        System.out.println(doFibonacci(n));
    }

    public static int doFibonacci(int num) {
        if (num <2) {
            return num;
        }
        return doFibonacci(num-1) + doFibonacci(num-2);
    } 
}
// I approached this problem with respect to a mathmetic concept.
// The fibonacci number consists of 
// 0 from the index of 0 and 1 from the index of 1.