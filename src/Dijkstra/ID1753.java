// https://www.acmicpc.net/problem/1753
package Dijkstra;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// visited set
class ID1753 {
    private static class Direction implements Comparable<Direction> {
        Edge edge;
        int dist;

        Direction(Edge edge, int dist) {
            this.edge = edge;
            this.dist = dist;
        }

        @Override
        public int compareTo(Direction o) {
            return Integer.compare(dist, o.dist);
        }
    }

    private static class Edge {
        int dest;
        int w;

        Edge(int dest, int w){
            this.dest = dest;
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
        List<List<Edge>> vertices = new ArrayList<>();
        for (int i = 0; i < V+1; i++) {
            vertices.add(new ArrayList<>()); // add adjVertices
        }
        for (String e : input) {
            st = new StringTokenizer(e);
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            vertices.get(src).add(new Edge(dest, weight));
        }


        ID1753 ans = new ID1753();
        ans.solve(vertices, start);
    }

    public void solve(List<List<Edge>> vertices, int start) {
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

    public int[] djk(List<List<Edge>> vertices, int start) {
        PriorityQueue<Direction> q = new PriorityQueue<>();
        int[] dist = new int[vertices.size()];
        for (int i = 0; i < vertices.size(); i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        q.add(new Direction(new Edge(start, 0), 0));

        while (!q.isEmpty()) {
            int u = q.poll().edge.dest;
            List<Edge> adjV = vertices.get(u);

            for (ListIterator<Edge> vIt = adjV.listIterator(); vIt.hasNext(); ) {
                Edge v = vIt.next();
                if (dist[u] != Integer.MAX_VALUE) {
                    if (dist[v.dest] > dist[u] + v.w) {
                        dist[v.dest] = dist[u] + v.w;
                        q.add(new Direction(new Edge(v.dest, v.w), dist[v.dest]));
                        
                    }
                }
            }
        }

        return dist;
    }

    public static void printVertices(List<List<Edge>> vertices) {

        for (int i = 0; i < vertices.size(); i++) {
            List<Edge> source = vertices.get(i);
            for (ListIterator<Edge> lI = source.listIterator(); lI.hasNext(); ) {
                Edge a = lI.next();
                System.out.println("source is : " + i + " has " + a.dest + " with weight : " + a.w);
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


/**
 * visited[] + minDistIndex VS. Priority Queue 
 * 
 * minDistIndex in which iteration occurrs while finding the index having the min distance 
 * 
 * Priority Queue provides three basic operations: 
 * 1) add vertex with priority
 * 2) decrease vertex's priority
 * 3) extract min vertex 
 * when using pq, visited[] is unnecessary because unvisited verticeis from u are added in Priority Queue:)
 * 
 * Thus, Prioriy Queue is more preferable since it is easy to implement
 * and efficient when a graph has a lot of vertices (according to ref 2).
 */

/**
 * !!Not recommended:
 * Queue + visited[] could cause bad performance 
 * since updating happens sequentially. 
 */

/**
 * References:
 * 1) https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
 * 2) https://sungjk.github.io/2016/05/13/Dijkstra.html
 * 3) https://www.acmicpc.net/board/view/34516
 * 
 */