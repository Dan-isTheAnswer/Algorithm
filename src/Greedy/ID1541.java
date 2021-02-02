// https://www.acmicpc.net/problem/1541
package Greedy;

import java.util.StringTokenizer;

// regex is required to solve this problem. 
class ID1541 {

    public static void main(String[] args) {
        String input = "55-50+40";
        StringTokenizer st = new StringTokenizer(input, "[-]");
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine(), "[-]");

        int[] numsWithoutMinus = new int[st.countTokens()];
        for (int i =0; st.hasMoreTokens(); i++) {
            String[] s = st.nextToken().split("[+]");

            int total= 0;
            for (int j = 0; j < s.length; j++) {
                total += Integer.parseInt(s[j]);
            }
            numsWithoutMinus[i] = total;
        }
        // System.out.println("number withous minus");
        // for (int e : numsWithoutMinus) {
        //     System.out.println(e);
        // }
        

        int result = numsWithoutMinus[0];
        for (int i = 1; i < numsWithoutMinus.length; i++) {
            result -= numsWithoutMinus[i];
        }

        System.out.println(result);
    }
}
/**
 * Greedy Algorithm
 * To get the minimun value, 
 * 1) Add values as much as possible to get them greater. 
 * 2) Subtract each by each. 
 */