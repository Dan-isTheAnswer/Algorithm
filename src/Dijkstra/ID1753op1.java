package Dijkstra;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.StringTokenizer;

// no visited set
class ID1753op1 {

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

        for (int i = 0; i < vertices.size(); i++) {
            List<Node> source = vertices.get(i);
            for (ListIterator<Node> lI = source.listIterator(); lI.hasNext(); ) {
                Node a = lI.next();
                System.out.println("source is : " + i + " has " + a.d + " with weight : " + a.w);
            }
            System.out.println();
        }

        ID1753op1 ans = new ID1753op1();
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
        Queue<Integer> q = new ArrayDeque<>();
        // boolean[] visited = new boolean[vertices.size()];
        int[] dist = new int[vertices.size()];
        for (int i = 0; i < vertices.size(); i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        q.add(start);

        while (!q.isEmpty()) {
            int u = q.poll();
            // visited[u] = true;
            List<Node> adjV = vertices.get(u);
            for (ListIterator<Node> vIt = adjV.listIterator(); vIt.hasNext(); ) {
                Node v = vIt.next();
                if (dist[u] != Integer.MAX_VALUE) {
                    if (
                        // !visited[v.d] && 
                        dist[v.d] > dist[u] + v.w) {
                        dist[v.d] = dist[u] + v.w;
                        q.add(v.d);
                    }
                }
            }
        }

        return dist;
    }
}

// update distance continuosly. 
// thus, bad performance.