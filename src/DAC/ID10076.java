// https://www.acmicpc.net/problem/10076
package DAC;

import java.util.Arrays;

// failed: Exceed Memory Limit...
class ID10076 {
    private static int n;
    private static int start;
    private static int d;
    private static int[] tourList;
    
    public static void main(String[] args) {
        n = 5;
        start = 2;
        d = 7;
        tourList = new int[] {10, 2, 20, 30, 1}; // n times
        // int[] tourList = {10, 1, 30, 2, 20}; // I think the answer is 52 but error occurred...
        boolean[] visited = new boolean[n];

        ID10076 tour = new ID10076();
        int result = tour.tour(tourList, 1, start, visited, 0);
        System.out.println(result);
    }

    public int tour(int[] tourList, int cnt, int cur, boolean[] visited,int val) {
        if (d < cnt) 
            return val; // base case

        boolean[] isVisited = Arrays.copyOf(visited, visited.length);
        // to the left
        int prev = 0;
        if (cur > 0) {
            prev = tour(tourList, cnt+1, cur-1, isVisited, val);
        } 

        int here = 0;
        if (!isVisited[cur]) {
            isVisited[cur] = true;
            here = tour(tourList, cnt+1, cur, isVisited, val+tourList[cur]);
        }

        // to the right
        int next = 0;
        if (cur < tourList.length-1) {
            next = tour(tourList, cnt+1, cur+1, isVisited, val);
        }

        int maxVal = Integer.max(prev, Integer.max(here, next));
        return maxVal;
    }
}
