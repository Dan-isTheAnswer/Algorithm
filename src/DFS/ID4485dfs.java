// https://www.acmicpc.net/problem/4485
package DFS;

// DFS. But terrible performance. Dijkstra recommended
class ID4485dfs {
    private static int[] dy = { -1, 0, 1, 0 };
    private static int[] dx = { 0, -1, 0, 1 };
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // int n = 3; 
        // int[][] input = { {5, 5, 4}, 
        //                 {3, 9, 1},
        //                 {3, 2, 7}};
        int n = 5;
        int[][] input = { {3, 7, 2, 0, 1},
                          {2, 8, 0, 9, 1},
                          {1, 2, 1, 8, 1},
                          {9, 8, 9, 2, 0},
                          {3, 6, 5, 1, 5}};
        // int n = 7;
        // int[][] input = { {9, 0, 5, 1, 1, 5, 3},
        //                   {4, 1, 2, 1, 6, 5, 3},
        //                   {0, 7, 6, 1, 6, 8, 5},
        //                   {1, 1, 7, 8, 3, 2, 3},
        //                   {9, 4, 0, 7, 6, 4, 1},
        //                   {5, 8, 3, 2, 4, 8, 3},
        //                   {7, 4, 8, 4, 8, 3, 4}};

        dfs(input, n);
        System.out.println(min);
    }

    public static void dfs(int[][] grid, int n) {
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        dfsUtil(grid, visited, 0, 0, 0);
        return;
    }

    private static void dfsUtil(int[][] grid, boolean[][] visited, int y, int x, int total) {
        if (y == grid.length-1 && x == grid.length-1) {
            total += grid[y][x];
            min = Integer.min(min, total);
            return;
        } // base case

        for (int i = 0; i < 4; i++) {
            int nY = y + dy[i];
            int nX = x + dx[i];
            if (nY >= 0 && nY < grid.length &&
                nX >= 0 && nX < grid.length) {
                if (visited[nY][nX] != true) {
                    visited[nY][nX] = true;
                    dfsUtil(grid, visited, nY, nX, total + grid[y][x]);
                    visited[nY][nX] = false;
                }
            }            
        }

        return;
    }
}