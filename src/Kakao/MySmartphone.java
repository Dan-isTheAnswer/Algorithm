// https://tech.kakao.com/2020/07/01/2020-internship-test/
package Kakao;

class MySmartphone {
    private static String[] yours = {"L", "R"};

    public static void main(String[] args) {
        
        // System.out.println(HAND.valueOf("L"));
        // int[] numbers = new int[] {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        // String hand = "right";
        // int[] numbers = new int[] {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        // String hand = "left";
        int[] numbers = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand = "right";

        solve(numbers, hand);
    }

    public static int solve(int[] numbers, String hand) {
        String h;
        int[][] map = new int[][] {{1, 2, 3}, 
                                   {4, 5, 6},
                                   {7, 8, 9},
                                   {-1, 0, -1}};
                            
        h = hand.substring(0, 1).toUpperCase();
        System.out.println("I'm kinda " + h+ " person");

        String result = chooseWhich(map, numbers, h);
        System.out.println(result);

        return 0;
    }

    public static String chooseWhich(int[][] map, int[] numbers, String h) {
        StringBuilder sb = new StringBuilder();
        int[] left = new int[]{3, 0};
        int[] right = new int[]{3, 2};

        int[] number = new int[] {0, 0};
        for (int i = 0; i < numbers.length; i++) {
            // where is the number?
            for (int r = 0; r < map.length; r++) {
                for (int c = 0; c < map[0].length; c++) {
                    if (map[r][c] == numbers[i]) {
                        number = new int[] {r, c};
                    } 
                }
            }


            if (numbers[i] %3 == 2 || numbers[i] == 0) {
                // lMargin vs rMargin
                int lMargin = 0;
                if (left[0] >= number[0]) {
                    lMargin += left[0] - number[0];
                } else {
                    lMargin += number[0] - left[0];
                }
                if (left[1] != number[1]) {
                    lMargin += 1;
                }

                int rMargin = 0;
                if (right[0] >= number[0]) {
                    rMargin += right[0] - number[0];
                } else {
                    rMargin += number[0] - right[0];
                }
                if (right[1] != number[1]) {
                    rMargin += 1;
                }

                // which one is closer?
                if (lMargin < rMargin) {
                    sb.append(yours[0]);
                    left = number;
                } else if (lMargin > rMargin) {
                    sb.append(yours[1]);
                    right = number;
                } else {
                    sb.append(h);
                    if (h.equals(yours[0])) {
                        left = number;
                    } else {
                        right = number;
                    }
                }

            } else if (numbers[i] % 3 == 1) {
                sb.append(yours[0]);
                left = number;
            } else if (numbers[i] % 3 == 0) {
                sb.append(yours[1]);
                right = number;
            }


        }

        return sb.toString();
    }
}
