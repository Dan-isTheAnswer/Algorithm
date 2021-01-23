package Dijkstra;

class GFGShortestPath {
    private static int numV = 5;
    
    public static void main(String[] args) {
        
		/* Let us create the example graph discussed above */
		// int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
		// 							{ 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
		// 							{ 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
		// 							{ 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
		// 							{ 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
		// 							{ 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
		// 							{ 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
		// 							{ 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
        // 							{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } }; 
        

        // int graph[][] = new int[][] { { 0, 0, 1, 2, 0, 0, 0 }, { 0, 0, 2, 0, 0, 3, 0 }, { 1, 2, 0, 1, 3, 0, 0 },
        // { 2, 0, 1, 0, 0, 0, 1 }, { 0, 0, 3, 0, 0, 2, 0 }, { 0, 3, 0, 0, 2, 0, 1 }, { 0, 0, 0, 1, 0, 1, 0 } };

        int[][] graph = new int[][] {{0, 0, 0, 0, 0}, {0, 0, 2, 10, 0},{0, 5, 0, 10, 1},{0, 1, 0, 0, 0},{0, 0, 0, 4, 0}};
        dijkstra(graph, 1); 
    }

    public static void dijkstra(int[][] graph, int src) {
        int[] dist = new int[numV]; // distance from src to v
        boolean[] visited = new boolean[numV];

        for (int i = 0; i < numV; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[src] = 0;
        for (int i = 0; i < numV-1; i++) {
            int u = minDistIndex(dist, visited);
            visited[u] = true;
            for (int v = 0; v < numV; v++) {
                // if there is a path from src to u && from u to v
                if (dist[u] != Integer.MAX_VALUE && graph[u][v] != 0) { 
                    if (!visited[v] && dist[u] + graph[u][v] < dist[v]) {
                        dist[v] = dist[u] + graph[u][v];
                    }
                }
            }
        }
        printDist(dist);
    }

    // vertex u is determined by its distance. 
    private static int minDistIndex(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < numV; v++) {
            if (visited[v] == false && dist[v] < min) {
                min = dist[v];
                min_index = v;
            }
        }

        return min_index;
    }

    private static void printDist(int[] dist) {
        System.out.println("Vertex \t\t Distance from Source"); 
        for (int i = 0; i < numV; i++) 
            System.out.println(i + " \t\t " + dist[i]); 
    }

}
