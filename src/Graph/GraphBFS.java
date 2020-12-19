package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

class GraphBFS {
    private List<List<Integer>> adjLists;

    private GraphBFS(List<Edge> edges, int size) {
        adjLists = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            adjLists.add(new ArrayList<>());
        }

        for (Edge e : edges) {
            adjLists.get(e.src).add(e.dest); // Indirected Graph.
            adjLists.get(e.dest).add(e.src); 
        }
    }

    private static class Edge {
        private int src;
        private int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }


    // in a recursive manner 
    private void bfs(boolean[] visited, Queue<Integer> q, int d) {
        int node = q.poll();

        if (node == d) { // base case
            System.out.println("Got it");
            System.out.println(node);
            return;
        }

        
        if (!visited[node]) {
            visited[node] = true;
            for (Integer dest : adjLists.get(node)) {
                q.add(dest);
            }
        }
        bfs(visited, q, d);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < adjLists.size(); i++) {
            sb.append(i +"th : ");
            
            Iterator<Integer> it = adjLists.get(i).listIterator();
            while (it.hasNext()) {
                sb.append(it.next() + " ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        
        // List of graph edges as per above diagram
        List<Edge> edges = Arrays.asList(
                new Edge(1, 2), new Edge(1, 3), new Edge(1, 4),
                new Edge(2, 5), new Edge(2, 6), new Edge(5, 9),
                new Edge(5, 10), new Edge(4, 7), new Edge(4, 8),
                new Edge(7, 11), new Edge(7, 12)
                // vertex 0, 13 and 14 are single nodes
        );

        GraphBFS g = new GraphBFS(edges, 15);
        boolean[] visited = new boolean[15+1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        g.bfs(visited, q, 10);

    }
}