// https://www.acmicpc.net/problem/13460
package BFS;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

// TODO: move Blue ball simultaneously. 
class ID13460 {
    private int[][] map;
    private int[] dy = {-1, 0, 1, 0};
    private int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) {
        int N = 7;
        int M = 7;

        String[] inputs = {"#######",
                           "#..R#B#",
                           "#.#####",
                           "#.....#",
                           "#####.#",
                           "#O....#",
                           "#######"};
        // int N = 5; // row
        // int M = 5; // col

        // String[] inputs = {"#####", 
        //                    "#..B#",
        //                    "#.#.#",
        //                    "#RO.#",
        //                    "#####"};

        ID13460 balls = new ID13460();
        int ans = balls.solve(N, M, inputs);
        System.out.println(ans);

        
    }

    public int solve(int N, int M, String[] inputs) {
        this.map = new int[N][M];
        int[] zero = conversion(inputs, map);
        for (int[] arr : map) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(zero));
        System.out.println();

        int result = bfs(zero);
        for (int[] arr : map) {
            System.out.println(Arrays.toString(arr));
        }

        return result;
    }

    public int bfs(int[] zero) {
        int N = this.map.length;
        int M = this.map[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        int[] src = new int[4];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (this.map[i][j] == 1) src = new int[]{i, j, 0, 0};
            }
        }
        
        q.add(src);
        visited[src[0]][src[1]] = true;
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int y = tmp[0];
            int x = tmp[1];
            int previousDirY = tmp[2];
            int previousDirX = tmp[3];
            // visited[y][x] = true;

            for (int i = 0; i < 4; i++) {
                int nY = y + dy[i];
                int nX = x + dx[i];
                if (nY >= 0 && nY < N && nX >= 0 && nX < M) {
                    if (!visited[nY][nX] && map[nY][nX] != -1 && map[nY][nX] != -2) {
                        if ((previousDirY == 0 && previousDirX == 0) ||
                            (previousDirY == dy[i] && previousDirX == dx[i])) {
                            this.map[nY][nX] = this.map[y][x];
                        } else {
                            this.map[nY][nX] = this.map[y][x] + 1;
                        }

                        q.add(new int[]{nY, nX, dy[i], dx[i]});
                        visited[nY][nX] = true;
                    }
                }
            }
        }

        return this.map[zero[0]][zero[1]];
    }

    // R is 1, B is -2 but B is moved 
    public int[] conversion(String[] inputs, int[][] map) {
        int[] zero = new int[2];
        for (int i = 0; i < inputs.length; i++) {
            for (int j = 0; j < inputs[i].length(); j++) {
                if (inputs[i].charAt(j) == '#') map[i][j] = -1;
                else if (inputs[i].charAt(j) == 'R') map[i][j] = 1;
                else if (inputs[i].charAt(j) == 'B') map[i][j] = -2;
                else if (inputs[i].charAt(j) == 'O') zero = new int[] {i, j};
            }
        }

        return zero;
    }
}