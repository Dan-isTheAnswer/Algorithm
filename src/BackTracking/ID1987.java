package BackTracking;

class ID1987 {
    private static String pathAns = "";

    public static void main(String[] args) {
        String[][] a = {{"C", "A", "A", "B"}, 
                        {"A", "D", "C", "B"},
                        {"B", "D", "A", "B"}};

        bt(a);
        System.out.println(pathAns);
        System.out.println(pathAns.length()); 
    }


    public static void bt(String[][] a) {
        String path = "";
        if (btUtil(a, 0, 0, path)) {
            System.out.println("done");
        } else {
            System.out.println("failed");
        }
    }


    // (a, 0, 0, 0)
    private static boolean btUtil(String[][] a, int row, int col, String path) {

        // come from right or come from above
        if ((row >= a.length-1 && col >= a[0].length) || (row >= a.length && col >= a[0].length-1)) {
            swapAns(path);
            return true;
        }

        String tmp = path;
        if (isSafe(a, row, col, path)) {
            path += a[row][col];

            // east
            if(btUtil(a, row, col+1, path)) {
                return true;
            }
            // south
            if(btUtil(a, row+1, col, path)) {
                return true;
            }
            // west
            if(btUtil(a, row, col-1, path)) {
                return true;
            }
            // north
            if(btUtil(a, row-1, col, path)) {
                return true;
            }
            
        }
        
        // System.out.println(path);
        swapAns(path);
        path = tmp;
        return false;
    } 

    private static boolean isSafe(String[][] a, int nr, int nc, String path) {

        // range 
        if (nr < 0 || nc < 0 || nr >= a.length || nc >= a[0].length) {
            return false;
        }

        // one of them: check the last element first so that we don't go back to where we come from. 
        // i.e. prevent unnecessary cycle. 
        for (int i = path.length()-1; i >= 0; i--) {
            if (a[nr][nc].charAt(0) == path.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    private static void swapAns(String path) {
        if (pathAns.length() < path.length()) {
            pathAns = path;
        }
    }
}

// One thing for sure is that you must go back to the previous value when backtracking.
// **Don't add or remove. e.g. list.add(e); list.remove(e); (x) 
// If you add or remove, you could remove elements multiple times.... 