// https://www.acmicpc.net/problem/11399
package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class ID11399 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        int[] ans = new int[N];
        ans[0] = arr[0];
        for (int i = 1; i < N; i++) {
            ans[i] = ans[i-1] + arr[i];
        }
        
        int result = 0;
        for (int e : ans) {
            result += e;
        }
        System.out.println(result);
    }
}