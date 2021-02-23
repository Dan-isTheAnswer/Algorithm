// https://www.acmicpc.net/problem/4796
package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ID4796 {
    static int l, p, v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ID4796 m = new ID4796();

        for (int i = 1; true; i++) {
            String input = br.readLine();
            String[] group = input.split(" ");
            l = Integer.parseInt(group[0]);
            p = Integer.parseInt(group[1]);
            v = Integer.parseInt(group[2]);

            if (l == 0 && p == 0 && v == 0) 
                break;
            System.out.println("Case " + i + ": " + m.solve());
        }
        // 1 < L < P < V
        // e.g. 10(L) of 20(P) days for 28(V) days

        // l = 5; p = 8; v = 20; // 14
        // l = 5; p = 8; v = 17; // 11

    }

    public int solve() {
        int divisor = v/p;
        int remainder = v%p;

        int ans = divisor*l;
        int leftover = remainder < l? remainder : l;

        return ans + leftover;
    }
}