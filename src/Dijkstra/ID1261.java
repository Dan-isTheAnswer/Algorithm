// https://www.acmicpc.net/problem/1261
package Dijkstra;

import java.util.ArrayDeque;
import java.util.Queue;

class ID1261 {
    private static int[] dy = {-1, 0, 1, 0};
    private static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) {
        // int M = 3; // col
        // int N = 3; // row 
        int M = 6;
        int N = 6;

        // String[] data= new String[]{"011", "111", "110"}; 
        String[] data = new String[] {"001111", "010000", "001111", "110001", "011010", "100010"};
        int[][] map = new int[N][M];
        
        int row = 0;
        for (String nums : data) {
            for (int i = 0; i < M; i++) {
                map[row][i] = nums.charAt(i) -'0';
            } 
            row++;
        }

        // for (int[] a : map) {
        //     System.out.println(Arrays.toString(a));
        // }

        ID1261 ans = new ID1261();
        System.out.println(ans.solve(map));
    }

    public int solve(int[][] map) {

        int[][] dist = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        int result = dijkstra(map, dist);
        return result;
    }

    public int dijkstra(int[][] map, int[][] dist) {
        Queue<int[]> q = new ArrayDeque<>();
        // visited 

        dist[0][0] = map[0][0];
        q.add(new int[]{0,0});
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            // visited
            int y = tmp[0];
            int x = tmp[1];
            for (int i = 0; i < 4; i++) {
                int nY = y + dy[i];
                int nX = x + dx[i];
                if (dist[y][x] != Integer.MAX_VALUE && 
                    nY >=0 && nY < map.length &&
                    nX >=0 && nX < map[0].length ) {
                    if (dist[nY][nX] > dist[y][x] + map[nY][nX]) {
                        dist[nY][nX] = dist[y][x] + map[nY][nX];
                        q.add(new int[]{nY, nX});
                    }
                }
            }
            
        }

        return dist[map.length-1][map[0].length-1];
    }
}
