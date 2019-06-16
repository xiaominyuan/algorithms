package Graph;

public class EdgeWeightedGraph {
    private int V;
    private int E;
    private Bag<Edge>[] adj;

    public EdgeWeightedGraph(int v){
        this.V = v;
        this.E = 0;
        adj = (Bag<Edge>[])new Bag[v];
        for (int i =0; i<v; i++){
            adj[i] = new Bag<Edge>();
        }
    }

    public void validateVertex(int v){
        if (v < 0 || v >=V){
            throw new IllegalArgumentException("v is illegal");
        }
    }

    public EdgeWeightedGraph(In in){
        this(in.readInt());
        int E = in.readInt();
        if (E < 0){
            throw new IllegalArgumentException("number of edges must be nonnenative");
        }

        for (int i = 0; i<E ; i++){
            int v = in.readInt();
            int w = in.readInt();
            validateVertex(v);
            validateVertex(w);
            double weight = in.readDouble();
            Edge e = new Edge(v, w, weight);
            addEdge(e);
        }
    }

    public void addEdge(Edge e){
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public Iterable<Edge> adj(int v){
        return adj[v];
    }


}
