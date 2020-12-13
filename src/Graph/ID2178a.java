package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class ID2178a {

  static int n;
  static int m;
  static int[][] maze;
  static boolean[][] visited;

  // South when i is 0; East when i is 1;
  // North when i is 2; West when i is 3;
  static int[] dy = {-1, 0, 1, 0};
  static int[] dx = {0, -1, 0, 1}; 

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    maze = new int[n][m];
    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      for (int j = 0; j < m; j++) {
        maze[i][j] = line.charAt(j) - '0';// ascii: save int when accepted as char
      }
    }
    visited = new boolean[n][m];
    bfs();
    System.out.print(maze[n - 1][m - 1]);
  }

  private static void bfs() {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{0, 0}); //same as "q.add(new int[2]);"

    while (!q.isEmpty()) {
      int[] pair = q.poll();
      visited[pair[0]][pair[1]] = true;

      for (int i = 0; i < 4; i++) {
        int nY = pair[0] + dy[i]; // new x and new y
        int nX = pair[1] + dx[i];
        if (nX >= 0 && nX < m && nY >= 0 && nY < n 
          && !visited[nY][nX] && maze[nY][nX] != 0) {
            maze[nY][nX] = maze[pair[0]][pair[1]] + 1;
            visited[nY][nX] = true;
            q.add(new int[]{nY, nX});
        }
      }
    }
  }

}