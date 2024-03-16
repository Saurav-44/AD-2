import java.util.ArrayList;
import java.util.Collections;

public class KruskalAlgo {

   static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

        public int compareTo(Edge e) {
            return this.wt - e.wt;
        }
    }

   static void createGraph(ArrayList<Edge> e) {
        e.add(new Edge(0, 1, 10));
        e.add(new Edge(0, 3, 30));
        e.add(new Edge(0, 2, 15));
        e.add(new Edge(1, 3, 40));
        e.add(new Edge(2, 3, 50));
    }

   static int n = 4;
   static int par[] = new int[n];
   static int rank[] = new int[n];

    static void initialize() {
        for(int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    public static int findSet(int x) {
        if(par[x] == x) {
            return x;
        }
        return par[x] = findSet(par[x]);
    }

    public static void union(int a, int b) {
        int parA = findSet(a);
        int parB = findSet(b);

        if(rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        }
        
        else if(rank[parA] < rank[parB]) {
            par[parA] = parB;

        }
        else {
            par[parB] = parA;
        }
    }

    public static void kruskal(ArrayList<Edge> edg, int V) {
        initialize();
        Collections.sort(edg);
        int mstCost = 0;
        int count  = 0;

        for(int i = 0; i < edg.size(); i++) {
            Edge e = edg.get(i);

            int parA = findSet(e.src);
            int parB = findSet(e.dest);

            if(parA != parB) {
                union(e.src, e.dest);
                mstCost = mstCost + e.wt;
                count++;
            }
        }

        System.out.println(mstCost );
    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> e = new ArrayList<>();
        createGraph(e);
        kruskal(e,V);
    }
}


