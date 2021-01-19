// https://www.geeksforgeeks.org/union-find/
package UnionFind;

class UnionFind {
    
	// Driver Method
	public static void main (String[] args)
	{
		/* Let us create the following graph 
		0 
		| \ 
		| \ 
		1---2 */
		int V = 3, E = 3;
		Graph graph = new Graph(V, E);

		// add edge 0-1
		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;

		// add edge 1-2
		graph.edge[1].src = 1;
		graph.edge[1].dest = 2;

		// add edge 0-2
		graph.edge[2].src = 0;
		graph.edge[2].dest = 2;

		if (graph.isCycle(graph))
			System.out.println( "graph contains cycle" );
		else
			System.out.println( "graph doesn't contain cycle" );
    }
    
    private static class Graph {
        private int V, E;
        Edge[] edge;

        public Graph(int v, int e) {
            V = v;
            E = e;
            edge = new Edge[E];
            for (int i = 0; i < E; i++) {
                edge[i] = new Edge();
            }
        }
        private static class Edge {
            private int src, dest;
        }


        public boolean isCycle(Graph graph) {
            int[] parent = new int[graph.V]; // create V subsets which are disjoint sets at first!

            for (int i = 0; i < graph.V; i++) {
                parent[i] = -1;
            }

            for (int i = 0; i < graph.E; i++) {
                int u = graph.find(parent, graph.edge[i].src);
                int v = graph.find(parent, graph.edge[i].dest);

                if (u == v) return true;

                graph.union(parent, u, v); // take the union 
            }

            return false;
        }

        private int find(int[] parent, int i) {
            if (parent[i] == -1) return i;
            return find(parent, parent[i]);
        }

        // either make node u as parent of node v or vice-versa.
        private void union(int[] parent, int u, int v) {
            int uset = find(parent, u); // find parent of a
            int vset = find(parent, v); // find parent of b

            parent[uset] = vset; // parent of src is dest
        }
    }
}
/**
 * parent[0]: 1; parent[1]: 2; parent[2]: -1;
 * It means when checking whether the edge 0-2
 * has a cyle or not, we can detect a cycle 
 * since parent of 0 is 2 and parent of 2 is 2.
 */

/**
 * You can check whether an undirected graph contains
 * a cycle or not via union-find or DFS.  
 */