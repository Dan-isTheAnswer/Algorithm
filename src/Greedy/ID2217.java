// https://www.acmicpc.net/problem/2217
package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class ID2217 {
    static int N;
    static int[] input;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(input);

        int result = solve(input);
        System.out.println(result);
    }

    private static int solve(int[] input) {
        int val = -1;
        for (int i = 0; i < N; i++) {
            val = Integer.max(val, input[i]* (N-i));
        }
        
        return val;
    }
}
/**
 * First of all, we need to set them in ascending order 
 * The key to this problem is how much weight the ropes can hold.
 * The min rope can hold input[0] and, therfore, input[0] * length
 * 
 * If the previous total weight is smaller than input[i] * (lengh - i),
 * change it! 
 */