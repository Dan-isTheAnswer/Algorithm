// https://www.acmicpc.net/problem/1012
package Graph;

import java.util.ArrayDeque;
import java.util.Queue;

class ID1012 {
    private static int[] dy = {0, -1, 0, 1};
    private static int[] dx = {-1, 0, 1, 0};

    public static void main(String[] args) {
        int col = 10;
        int row = 6;
        // int cabbages = 14;

        int[][] maze = {{1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                            {0, 0, 1, 1, 0, 0, 0, 1, 1, 1},
                            {0, 0, 0, 0, 1, 0, 0, 1, 1, 1} };
        // int x = 5;
        // int y = 3;
        // int cabbages = 6;
        // int[][] maze = {{0,0,0,0,1},
        //                 {0,0,0,0,0},
        //                 {1,1,1,1,1},
        //                 {0,0,0,0,0},
        //                 {0,0,0,0,0}};

        int result = bugsForCabbage(maze, row, col);
        System.out.println(result);

    }

    public static int bugsForCabbage(int[][] maze, int row, int col) {

        int bugs = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (maze[i][j] == 1) {
                    bugs++;
                    howWillBugGoFar_BFS(i, j, maze);
                }
            }
        }

        return bugs;
    }

    private static void howWillBugGoFar_BFS(int y, int x, int[][] maze) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];

        q.add(new int[]{y, x});
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int[] yx = q.poll();
            for (int i = 0; i < 4; i++) {
                int nY = yx[0] + dy[i];
                int nX = yx[1] + dx[i];    
                if (nY >= 0 && nX >= 0 &&
                    nY <maze.length && nX < maze[0].length &&
                    visited[nY][nX] == false &&
                    maze[nY][nX] != 0) {
                        q.add(new int[]{nY, nX});
                        visited[nY][nX] = true;
                        maze[nY][nX] = maze[yx[0]][yx[1]] + 1;
                }
            }
        }
    }

}
// if (maze[i][j] == 1) spread out and bugs++.
// In doing so, we get rid of chances of counting adjacent position which is set 1. 


