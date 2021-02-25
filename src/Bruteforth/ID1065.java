package Bruteforth;

import java.util.Scanner;

class ID1065 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        sc.close();

        if (n.length() < 3) System.out.println(n);
        else System.out.println(99 + solve(n));

    }

    // if n >= 100
    private static int solve(String n) {
        int total = 0;
        for (int i = 100; i <= Integer.parseInt(n); i++) {
            String num = String.valueOf(i);
            int len = num.length();
            String[] nums = num.split("");
            int d = Integer.parseInt(nums[0]) - Integer.parseInt(nums[1]);  
            for (int j = 1; j < len-1; j++) {
                if (d != Integer.parseInt(nums[j]) - Integer.parseInt(nums[j+1])) 
                    break;
                if (j == len-2)
                    total++;
            }

        }

        return total;
    }
}