// Factorial 
package Recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ID10872 {

    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);

        int num = Integer.parseInt(br.readLine());
        int ans = factorial(num);
        System.out.println(ans);
    }

    private static int factorial(int input) {
        if (input == 1 || input == 0) {
            return 1;
        } 

        return input * factorial(input-1);
    }
}
