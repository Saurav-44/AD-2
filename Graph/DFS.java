import java.util.LinkedList;

public class DFS {

    static class Graph {
        int V;
        LinkedList<Integer> adj[];

        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for(int i = 0; i < v; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        void addEdge(int v, int dest) {
            adj[v].add(dest);
        }

        void DFS(LinkedList<Integer> adj[], int curr, boolean vis[]) {
            System.out.print(curr + " ");
            vis[curr] = true;

            for(int i = 0; i < adj[curr].size(); i++) {
                Integer g = adj[curr].get(i);

                if(!vis[g]) {
                    DFS(adj, g,vis);
                }
            }
        }

        void printPath(int u, int v, boolean vis[], LinkedList<Integer> path) {
            vis[u] = true;
            path.add(u);
 
            if(u == v) {
                 for(int i = 0; i < path.size(); i++) {
                 System.out.print(path.get(i) + " ");
             }
             System.out.println();
            }
 
            for(int i = 0; i < adj[u].size(); i++) {
                 int neighbour = adj[u].get(i);
                 if(!vis[neighbour]) {
                     printPath(neighbour, v, vis, path);
                 }
            }
 
            path.removeLast();
         } 


    }
    public static void main(String[] args) {
        Graph g = new Graph(7);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 0);
        g.addEdge(1, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 4);
        g.addEdge(3, 1);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 2);
        g.addEdge(4, 5);
        g.addEdge(5, 3);
        g.addEdge(5, 4);
        g.addEdge(5, 6);
        g.addEdge(6, 5);

        int u = 0;
        int v = 6;
        boolean vis[] = new boolean[g.V];
        LinkedList<Integer> path = new LinkedList<>();
        g.printPath(u, v, vis, path);

        g.DFS(g.adj,0,new boolean[g.V]);
    }
}





