package Bruteforth;

import java.util.Arrays;
import java.util.OptionalInt;

class ID2309 {

    public static void main(String[] args) {
        int[] dwarfs = new int[] {20, 7, 23, 19, 10, 15, 25, 8, 13};
        solve(dwarfs);
    }

    // total - sum(e1, e2) == 100
    private static void solve(int[] dwarfs) {
        int[] arr = new int[9];
        OptionalInt opt = Arrays.stream(dwarfs).reduce((e1, e2) -> e1 + e2);
        int total = opt.getAsInt();

        for (int a = 0; a < 9-1; a++) {
            for (int b = a+1; b < 9; b++) {
                int sum = dwarfs[a] + dwarfs[b];
                if (total - sum == 100) {
                    for (int i = 0; i < 9; i++) {
                        if (dwarfs[i] != dwarfs[a] && dwarfs[i] != dwarfs[b]) {
                            arr[i] = dwarfs[i];
                        }
                    }
                }

            }
        }

        Arrays.sort(arr);
        for (int i = 2; i < 9; i++) {
            System.out.println(arr[i]);
        }
        
    }
}