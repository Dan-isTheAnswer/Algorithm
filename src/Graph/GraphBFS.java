package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

class GraphBFS {
    private List<List<Edge>> adjLists;

    private GraphBFS(List<Edge> edges, int size) {
        adjLists = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            adjLists.add(new ArrayList<>());
        }

        for (Edge e : edges) {
            adjLists.get(e.src).add(e); // Directed Acyclic Graph.
            // adjLists.get(e.dest).add(e); 
            // Error: e.g. when adding Edge(1,2), 2nd node indicates to itself becasue queue.add(e.dest). 
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


    private int bfs(int s, int d) {
        boolean[] visited = new boolean[adjLists.size()+1]; // if (visited[1] == true) I visited the vertex 1. 
        Queue<Integer> q = new ArrayDeque<>(); 

        // visited[s] = true;
        q.add(s);

        int pollCount = 0;
        while (!q.isEmpty()) {
            pollCount++;
            int node = q.poll();
            if (node == d) {
                return pollCount;
            }
            if (!visited[node]) {
                visited[node] = true;
                for (Edge e : adjLists.get(node) ) {
                    q.add(e.dest);
                }
            }

        }

        return -1;

    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < adjLists.size(); i++) {
            sb.append(i +"th : ");
            
            Iterator<Edge> it = adjLists.get(i).listIterator();
            while (it.hasNext()) {
                sb.append(it.next().dest + " ");
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
        int count = g.bfs(1, 10);
        System.out.println(count);

        System.out.println(g);
    }
}