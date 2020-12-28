// https://www.acmicpc.net/problem/2178
package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// Shortest Path(BFS)
class ID2178 {
    private static int n, m;

    // 0: west; 1: south; 2: east; 3: north;
    private static int[] dx = { -1, 0, 1, 0 };
    private static int[] dy = { 0, -1, 0, 1 };
    private static int[][] maze; // (y, x)
    private static int[][] ans;

    private static int bfs(int desty, int destx) {
        int[] src = new int[] { 0, 0 };

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new ArrayDeque<>();

        int[] turn = src;
        q.add(turn);
        visited[turn[0]][turn[1]] = true;
        // System.out.println(turn[0] + " " + turn[1]);

        while (!q.isEmpty()) {
            turn = q.poll();

            // Check out four directions to go.
            for (int i = 0; i < 4; i++) {
                int nY = turn[0] + dy[i];
                int nX = turn[1] + dx[i];
                if (nY >= 0 && nX >= 0 && nY < n && nX < m && visited[nY][nX] != true && maze[nY][nX] != 0) {

                    ans[nY][nX] += ans[turn[0]][turn[1]];

                    q.add(new int[] { nY, nX });
                    visited[nY][nX] = true;
                    // System.out.println(turn[0] + " " + turn[1]);
                }

            }

        }

        return ans[desty][destx];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maze = new int[n][m];
        ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = line.charAt(j) - '0'; // ascii
                ans[i][j] = line.charAt(j) - '0';
            }
        }
        
        int result = bfs(n-1, m-1);
        System.out.println(result);
        

    }
}
// Rod-column set is programmatically different from x-y set. 
// BFS's visited could be true in two ways: when either adding or poll. 
/**
 * If you want to implement a XY chart programmatically,
 * Think of for-loop orders i.e. (y, x).
 */