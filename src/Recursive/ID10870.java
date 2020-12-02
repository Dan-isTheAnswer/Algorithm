// Fibonacci 
package Recursive;

import java.util.Scanner;

class ID10870 {
    private static int[] arrFib;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(); // input
        sc.close();


        int ans = doFibonacci(num);
        System.out.println(ans);

    }

    private static int doFibonacci(int index) {
        preprocess(index); 

        if (index < 2) {
            return arrFib[index];
        }

        for (int i = 2; i < index+1; i++) {
            arrFib[i] = arrFib[i-2] + arrFib[i-1];
        }

        return arrFib[index];

    }

    private static void preprocess(int index) {
        if (index < 2) {
            arrFib = new int[2]; 
        } else {
            arrFib = new int[index+1];
        }
        arrFib[0] = 0;
        arrFib[1] = 1;
    }
}
// I approached this problem with respect to memory.