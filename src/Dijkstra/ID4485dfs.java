// https://www.acmicpc.net/problem/4485
package Dijkstra;

import java.util.Arrays;

// performance: Dijkstra > this mixed one.
// DFS and Dijkstra are mixed 
class ID4485dfs {
    private static int[] dy = { -1, 0, 1, 0 };
    private static int[] dx = { 0, -1, 0, 1 };

    public static void main(String[] args) {

        // int n = 3; 
        // int[][] input = { {5, 5, 4}, 
        //                 {3, 9, 1},
        //                 {3, 2, 7}};
        // int n = 5;
        // int[][] input = { {3, 7, 2, 0, 1},
        //                   {2, 8, 0, 9, 1},
        //                   {1, 2, 1, 8, 1},
        //                   {9, 8, 9, 2, 0},
        //                   {3, 6, 5, 1, 5}};
        int n = 7;
        int[][] input = { {9, 0, 5, 1, 1, 5, 3},
                          {4, 1, 2, 1, 6, 5, 3},
                          {0, 7, 6, 1, 6, 8, 5},
                          {1, 1, 7, 8, 3, 2, 3},
                          {9, 4, 0, 7, 6, 4, 1},
                          {5, 8, 3, 2, 4, 8, 3},
                          {7, 4, 8, 4, 8, 3, 4}};


        int result = dfs(input, n);
        System.out.println(result);
    }

    public static int dfs(int[][] grid, int n) {
        int[][] dist = new int[n][n];
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = grid[0][0];
        visited[0][0] = true;
        dfsUtil(grid, n, visited, 0, 0, dist);

        printDist(dist);
        return dist[n-1][n-1];
    }

    private static void dfsUtil(int[][] grid, int n, boolean[][] visited, int y, int x, int[][] dist) {
        if (y == grid.length-1 && x == grid.length-1) {
            return;
        } // base case

        for (int i = 0; i < 4; i++) {
            int nY = y + dy[i];
            int nX = x + dx[i];
            if (dist[y][x] != Integer.MAX_VALUE && 
                nY >= 0 && nY < grid.length &&
                nX >= 0 && nX < grid.length) {
                if (!visited[nY][nX] && dist[nY][nX] > dist[y][x] + grid[nY][nX]) {
                    visited[nY][nX] = true;
                    dist[nY][nX] = dist[y][x] + grid[nY][nX];
                    dfsUtil(grid, n, visited, nY, nX, dist);
                    visited[nY][nX] = false;
                }
            }            
        }

        return;
    }

    private static void printDist(int[][] dist) {
        for (int[] a : dist) {
            System.out.println(Arrays.toString(a));
        }
    }
}