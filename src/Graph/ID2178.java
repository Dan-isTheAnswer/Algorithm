// https://www.acmicpc.net/problem/2178
package Graph;

import java.util.ArrayDeque;
import java.util.Queue;

// Shortest Path(BFS)
class ID2178 {
    // 0: west; 1: south; 2: east; 3: north;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private static int[][] maze; // (y, x)
    private static int[][] ans;


    private static int bfs(int desty, int destx) {
        int[] src = new int[]{0, 0};

        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<int[]> q = new ArrayDeque<>();

        int[] turn = src;
        q.add(turn);
        visited[turn[0]][turn[1]] = true;
        System.out.println(turn[0] + " " + turn[1]);

        
        while(!q.isEmpty()) {
            turn = q.poll();

            // Check out four directions to go. 
            for (int i = 0; i < 4; i++) {
                int nY = turn[0] + dy[i];
                int nX = turn[1] + dx[i];
                if (nY >= 0 && nX >= 0 && 
                    nY <= 6 && nX <= 6 &&
                    visited[nY][nX] != true && 
                    maze[nY][nX] != 0) {
                    
                    ans[nY][nX] += ans[turn[0]][turn[1]];

                    q.add(new int[]{nY, nX});
                    visited[nY][nX] = true;
                    System.out.println(turn[0] + " " + turn[1]);
                }

            }

        }

        return ans[desty][destx];
    }


    public static void main(String[] args) {
        
        maze = new int[][]{
                           {1, 0, 1, 1, 1, 1, 1},
                           {1, 1, 1, 0, 0, 0, 1},
                           {1, 0, 0, 0, 0, 0, 1},
                           {1, 0, 0, 0, 0, 0, 1},
                           {1, 0, 0, 0, 0, 0, 1},
                           {1, 0, 0, 0, 0, 0, 1},
                           {1, 1, 1, 1, 1, 1, 1}};

        ans = new int[][]{
                           {1, 0, 1, 1, 1, 1, 1},
                           {1, 1, 1, 0, 0, 0, 1},
                           {1, 0, 0, 0, 0, 0, 1},
                           {1, 0, 0, 0, 0, 0, 1},
                           {1, 0, 0, 0, 0, 0, 1},
                           {1, 0, 0, 0, 0, 0, 1},
                           {1, 1, 1, 1, 1, 1, 1}};
        int result = bfs(6, 6);
        System.out.println(result);
        
        System.out.println("Hello");

    }
}
// If you want to implement XY chart programmatically, 
/**
 * If you want to implement a XY chart programmatically,
 * Think of for-loop order i.e. (y, x).
 */