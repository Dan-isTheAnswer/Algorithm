package DataStructure;

import java.util.ArrayList;

class LinkedGraph<E extends Comparable<E>> {
    private ArrayList<Vertex> verticies;

    public LinkedGraph() {
        verticies = new ArrayList<>();
    }

    private class Vertex {
        ArrayList<Vertex> adjacentVerticies;
        E data;
        
        public Vertex(E data) {
            adjacentVerticies = new ArrayList<>();
            this.data = data;
        }

        public boolean addVertex(Vertex toV) {
            for (Vertex v : adjacentVerticies) {
                if (v.data.compareTo(toV.data) == 0) {
                    return false;
                }
            }
            return adjacentVerticies.add(toV);
        }

        public boolean removeVertex(E to) {
            for (int i = 0; i < adjacentVerticies.size(); i++) {
                if (adjacentVerticies.get(i).data.compareTo(to) == 0 ) {
                    adjacentVerticies.remove(i);
                    return true;
                } 
            } 
            return false;
        }
    }

    public boolean addEdge(E from, E to) {
        Vertex fromV = null;
        Vertex toV = null;
        for (Vertex v : verticies) {
            if (v.data.compareTo(from) == 0) {
                fromV = v;  
                break;
            }
        }
        for (Vertex v : verticies) {
            if (v.data.compareTo(to) == 0) {
                toV = v;
                break;
            }
        } 

        if (fromV == null) {
            fromV = new Vertex(from);
            verticies.add(fromV);
        }
        if (toV == null) {
            toV = new Vertex(to);
            verticies.add(toV);
        }
        return fromV.addVertex(toV);
    }

    public boolean removeEdge(E from, E to) {
        for (Vertex v : verticies) {
            if (v.data.compareTo(from) == 0) {
                return v.removeVertex(to);
            }
        }
        return false;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Vertex v : verticies) {
            sb.append("Vertex: ");
            sb.append(v.data);
            sb.append("\n");
            sb.append("Adjacent verticies: ");
            for (Vertex v2 : v.adjacentVerticies) {
                sb.append(v2.data);
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

public class GraphTest {

    public static void main(String[] args) {
        LinkedGraph<Integer> graph = new LinkedGraph<>();
        graph.addEdge(1, 2);
        graph.addEdge(1, 5);
        graph.addEdge(2, 5);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);

        System.out.println(graph);
    }
}


// diff --color -u Graph.java GraphTest.java 