package Recursive;

import java.util.Arrays;

// Recursive; Not DAC because DAC must return something which affects its parent. 
class ID2447 {

    public static void main(String[] args) {
        int N = 27; // 3, 9, 27 ...
        
        String[][] ground = new String[N][N];
        for (String[] a : ground) {
            Arrays.fill(a, " ");
        }
        printStar(N, 0, 0, ground);

        StringBuilder sb = new StringBuilder("");
        for (String[] a : ground) {
            for (String b : a) {
                sb.append(b);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
    
    
    public static void printStar(int N, int srcY, int srcX, String[][] ground) {

        if (N == 3) {
            star(srcY, srcX, ground);
            return;
        }
            


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i % 3 == 1 && j % 3 == 1) {
                    continue;
                }
                printStar(N/3, srcY+(N/3*i), srcX + (N/3*j), ground);
            }
        }
    }

    private static void star(int srcY, int srcX, String[][] ground) {
        // when skip?? 1, 4, 7 ... 
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i % 3 == 1 && j % 3 == 1) {
                    ground[srcY+i][srcX+j] = " ";
                    continue;
                } // if else also works:)
                ground[srcY+i][srcX+j] = "*";
            }
        }
    }
}