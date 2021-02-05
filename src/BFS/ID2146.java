// https://www.acmicpc.net/problem/2146
package BFS;

import java.util.ArrayDeque;
import java.util.Queue;

class ID2146 {
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) {
                 
        int n = 5; // ans is 2
        String[] inputs = {
            "1 0 0 0 1",
            "0 0 0 0 0",
            "0 0 0 0 0",
            "0 0 0 0 0",
            "1 1 0 0 1"
        };

        Queue<int[]> q = new ArrayDeque<>();
        int[][] dist = new int[n][n];

        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = inputs[i].split(" ");
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(input[j]);
                if (grid[i][j] == 1) q.offer(new int[] {i, j});
            }
        }

        int color = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    color(grid, i, j, color);
                    color--;
                }
            }
        }
        System.out.println(bfs(grid, dist, q));
    }

    // recursive call
    private static void color(int[][] grid, int y, int x, int color) {
        int n = grid.length;
        grid[y][x] = color;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i]; int nx = x + dx[i];
            if (ny >= 0 && ny < n && nx >= 0 && nx < n) {
                if (grid[ny][nx] == 1) {
                    color(grid, ny, nx, color);
                }
            }
        }
    }

    private static int bfs(int[][] grid, int[][] dist, Queue<int[]> q) {
        int n = grid.length;
        int min = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int y = tmp[0]; int x = tmp[1];
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i]; int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;

                if (grid[ny][nx] == 0) {
                    grid[ny][nx] = grid[y][x]; // **grid acts as visited
                    dist[ny][nx] = dist[y][x]+1; // **
                    q.offer(new int[]{ny, nx});
                } else if (grid[ny][nx] != grid[y][x]) {
                    min = Math.min(min, dist[ny][nx] + dist[y][x]);
                }
            }
        }
        return min;
    }
}
