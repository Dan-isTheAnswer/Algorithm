package BackTracking;

// Backtracking: advanded NQ problem 
class Sudoku{

    public static void main(String[] args) {
        int[][] grid = new int[][] { {0, 3, 5, 4, 6, 9, 2, 7, 8},
                                        {7, 8, 2, 1, 0, 5, 6, 0, 9},
                                        {0, 6, 0, 2, 7, 8, 1, 3, 5},
                                        {3, 2, 1, 0, 4, 6, 8, 9, 7},
                                        {8, 0, 4, 9, 1, 3, 5, 0, 6},
                                        {5, 9, 6, 8, 2, 0, 4, 1, 3},
                                        {9, 1, 7, 6, 5, 2, 0, 8, 0},
                                        {6, 0, 3, 7, 0, 1, 9, 5, 2},
                                        {2, 5, 8, 3, 9, 4, 7, 6, 0}};
                                        
        // int[][] sudoku = new int[][] { {2, 1, 3},
        //                                 {1, 3, 2},
        //                                 {3, 2, 1}};
        
        // int[][] sudoku = new int[][] { {0, 1, 3},
        //                                 {1, 0, 2},
        //                                 {0, 2, 1}};
                                        
                                        
        backtrack(grid);
    }

    public static void backtrack(int[][] grid) {
        if (backtrackUtil(grid, 0, 0)) {
            printAns(grid);
        } else {
            System.out.println("faild");
        }

    }

    private static boolean backtrackUtil(int[][] grid, int row, int col) {
        if (row >= grid.length-1 && col >= grid.length) {
            return true; // base case
        }

        // **change row
        if (col == grid.length) {
            row++;
            col = 0;
        }
        // **skip to the next
        if (grid[row][col] >0) 
            return backtrackUtil(grid, row, col+1);


        for (int num = 1; num <= grid.length; num++) {
            if (isSafe(grid, row, col,num)) {
                grid[row][col] = num;

                // right
                if (backtrackUtil(grid, row, col+1)) {
                    return true;
                } 

            }
            grid[row][col] = 0;
        }

        return false; 
    } 
    
    // three cases: 1. horizontally 2. vertically 3. square area
    private static boolean isSafe(int[][] grid, int row, int col, int num) {
        // 1. horizontally
        for (int i = 0; i < grid.length; i++) {
            if (grid[row][i] == num) {
                return false;
            }
        }

        // 2. vertically
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][col] == num) {
                return false;
            }
        }

        // 3. square area
        int startR = 3*(row /3); // 6: 2; 7: 2;
        int startC = 3*(col /3);
        for (int i = startR; i < startR+3; i++) {
            for (int j = startC; j < startC+3; j++) {
                if (grid[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void printAns(int[][] grid) {
        for (int[] arr : grid) {
            for (int e : arr) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
