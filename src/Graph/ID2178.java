package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import Graph.ID2178.Graph.Edge;

class ID2178 {
    private static int n = 4;
    private static int m = 6;
    private static int[] data = new int[n*m];
    private static int[] ans = new int[n*m];
    
    public static void main(String[] args) throws IOException {
        List<String> strLines = new ArrayList<>();
        strLines.add("101111");
        strLines.add("101010");
        strLines.add("101011");
        strLines.add("111011");

        for (String line: strLines) {
            preprocessData(m, line);
        }
        
        Graph graph = new Graph(n*m);

    }

    public static void preprocessData(int m, String line) {
            data[i] = line.charAt(i) - '0';
    }


    private static class Graph {
        List<List<Integer>> verticies;

        public Graph(List<Edge> edges, int n) {
            verticies = new ArrayList<>();
            for (int i=0; i<n; i++) {
                List<Integer> adjVerticies = new ArrayList<>();
                verticies.add(adjVerticies);
            }

            for (Edge e : edges) {
                verticies.get(e.src).add(e.dest);
            }
        }


        private class Edge {
            int src;
            int dest;

            public Edge(int src, int dest) {
                this.src = src;
                this.dest = dest;
            }

        }
    }
}
// TODO: Not finished yet. 