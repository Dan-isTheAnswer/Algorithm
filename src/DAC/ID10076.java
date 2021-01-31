// https://www.acmicpc.net/problem/10076
package DAC;

// Tried Bitmasking but...
// failed: Exceed Time Limit...
class ID10076 {
    private static int n;
    private static int start;
    private static int d;
    private static int[] tourList;
    
    public static void main(String[] args) {
        n = 5;
        start = 2;
        // d = 8; // r + 30 + l + 20 + l + 2 + l + 10
        d = 7;
        tourList = new int[] {10, 2, 20, 30, 1}; // n times
        // int[] tourList = {10, 1, 30, 2, 20}; // the answer is 52 but error occurred...
        // boolean[] visited = new boolean[n];

        int toured = 0; // **bitmasking 
        ID10076 tour = new ID10076();
        int result = tour.tour(0, start, toured, 0);
        System.out.println(result);
    }

    public int tour(int cnt, int curr, int toured,int val) {
        if (d == cnt) 
            return val; // base case

        // this causes memory exceeding. 
        // boolean[] isVisited = Arrays.copyOf(visited, visited.length);
        
        // to the left
        int prev = 0;
        if (curr > 0) {
            prev = tour(cnt+1, curr-1, toured, val);
        } 

        int here = 0; // | 
        if ((toured | 1 << n - curr) != toured) { 
            // isVisited[cur] = true;
            int isToured = toured | 1 << n - curr;
            here = tour(cnt+1, curr, isToured, val+tourList[curr]);
        }

        // to the right
        int next = 0;
        if (curr < tourList.length-1) {
            next = tour(cnt+1, curr+1, toured, val);
        }

        int maxVal = Integer.max(prev, Integer.max(here, next));
        return maxVal;
    }
}
