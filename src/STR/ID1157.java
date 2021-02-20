package STR;

import java.util.Scanner;

class ID1157 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        input = input.toUpperCase();
        sc.close();

        // 1) int[] 
        int[] carr = new int['Z' - 'A' +1]; // A to Z
        for (int i = 0; i < input.length(); i++) {
            carr[input.charAt(i) -'A']++;
        }

        // find char and is multiple
        int maxi = 0;
        boolean isMul = false; // flag
        for (int i = 1; i < carr.length; i++) {
            if (carr[maxi] < carr[i]){
                maxi = i;
                isMul = false;
            } else if (carr[maxi] == carr[i]) 
                isMul = true;
        }
        // // is multiple
        // boolean isMul = false;
        // for (int i = maxi+1; i < carr.length; i++) {
        //     if (carr[maxi] == carr[i]) {
        //         isMul = true;
        //         break;
        //     }
        // }

        // 2) HashMap 

        char ans = (char) (maxi + 'A');
        if (!isMul) System.out.println(ans);
        else System.out.println("?");
    }
}