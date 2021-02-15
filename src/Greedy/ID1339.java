package Greedy;

import java.util.Arrays;

class ID1339 {
    
    public static void main(String[] args) {

        // **counter case. 
        int n = 2;
        String[] input = {"BC", "AA"}; // ans is 186

        solve(input, n);
    }

    private static void solve(String[] input, int n) {
        int[] alphabet = new int[26];
        int ans = 0;
        int value = 9;

        // assign each alphabet value. 
        for (int i = 0; i < n; i++) {
            char[] arr  = input[i].toCharArray();
            int pos = (int) Math.pow(10, arr.length -1);

            for (int j = 0; j < arr.length; j++) {
                alphabet[arr[j] - 'A'] += pos;
                pos /= 10;
            }
        }

        //  
        // sort values so that the biggest alphabet could be located in the last index 
        // and the smallest alphabet could be in the first. 
        Arrays.sort(alphabet);

        // give answer. 
        for (int i = alphabet.length-1; i >= 0; i--) {
            if (value == 0) break;
            ans += alphabet[i] * value--;
        }

        System.out.println(ans);
    }
}
/**
 * !!Aha-moment:
 * it doesn't matter which alphabet has how much value is 
 * since we are only interested in getting maximum value 
 * when sorting alphabet values.  
 * 
 */

/**
 * For example, 
 * n = 2, String[] input = {GCF, ACDEB};
 * GCF = G*100 + C*10 + F*1
 * ACDEB = A*10000 + C*1000 + D*100 + E*10 + B*1
 * Therefore, answer is A*10000 + B*1 + C*1010 + D*100 + E*10 + F*1;
 * The values could be 1, 1, 10, 100, 1010, 10000 
 * if we sort them. And the maximum answer could be 
 * 9*10000 + 8*1010 + 7*100 + 6*100 + 5*10 + 4*1 + 3*1.
 */

