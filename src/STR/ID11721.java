package STR;

import java.util.Scanner;

class ID11721 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();

        String[] ans = new String[input.length()/10 + 1];
        int j = 0;
        for (int i = 0; i < input.length()/10; i++) {
            ans[i] = input.substring(j, j+10);
            j+=10;
        }
        ans[ans.length-1] = input.substring(j, input.length());

        for (String e : ans) {
            System.out.println(e);
        }

    }
}