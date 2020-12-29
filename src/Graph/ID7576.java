// https://www.acmicpc.net/problem/7576
package Graph;

import java.util.ArrayDeque;
import java.util.Queue;

// Shortest Path
class ID7576tmp2 {

    private static int[][] maze;
    private static int M, N;

    public static int bfs() {
        // 0: west; 1: south; 2: east; 3: North;
        int[] dy = {0, -1, 0, 1};
        int[] dx = {-1, 0, 1, 0};

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited= new boolean[N][M];

        whereIsTheStartPoints(q, visited);

        int[] turn;
        while (!q.isEmpty()) {
            turn = q.poll(); 
            for (int i = 0; i < 4; i++) {
                int nY = turn[0] + dy[i];
                int nX = turn[1] + dx[i];
                if (nY >= 0 && nX >= 0 &&
                    nY < N && nX < M &&
                    maze[nY][nX] != -1 &&
                    visited[nY][nX] != true) {
                        q.add(new int[]{nY, nX});
                        visited[nY][nX] = true;
                        maze[nY][nX] = maze[turn[0]][turn[1]] +1;
                    }
            }
            
        }
        

        return whatIsTheAnswer(q, visited);
    }
    
    private static void whereIsTheStartPoints(Queue<int[]> q, boolean[][] visited){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maze[i][j] == 1) {
                    q.add(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }
    }

    private static int whatIsTheAnswer(Queue<int[]> q, boolean[][] visited) {
        boolean isZero = false;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maxVal = Math.max(maxVal, maze[i][j]);
                if (maze[i][j] == 0) isZero = true;
            }
        }

        if (isZero) return -1;
        else        return maxVal -1;
    }

    private static void print() {
        for (int[] i : maze) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        M = 6; // x
        N = 4; // y
        // maze = new int[][]{ {0, 0, 0, 0, 0, 0},
        //                     {0, 0, 0, 0, 0, 0},
        //                     {0, 0, 0, 0, 0, 0},
        //                     {0, 0, 0, 0, 0, 1}  };
        // maze = new int[][]{ {1, -1, 0, 0, 0, 0},
        //                     {0, -1, 0, 0, 0, 0},
        //                     {0, 0, 0, 0, -1, 0},
        //                     {0, 0, 0, 0, -1, 1}   };

        // maze = new int[][]{ {1, -1}, {-1, 1}};
        maze = new int[][]{ {0, -1, 0, 0, 0, 0},
                            {-1, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 1}};

        int result = bfs();
        System.out.println(result);
        print();
        
    }

}

// return the largest num -1;
/**
 * One queue is enough:)
 * The order of which grown tomato is next is dependent on Queue. 
 * And they take their turn in order as in Queue and share boolean[] visited.
 * Return integer when the queue is empty. 
 */

/**
 * When building up algorithms, 
 * First, build up the most basic structure and test.
 * Second, add function one by one and test. 
 * Last, test again. 
 */