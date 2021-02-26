// https://www.acmicpc.net/problem/1080
package Greedy;

import java.util.Arrays;

class ID1080 {
    static int N, M;
    static char[][] input;
    static char[][] output;
    static boolean[][] isSame;

    public static void main(String[] args) {
        

        N = 3; M = 4;
        input = new char[N][M];
        output = new char[N][M];
        isSame = new boolean[N][M];
        

        String[] datain = new String[]{
            "0000",
            "0010",
            "0000"
        };

        String[] dataout = new String[]{
            "1001",
            "1011",
            "1001"
        };
        
        // convert into char[][] and mark same spots
        for (int i = 0; i < N; i++) {
            input[i] = datain[i].toCharArray();
            output[i] = dataout[i].toCharArray();
            for (int j = 0; j < M; j++) {
                if (input[i][j] == output[i][j])
                    isSame[i][j] = true;
            }
        }
        
        int result = solve();
        System.out.println(result);
    }

    private static int solve() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (input[i][j] != output[i][j]&& i+2 < N && j+2 < M) {
                    swap(i, j);
                    printMap();
                    cnt++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (!Arrays.equals(input[i], output[i])) {
                return -1;
            }
        }
        return cnt;
    }

    private static void swap(int row, int col) {
        for (int i = row; i < row+3; i++) {
            for (int j = col; j < col+3; j++) {
                if (input[i][j] == '0') {
                    input[i][j] = '1';
                } else {
                    input[i][j] = '0';
                }
            }
        }
    }

    private static void printMap() {
        for (char[] arr : input) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println();
    }
}

/**
5 5
10101
01011
10110
01010
11111
01110
10000
00011
00100
10001
 */