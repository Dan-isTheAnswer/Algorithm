// https://www.geeksforgeeks.org/java-program-for-n-queen-problem-backtracking-3/
package BackTracking;

// Backtracking 
class NQ {
    final int N = 4;

    public static void main(String[] args) {
        NQ queen = new NQ();
        queen.solveNQ();
    }


    

    public boolean solveNQ() {
        int[][] board = { {0, 0, 0, 0}, 
                          {0, 0, 0, 0}, 
                          {0, 0, 0, 0},
                          {0, 0, 0, 0}};
        
        if (solveNQUtil(board, 0) == false) {
            System.out.println("Solution does not exist");
            return false;
        } else {
            // Print the board. 
            for (int[] it : board) {
                for (int e : it) {
                    System.out.print(e + " ");
                }
                System.out.println();
            }
            return true;
        }
    }

    // A recursive utility function to solve N Queen problem 
    private boolean solveNQUtil(int[][] board, int col) {
        if (col >= N) return true; // base case

        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1; //set path

                // recur to place rest of the queens until meeting the base case. 
                // If failed, reset its path from the last point (BACKTRACK). 
                if (solveNQUtil(board, col+1) == true) {
                    return true;
                } else { 
                    board[i][col] = 0; // **backtrack
                }
            }
        }

        return false;
    }

    // Note that we are going to place the next queen at (row, col) in the right direction via solveNQUtil(). Check if the next queen is safe.  
    private boolean isSafe(int[][] board, int row, int col) {
        
        // check the left side of the point (row, col) horizontally
        for (int i = col; i >= 0; i--) {
            if (board[row][i] == 1) return false;
        }

        // check the left upper side of the point diagonally
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }

        // check the left lower side of the point diagonally
        for (int i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1) return false;
        }

        return true;
    }

}
// Backtracking algorithm : visited flag + path 
// Each shot from the very first start has its own a visited flag. 
// This makes the difference from BFS and DFS which both share the visited flag.
