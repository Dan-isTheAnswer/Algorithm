// https://www.acmicpc.net/problem/2146
package BFS;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

class MyID2146 {
    private static int[] dy = { 0, 0, 1, -1 };
    private static int[] dx = { 1, -1, 0, 0 };

    public static void main(String[] args) throws IOException {
        int n = 5; // ans is 1
        String[] inputs = { 
            "1 0 0 0 1",
            "0 0 0 1 0",
            "0 0 0 0 0",
            "0 0 0 0 0",
            "0 0 0 0 0"
        };

        // int n = 5; // ans is 2
        // String[] inputs = {
        //     "1 0 0 0 1",
        //     "0 0 0 0 0",
        //     "0 0 0 0 0",
        //     "0 0 0 0 0",
        //     "1 1 0 0 1"
        // };
        
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = inputs[i].split(" ");
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(input[j]);
            }
        }

        List<List<int[]>> islands = preprocess(grid, n); 

        int result = shortest(grid, n, islands);
        System.out.println(result);
        printGrid(grid);
    }

    // boolean[][] visited is unnecessary here 
    // since int[][] grid acts as visited flag.
    private static int shortest(int[][] grid, int n, List<List<int[]>> islands) {
        Queue<List<int[]>> q = new ArrayDeque<>();

        for (ListIterator<List<int[]>> li = islands.listIterator(); li.hasNext(); ) {
            q.add(li.next());
        }

        while (!q.isEmpty()) {
            List<int[]> island = q.poll();
            List<int[]> nIsland = new ArrayList<>();
            for (int i = 0; i < island.size(); i++) {
                int[] tmp = island.get(i);
                int y = tmp[0]; int x = tmp[1];
                int c = tmp[2]+1; // cycle**
                for (int j = 0; j < 4; j++) {
                    int ny = y + dy[j]; int nx = x + dx[j];
                    if (ny >= 0 && ny < n && nx >=0 && nx < n) {
                        if (grid[ny][nx] == 0) {
                            nIsland.add(new int[] {ny, nx, c});
                            grid[ny][nx] = grid[y][x];

                            for (int k = 0; k < 4; k++) {
                                int nny = ny + dy[k]; int nnx = nx + dx[k];
                                if (nny >= 0 && nny < n && nnx >= 0 && nnx < n) {
                                    if (grid[nny][nnx] != grid[y][x] && grid[nny][nnx] != 0) {
                                        if (grid[nny][nnx] > grid[y][x]) {
                                            return c + c-1;
                                        } 
                                        return c + c;
                                    }
                                } 
                            }
                        }

                    }
                }
            }

            if (!nIsland.isEmpty()) {
                q.add(nIsland);
            }
        }

        return -1;
    }

    private static List<List<int[]>> preprocess(int[][] grid, int n) {
        List<List<int[]>> islands = new ArrayList<>();
        
        int color = 1; 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    color++;
                    List<int[]> island = setIslandColor(grid, color, i, j);
                    islands.add(island);
                }
            }
        }

        return islands;
    }

    private static List<int[]> setIslandColor(int[][] grid, int color, int r, int c) {
        List<int[]> island = new ArrayList<>();
        
        int n = grid.length;
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];

        q.add(new int[] {r, c});
        visited[r][c] = true;

        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int y = tmp[0]; int x = tmp[1];
            island.add(new int[] {y, x, 0});
            grid[y][x] = color;
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i]; int nx = x + dx[i];
                if (ny >= 0 && ny < n && nx >= 0 && nx < n) {
                    if (!visited[ny][nx] && grid[ny][nx] == 1) {
                        q.add(new int[]{ny, nx});
                        visited[ny][nx] = true;
                    }
                }
            }
        }

        return island;
    }

    private static void printGrid(int[][] grid) {
        for (int[] arr : grid) {
            System.out.println(Arrays.toString(arr));
        }
    }
}

/**
 * boolean[][] visited should be set true 
 * as soon as possible after adding data into queue. 
 * 
 * By doing so, we can prevent the queue 
 * from enqueueing the same data redundantly. 
 */