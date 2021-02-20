// https://www.acmicpc.net/problem/1316
package STR;

import java.util.Scanner;

class ID1316 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] input = new String[n];
        for (int i = 0; i < n; i++) {
            input[i] = sc.next();
        }
        sc.close();
        
        // int n = 4;
        // String[] input = {"happy", "new", "ccazzzzbb", "aabbbccb"};

        solve(input);
    }

    private static void solve(String[] input) {
        int ans = 0;
        for (int i = 0; i < input.length; i++) {
            int[] carr = new int[26];
            boolean isGroup = true; // flag
            int previous = input[i].charAt(0);
            carr[previous - 'a']++;
            for (int j = 1; j < input[i].length(); j++) {
                if (input[i].charAt(j) != previous) {
                    previous = input[i].charAt(j);
                    if (carr[input[i].charAt(j) - 'a'] != 0) {
                        isGroup = false;
                        break;
                    }
                }  

                carr[input[i].charAt(j) -'a']++;
            }
            if (isGroup) ans++;

        }

        System.out.println(ans);
    }
}