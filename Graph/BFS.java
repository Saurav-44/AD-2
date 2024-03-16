import java.util.*;
public class BFS {
   static class Graph {
        int V;
        LinkedList<Integer> adj[];
    
        Graph(int v) {
            V= v;
            adj = new LinkedList[v];
            for(int i = 0; i < v; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        void addEgde(int v, int dest) {
            adj[v].add(dest);
        }

        void BFS(int s) {
            Queue<Integer> q = new LinkedList<>();
            boolean vis[] = new boolean[V];

            q.add(s);

            while(!q.isEmpty()) {
                int curr = q.remove();

                if(!vis[curr]) {
                    System.out.print(curr + " ");
                    vis[curr] = true;
                    for(int i = 0; i < adj[curr].size(); i++) {
                        int g = adj[curr].get(i);
                        q.add(g);
                    }
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

        g.addEgde(0, 1);
        g.addEgde(0, 2);
        g.addEgde(1, 0);
        g.addEgde(1, 3);
        g.addEgde(2, 0);
        g.addEgde(2, 4);
        g.addEgde(3, 1);
        g.addEgde(3, 4);
        g.addEgde(3, 5);
        g.addEgde(4, 2);
        g.addEgde(4, 5);
        g.addEgde(5, 3);
        g.addEgde(5, 4);
        g.addEgde(5, 6);
        g.addEgde(6, 5);
       

        int u = 0;
        int v = 6;
        boolean vis[] = new boolean[g.V];
        LinkedList<Integer> path = new LinkedList<>();
        g.printPath(u,v,vis,path);

        g.BFS(0);

    }
}
