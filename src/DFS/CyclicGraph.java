// https://www.geeksforgeeks.org/detect-cycle-undirected-graph/
package DFS;

import java.util.ArrayList;
import java.util.List;

// Detect a cycle using DFS
class CycleGraph {
    private int V;
    private List<List<Integer>> verticies;

    public CycleGraph(int v) {
        V = v;
        verticies = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            verticies.add(new ArrayList<>());
        }
    }

    private void addEdge(int src, int dest) {
        verticies.get(src).add(dest);
        verticies.get(dest).add(src);
    }

    public static void main(String[] args) {
        CycleGraph g1 = new CycleGraph(5);
		g1.addEdge(1, 0); 
		g1.addEdge(0, 2); 
		g1.addEdge(2, 1); 
		g1.addEdge(0, 3); 
		g1.addEdge(3, 4); 
		if (g1.isCyclic()) 
			System.out.println("Graph contains cycle"); 
		else
            System.out.println("Graph doesn't contains cycle"); 
            
        CycleGraph g2 = new CycleGraph(3);
		g2.addEdge(0, 1); 
		g2.addEdge(1, 2); 
		if (g2.isCyclic()) 
			System.out.println("Graph contains cycle"); 
		else
			System.out.println("Graph doesn't contains cycle"); 
        
    }

    public boolean isCyclic() {
        boolean[] visited = new boolean[V];

        // start if not visited
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, -1)) 
                    return true;
            }
        }

        return false;
    }

    private boolean isCyclicUtil(int v, boolean[] visited, int parent) {
        visited[v] = true;

        List<Integer> adjV = verticies.get(v);
        for (Integer vertex : adjV) {
            if (!visited[vertex]) {
                if (isCyclicUtil(vertex, visited, v))
                    return true;
            } else if (visited[vertex] && vertex != parent) {
                /**
                 * If an adjacent is visited 
                 * and not parent of current vertex,
                 * then there is a cycle.
                 */
                return true; 
            }
        }

        return false;
    }

}
