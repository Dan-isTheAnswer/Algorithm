package Graph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// DFS: Recursive Call, not DAC.
class ID11724 {
    
    public static void main(String[] args) throws IOException {

        int N = 6; 
        // int numEdge = 8;
        List<List<Integer>> adjLists = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            adjLists.add(new ArrayList<>());
        }

        // int a, b 
        // int[][] edges = new int[][] { {1,2}, {2,5}, {5,1}, {3,4}, {4,6}};
        int[][] edges = new int[][] {{1,2}, {2,5}, {5,1}, {3,4}, {4,6}, {5,4}, {2,4}, {2,3} };
        for (int[] i: edges) {
            adjLists.get(i[0]).add(i[1]);
            adjLists.get(i[1]).add(i[0]);
        }
        // sort 
        for (int i = 0; i < N; i++) {
            adjLists.get(i).sort((e1, e2) -> e1.compareTo(e2));
        }
        
        int result = dfsAndReturnCount(N, adjLists);
        System.out.println(result);
        
    }
    
    public static int dfsAndReturnCount(int N, List<List<Integer>> adjLists) {
        boolean[] visited = new boolean[N+1];
        int count = 0;
        
        for (int i = 1; i < N+1; i++) {
            if (!visited[i]) {
                count++;
                System.out.print("Start : " + i);
                dfsUtil(i, visited, adjLists);
                System.out.println();
            }
        }

        return count;
    }
    
    // (src, visited, adjLists)  
    public static void dfsUtil(int element, boolean[] visited, List<List<Integer>> adjLists) {
        visited[element]= true;

        List<Integer> srcList = adjLists.get(element);
        for (Iterator<Integer> it = srcList.iterator(); it.hasNext(); ) {
            int e = it.next();
            if (!visited[e]) {
                System.out.print(" " + e);
                dfsUtil(e, visited, adjLists);
            }
        }
    }
}
