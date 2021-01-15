// https://www.acmicpc.net/problem/1987
package DFS;

class ID1987 {
    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, -1, 0, 1};
    private String[][] grid; 
    private boolean[] visited = new boolean[26];

    public static void main(String[] args) {
        ID1987 ans = new ID1987(); 

        String[][] a = {{"A", "B", "C", "D"},
                        {"B", "C", "D", "E"},
                        {"C", "D", "A", "F"}};

        ans.grid = a;

        System.out.println(ans.dfs());
    }

    public int dfs() {
        int count = 1; 
        visited[grid[0][0].charAt(0) -65] = true;
        count = dfsUtil(0, 0, count);

        return count;
    }

    private int dfsUtil(int y, int x, int count) {
        int maxVal = count;
        for (int i = 0; i < 4; i++) {
            int nY = y + dy[i];
            int nX = x + dx[i];
            if (nY >= 0 && nY < grid.length &&
            nX >= 0 && nX < grid[0].length ) {
                int pChar =  grid[nY][nX].charAt(0) -65;
                if (visited[pChar] != true) {
                    visited[pChar] = true;
                    maxVal = Integer.max(maxVal, dfsUtil(nY, nX, count+1)); // breakpoint
                    visited[pChar] = false;
                }
            }
        }

        return maxVal; // breakpoint
    }
}

/**
 * When to process String, it is usually better to go with ASCII code. 
 * Since we can directly approach data at the index, which represents as ASCII code:)
 */