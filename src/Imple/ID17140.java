// https://www.acmicpc.net/problem/17140
package Imple;

import java.util.LinkedList;
import java.util.List;

class ID17140 {
    static int[][] map;
    static int r;
    static int c;
    static int target;
    static int lenR;
    static int lenC;

    // the worst case is one time for each value
    static int[][] ans = new int[200][200];

    private static class Node implements Comparable<Node> {
        int i;
        int val;

        Node(int i, int val) {
            this.i = i;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return val - o.val;
        }
    }

    public static void main(String[] args) {
        String q = "1 2 4"; // ans is 52
        String[] inputs = {
            "1 2 1",
            "2 1 3",
            "3 3 3"
        };
        
        int[] problem = new int[3];
        String[] input = q.split(" "); for (int i = 0; i < 3; i++) {
            problem[i] = Integer.parseInt(input[i]);
        }
        r = problem[0] -1; c = problem[1] -1;
        target = problem[2];

        lenR = 3; lenC = 3;
        map = new int[3][3];
        for (int i = 0; i < 3; i++) {
            String strin = inputs[i];
            input = strin.split(" ");
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                ans[i][j] = map[i][j];
            }
        }

        printMap(1);
        System.out.println("Start!");
        ID17140 m = new ID17140();
        int result = m.solve(ans[r][c], true, 0);
        System.out.println(result);

    }

    /**
     * (ans[r][c], true, 0);
     * 
     * @param cur current value
     * @param isR which one between row and column is larger
     * @param time times we recursively call this function
     * @return time and update ans[][]
     */
    public int solve(int cur, boolean isR, int time) { 
        if (target == cur) {
            return time;
        } else if (time > 100) {
            return -1;
        }


        if (isR) {
            for (int i = 0; i < lenR; i++) {

                int[] val = new int[101]; // value could be 1 to 100
                int upto = -1;
                //count each value
                for (int j = 0; j < lenC; j++) {
                    val[ans[i][j]]++;
                    upto = Math.max(upto, ans[i][j]);
                }

                // sort values using LinkedList
                List<Node> tmp = new LinkedList<>(); // container
                for (int j = 1; j <= upto; j++) {
                    if (val[j] != 0) 
                        tmp.add(new Node(j, val[j]));
                }
                tmp.sort((e1, e2) -> e1.compareTo(e2));
                
                // update ans
                int col = 0;
                for (int j = 0; j < tmp.size(); j++) {
                    if (tmp.get(j).val == 0) continue;
                    ans[i][col++] = tmp.get(j).i;
                    ans[i][col++] = tmp.get(j).val;
                }

                // lenC required to be updated
                if (lenC < col) {
                    lenC = col;
                }
                
                // handle remainders 
                // set ans[i][j] as 0 upto the largest length of column
                for (int j = col; j < lenC; j++) {
                    ans[i][j] = 0;
                }
            }
            if (lenR < lenC) 
                isR = false;
        } else {
            for (int i = 0; i < lenC; i++) {

                int[] val = new int[101];
                int upto = -1;
                //count each value
                for (int j = 0; j < lenR; j++) {
                    val[ans[j][i]]++;
                    upto = Math.max(upto, ans[j][i]);
                }

                // sort values using LinkedList
                List<Node> tmp = new LinkedList<>(); // container
                for (int j = 1; j <= upto; j++) {
                    if (val[j] != 0) 
                        tmp.add(new Node(j, val[j]));
                }
                tmp.sort((e1, e2) -> e1.compareTo(e2));
                
                // update ans
                int row = 0;
                for (int j = 0; j < tmp.size(); j++) {
                    if (tmp.get(j).val == 0) continue;
                    ans[row++][i] = tmp.get(j).i;
                    ans[row++][i] = tmp.get(j).val;
                }

                // lenR required to be updated
                if (lenR < row) {
                    lenR = row;
                }
                
                // handle remainders 
                // set ans[i][j] as 0 upto the largest length of row 
                for (int j = row; j < lenR; j++) {
                    ans[j][i] = 0;
                }
            }

            if (lenR >= lenC)
                isR = true;
        }
        
        printMap(time);
        return solve(ans[r][c], isR, time+1);
    }

    private static void printMap(int cnt) {
        if (cnt < 10) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}

/**
 * How to change row value while fixing col value 
 * for (int i = 0; i < 3; i++) {
 *  for (int j = 0; j < 3; j++) {
 *      ans[j++][i];
 *  }
 * }
 */