package Dijkstra;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// visited set
class ID1753op2 {
    private static class Graph implements Comparable<Graph> {
        Node u;
        int dist;

        Graph(Node u, int dist) {
            this.u = u;
            this.dist = dist;
        }

        @Override
        public int compareTo(Graph o) {
            return Integer.compare(dist, o.dist);
        }
    }

    private static class Node {
        int d;
        int w;

        Node(int d, int w){
            this.d = d;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        // int V = 5;
        // int E = 6;
        // int start = 1;

        // String[] input = {"5 1 1", "1 2 2", "1 3 3", "2 3 4", "2 4 5", "3 4 6"}; // E times
        // int V = 4;
        // int E = 8;
        // int start = 1;
        // String[] input = {"1 2 3", "2 1 5", "4 3 4", "2 3 10", "1 3 10", "2 4 1", "3 1 1", "1 2 2"}; // ans: 0 2 7 3 


        int V = 5;
        // int E = 5;
        int start = 1;
        String[] input = {"1 2 2", "1 3 3", "2 4 1", "4 5 2", "3 5 1"}; // E times

        StringTokenizer st;
        List<List<Node>> vertices = new ArrayList<>();
        for (int i = 0; i < V+1; i++) {
            vertices.add(new ArrayList<>()); // add adjVertices
        }
        for (String e : input) {
            st = new StringTokenizer(e);
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            vertices.get(src).add(new Node(dest, weight));
        }


        ID1753op2 ans = new ID1753op2();
        ans.solve(vertices, start);
    }

    public void solve(List<List<Node>> vertices, int start) {
        int[] result = djk(vertices, start);
        System.out.println(Arrays.toString(result));
        for (int i = 1; i < result.length; i++) {
            int e = result[i];
            if (e != Integer.MAX_VALUE) {
                System.out.println(e);
            } else {
                System.out.println("INF");
            }
        }
    }

    public int[] djk(List<List<Node>> vertices, int start) {
        PriorityQueue<Graph> q = new PriorityQueue<>();
        boolean[] visited = new boolean[vertices.size()];
        int[] dist = new int[vertices.size()];
        for (int i = 0; i < vertices.size(); i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        q.add(new Graph(new Node(start, 0), 0));

        while (!q.isEmpty()) {
            int u = q.poll().u.d;
            visited[u] = true;
            List<Node> adjV = vertices.get(u);

            for (ListIterator<Node> vIt = adjV.listIterator(); vIt.hasNext(); ) {
                Node v = vIt.next();
                if (dist[u] != Integer.MAX_VALUE) {
                    if (!visited[v.d] && 
                        dist[v.d] > dist[u] + v.w) {
                        dist[v.d] = dist[u] + v.w;
                        q.add(new Graph(new Node(v.d, v.w), dist[v.d]));
                        
                    }
                }
            }
        }

        return dist;
    }

    public static void printVertices(List<List<Node>> vertices) {

        for (int i = 0; i < vertices.size(); i++) {
            List<Node> source = vertices.get(i);
            for (ListIterator<Node> lI = source.listIterator(); lI.hasNext(); ) {
                Node a = lI.next();
                System.out.println("source is : " + i + " has " + a.d + " with weight : " + a.w);
            }
            System.out.println();
        }
    }
}

/**
 * Priority Queue based on Distance (o) vs Priority Queue based on Weight (x) 
 * 
 * e.g. 
 * 1 to 2 with weight 2
 * 2 to 4 with 4
 * 4 to 5 with 2
 * 1 to 3 with 3
 * 3 to 5 with 1
 * 
 * if pq based on weight: 
 * 1 -> 2,3 -> 4,3 -> 5,3 -> 3
 * which results in {0 2 3 3 5}
 * 
 * if pq based on distance:
 * 1 -> 2,3 -> 3,4 -> 5,4 -> 4
 * which results in {0 2 3 3 4}
 */

 // visited is useless??