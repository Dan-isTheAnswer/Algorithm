package STR;

import java.util.Scanner;

class ID11720 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String input = sc.next();
        sc.close();

        // 2) 
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += input.charAt(i) -'0';
        }

        // 1) 
        // int ans = 0;
        // for (int i = 0; i < n; i++) {
        //     ans += input %10;
        //     input /= 10;
        // }

        System.out.println(ans);
    }
}