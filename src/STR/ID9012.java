// https://www.acmicpc.net/problem/9012
package STR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ID9012 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = new String[n];
        
        for (int i = 0; i < n; i++) {
            input[i] = br.readLine();
        }
        // int n = 4;
        // String[] input = new String[] { // len is n
        //     "((","))","())(()","(()())((()))"
        // };

        solve(input);
    }

    private static void solve(String[] input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            int[] isPaired = new int[input[i].length()];

            // iterator j for input 
            boolean isOut = false; // flag
            for (int j = 0, left = 0, right = 0; j < input[i].length(); j++) {
                if (input[i].charAt(j) == '(') {
                    isPaired[left++]++;
                } else {
                    right = left -1;
                    while (right >= 0 && isPaired[right] == 2) {
                        right--;
                    }
                    if (right < 0) {
                        isOut = true;
                        break;
                    }
                    isPaired[right]++;
                }
            }
            
            // check if isPaired 1. If so, it means not paired
            // 0: nothing; 1: left parethesis only; 2: paired
            for (int j = 0; j < isPaired.length; j++) {
                if (isOut || isPaired[j] == 1) {
                    sb.append("NO\n");
                    break;
                }
                if (j == isPaired.length -1) 
                    sb.append("YES\n");
            }
        }

        System.out.println(sb.toString());
    }
}