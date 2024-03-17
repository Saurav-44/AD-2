import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraAlgo {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    static class Pair implements Comparable<Pair> {
        int n;
        int path;

        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p) {
            return this.path - p.path; // sorted by path on the basis of increasing
        }
    }

    static void dijkstra(ArrayList<Edge> graph[], int src) {
        int dis[] = new int[graph.length]; // dist[i] -> src to i
        for (int i = 0; i < graph.length; i++) {
            if (src != i) { // if src == i no need to do anything
                dis[i] = Integer.MAX_VALUE;
            }
        }

        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            if (!vis[curr.n]) {
                vis[curr.n] = true;

                // neighbour
                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);

                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if (dis[u] != Integer.MAX_VALUE && dis[u] + wt < dis[v]) { // update distance from src to v
                        dis[v] = dis[u] + wt;
                        pq.add(new Pair(v, dis[v])); // add updated distance to priority queue
                    }
                }
            }
        }

        for (int i = 0; i < dis.length; i++) { //printing shortest path from src to v
            System.out.print(dis[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> gr[] = new ArrayList[V];
        createGraph(gr);
        dijkstra(gr, 0); 
    }
}

// Tc = O(v+E(logv))