// https://www.acmicpc.net/problem/2589
package BFS;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class ID2589 {
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static int row;
    static int col;
    static int[][] map;
    static int ans = 0; 

    public static void main(String[] args) {
        row = 5;
        col = 7;
        map = new int[row][col]; 

        String[] input = {
            "WLLWWWL",
            "LLLWLLL",
            "LWLWLWW",
            "LWLWLLL",
            "WLLWLWW"
        };

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (input[i].charAt(j) == 'W') {
                    map[i][j] = -1;
                } else if (input[i].charAt(j) == 'L') {
                    map[i][j] = 0;
                }
            }
        }

        solve();
        System.out.println(ans);
    }

    private static void solve() {
        // try bfs row * col times
        // the worst case is 50 * 50 times
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 0)
                    bfs(i, j);
            }
        }
    }

    private static void bfs(int srcy, int srcx) {
        
        // init map everytime it runs bfs
        int[][] compMap = new int[row][col];
        for (int i = 0; i < row; i++) {
            compMap[i] = Arrays.copyOf(map[i], col);
        }

        // bfs 
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[row][col];

        q.add(new int[] {srcy,srcx});
        visited[srcy][srcx] = true;

        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int y = tmp[0];
            int x = tmp[1]; 
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny >= 0 && ny < row && nx >= 0 && nx < col) {
                    if (!visited[ny][nx] && compMap[ny][nx] == 0) {
                        visited[ny][nx] = true;
                        compMap[ny][nx] = compMap[y][x] +1;
                        q.add(new int[]{ny, nx});
                    }
                }

            }
        }
        
        // update the max val
        ans = Integer.max(ans, giveMax(compMap));
    }

    // util
    private static int giveMax(int[][] compMap) {
        int max = 0; 
        for (int[] arr : compMap) {
            for (int e : arr) {
                max = Integer.max(max, e);
            }
        }

        return max;
    }

}
