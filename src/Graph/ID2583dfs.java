// https://www.acmicpc.net/problem/2583
package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ID2583dfs {
    private static int[] dy = { 0, -1, 0, 1 };
    private static int[] dx = { -1, 0, 1, 0 };
    
    public static void main(String[] args) {
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
		for (int k = 0; k < K; k++) {
			for (int[] it : rectangulars) {
				for (int i = it[1]; i < it[3]; i++) {
					for (int j = it[0]; j < it[2]; j++) {
						maze[i][j] = 1;
					}
				}
			}
        }
        
		dfs(maze);
    }

	public static void dfs(int[][] maze) {
        int[][] answers = new int[maze.length][maze[0].length];
        List<Integer> ans = new ArrayList<>();
		
		int count = 1;
        boolean[][] visited = new boolean[maze.length][maze[0].length];

		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				if (visited[i][j] != true && maze[i][j] == 0) {
                    int maxVal = dfsUtil(visited, maze, i, j, count, answers);
                    ans.add(maxVal);
				}
			}
        }
        
        System.out.println(ans.size());
        ans.sort((e1, e2) -> e1.compareTo(e2));
        for (int e: ans) {
            System.out.print(e + " ");
        }
        System.out.println();

		System.out.println("Answer : ");
		for (int[] it : answers) {
			System.out.println(Arrays.toString(it));
		}
		
	}

	private static int dfsUtil(boolean[][] visited, int[][] maze, int y, int x, int count, int[][] answers) {
		
		visited[y][x] = true;
        answers[y][x] = count;
        int lastCount = count; // flag
        
		for (int i = 0; i < 4; i++) {
			int nX = x + dx[i];
			int nY = y + dy[i];
			if (nX >= 0 && nX < maze[0].length && nY >= 0 && nY < maze.length) {
				if (visited[nY][nX] == false && maze[nY][nX] == 0) {
					visited[nY][nX] = true;
                    // answers[nY][nX] = answers[y][x] + 1; // if bfs
                    answers[nY][nX] = 1 + lastCount; // if dfs
                    lastCount = dfsUtil(visited, maze, nY, nX, answers[nY][nX], answers);
				}
			}		
		}

		return lastCount;
	}
}
