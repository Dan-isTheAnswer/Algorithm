package Dijkstra;

import java.util.ArrayDeque;
import java.util.Queue;

// How to get the minimum distance??
// Dijkstra vs BFS: int[] dist which stores the distances from src to v
class MyShortestPath{
    
    private static int V = 9;
    
    public static void main(String[] args) {
        
		/* Let us create the example graph discussed above */
		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
									{ 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
									{ 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
									{ 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
									{ 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
									{ 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
									{ 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
									{ 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
									{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } }; 
        dijkstraBFS(graph, 0);
    }


    public static void dijkstraBFS(int[][] graph, int src) {
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new ArrayDeque<>(); // (u, v)

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = graph[0][0];
        q.add(0);

        while (!q.isEmpty()) {
            int u = q.poll();
            visited[u] = true;
            for (int v = 0; v < V; v++) {
                // if there is a path from src to v through u
                if (dist[u] != Integer.MAX_VALUE && graph[u][v] != 0) {
                    if (!visited[v] && dist[v] > dist[u] + graph[u][v]) {
                        dist[v] = dist[u] + graph[u][v];
                        q.add(v);
                    }
                }
            }
        }

        printDist(dist); 
    }

    private static void printDist(int[] dist) {
        System.out.println("Vertex \t\t Distance from Source"); 
        for (int i = 0; i < V; i++) 
            System.out.println(i + " \t\t " + dist[i]); 
    }
}


