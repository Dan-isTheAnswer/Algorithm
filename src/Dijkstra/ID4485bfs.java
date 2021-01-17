// https://www.acmicpc.net/problem/4485
package Dijkstra;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

// Dijkstra algorithm
class ID4485bfs {
    private static int[] dy = {-1, 0, 1, 0};
    private static int[] dx = {0, -1, 0, 1};

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
        int[][] graph= { {9, 0, 5, 1, 1, 5, 3},
                          {4, 1, 2, 1, 6, 5, 3},
                          {0, 7, 6, 1, 6, 8, 5},
                          {1, 1, 7, 8, 3, 2, 3},
                          {9, 4, 0, 7, 6, 4, 1},
                          {5, 8, 3, 2, 4, 8, 3},
                          {7, 4, 8, 4, 8, 3, 4}};
                          

        int result = bfs(graph, n);
        System.out.println(result); 
    }

    public static int bfs(int[][] graph, int n) {
        int[][] dist = new int[n][n];
        // boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        dist[0][0] = graph[0][0];
        q.add(new int[] {0, 0});

        while (!q.isEmpty()) {
            int[] u = q.poll();
            // visited[u[0]][u[1]] = true;
            for (int i = 0; i < 4; i++) {
                int nY = u[0] + dy[i];
                int nX = u[1] + dx[i];
                if (dist[u[0]][u[1]] != Integer.MAX_VALUE && 
                    nY >= 0 && nY < n && nX >= 0 && nX < n) {
                    if (dist[nY][nX] > dist[u[0]][u[1]] + graph[nY][nX]) {
                        dist[nY][nX] = dist[u[0]][u[1]] + graph[nY][nX];
                        q.add(new int[] {nY, nX});
                    }
                }

            }
        }
        printDist(dist);
        
        return dist[n-1][n-1];
    }

    private static void printDist(int[][] dist) {
        for (int[] y : dist) {
            System.out.println(Arrays.toString(y));
        }
    }
}
/**
 * Graph vs Map:
 * - Graph: the middle vertex, u, is clear.
 * - Map: the middle vertex, u, is unclear. 
 * i.e. the destination vertex, v, could be u again. 
 * i.e. the distance from src to v could sequentially 
 * be changed in a inverse order. 
 * 
 * Thus, in Map, I didn't use "visited". 
 */