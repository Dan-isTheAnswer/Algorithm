// https://www.acmicpc.net/problem/2583
package Graph;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class ID2583 {

    private static int[] dy = { 0, -1, 0, 1 };
    private static int[] dx = { -1, 0, 1, 0 };

    public static void main(String[] args) throws IOException {

        int M = 5; // y
        int N = 7; // x
        int K = 3; // num of ractangulars 
        int[][] rectangulars = new int[K][4];

        // // K
        int[] a = {0, 2, 4, 4}; // (x, y) (x, y)
        int[] b = {1, 1, 2, 5};
        int[] c = {4, 0, 6, 2};
        rectangulars[0] = a;
        rectangulars[1] = b;
        rectangulars[2] = c;

        int[][] maze = new int[M][N];
        for (int i = 0; i < M; i++) {
            Arrays.fill(maze[i], 1);
        }

        markRectangular(maze, rectangulars);

        StringBuilder sb = new StringBuilder();
        int count = 0;
        int[] ans = startAndEnd(maze);
        for (int e : ans) {
            if (e != 0) {
                ++count;
                sb.append(e + " ");
            }
        }
        System.out.println(count); 
        System.out.println(sb.toString());
    }


    // mark 0 if i and j are in range of one of rectangulars 
    private static void markRectangular(int[][] maze, int[][] rectangulars) {

        for (int[] rectangular : rectangulars) {
            for (int i = rectangular[1]; i < rectangular[3]; i++){
                for (int j = rectangular[0]; j < rectangular[2]; j++) {
                    maze[i][j] = 0;
                }
            }
        }
    }


    private static void bfs(int n, int srcY, int srcX, int[][] maze) {
        
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<int[]> q = new ArrayDeque<>();

        int[] src = new int[] {srcY, srcX};
        q.add(src);
        visited[src[0]][src[1]] = true;
        maze[src[0]][src[1]] = n; // mark n 

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int y = tmp[0];
            int x = tmp[1];

            for (int i = 0; i < 4; i++) {
                int nY = dy[i] + y;
                int nX = dx[i] + x;
                if (nY >= 0 && nX >= 0 &&
                    nY < maze.length && nX < maze[0].length &&
                    visited[nY][nX] != true &&
                    maze[nY][nX] == 1) {
                        q.add(new int[] {nY, nX});
                        visited[nY][nX] = true;            
                        maze[nY][nX] = n;
                    }
            }
        }
        // for (int[] i : maze){
        //     System.out.println(Arrays.toString(i));
        // }
        // System.out.println();

        
    }

    // We get ranges via counting each room. 
    // We fill each room where is out of rectangulars as the marked number. 
    // Divide by n which works as a mark and save it! 
    // e.g. 4*1 /4 = 1; 2*7 /2 = 7; 
    public static int[] startAndEnd(int[][] maze) {
        
        int n = 2;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 1) {
                    bfs(n, i, j, maze);
                    n++;
                }
            }
        }

        int[] areas = new int[n];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                int index = maze[i][j];
                areas[index] += index;
            }
        }

        for (int i = 1; i < areas.length; i++) {
            areas[i] = areas[i]/i;
        }

        Arrays.sort(areas);

        
        return areas;
    }
}
