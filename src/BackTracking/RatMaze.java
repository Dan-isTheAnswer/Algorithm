package BackTracking;

class RatMaze {

    static int N;

	public static void main(String args[])
	{
		RatMaze rat = new RatMaze();
		int maze[][] = { { 1, 0, 0, 0 },
						{ 1, 1, 0, 1 },
						{ 0, 1, 0, 0 },
						{ 1, 1, 1, 1 } };

        N = maze.length;
        
		rat.solveMaze(maze);
	}



    public boolean solveMaze(int[][] maze) {
        int[][] ans = new int[N][N];

        if (solveMazeUtil(maze, 0, 0, ans) == false) {
            System.out.println("Solution doesn't exist");
            return false;
        }

        printAnswer(ans);
        return true;
    }

    // move to the right or down
    private boolean solveMazeUtil(int[][] maze, int y, int x, int[][] ans) 
    {
        if (x >= N || y >= N) {
            return true;
        }

        if (isSafe(maze, y, x) == true) {
            ans[y][x] = 1; // set its path

            // right
            if (solveMazeUtil(maze, y, x+1, ans)) {
                return true;
            } 
            // down
            if (solveMazeUtil(maze, y+1, x, ans)) {
                return true;
            } 
            ans[y][x] = 0; // Backtrack
        }

        return false;
    }

    private boolean isSafe(int[][] maze, int y, int x) {
        if (x >= 0 && x < N && y >= 0 && y < N) {
            if (maze[y][x] == 1) return true;
        }
        return false;
    }

    private static void printAnswer(int[][] ans) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(" " + ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}

