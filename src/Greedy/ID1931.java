// https://www.acmicpc.net/problem/1931
package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class ID1931 {
    static int N;
    static int[][] input;

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] data = br.readLine().split(" ");
            for (int j = 0; j < 2; j++) {
                input[i][j] = Integer.parseInt(data[j]);
            }
        }
        // N = 11;
        
        // input = new int[][] {{1, 4}, {3, 5}, {0, 6}, {5, 7}, 
        // {3, 8}, {5, 9}, {6, 10}, {8, 11}, {8, 12}, {2, 13}, {12 ,14}};
        
        // just in case the finished time is same as others
        Arrays.sort(input, (e1, e2) -> Integer.compare(e1[0], e2[0]));
        // set orders 
        Arrays.sort(input, (e1, e2) -> Integer.compare(e1[1], e2[1]));

        int cnt = 1;
        int next = input[0][1];
        for (int i = 1; i < input.length; i++) {
            if (input[i][0] >= next) {
                cnt++;
                next = input[i][1];
            }
        }

        System.out.println(cnt);
    }
}
/**
 * The pitfall I was stuck in was
 * I set them in order based on their start time. 
 * 1) I tried a brute-force + Graph approach using ArrayList 
 * to access via next start time, even though the start time goes up 10,000.
 * Therefore, I encountered "memory limit excess".
 * 2) I tried a brute-force approach using int[N][2]([0] for start and [1] for finish)
 * once I sort them based on their start time.
 * Therefore, "time limit excess" occurs. 
 * 
 *  
 * you need to set them in order, based on comparable values.
 * !!Not thier values itself!! 
 */
