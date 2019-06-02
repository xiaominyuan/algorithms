package Graph;

public class Graph {
    private int v; //定点数目
    private int e; //边的数目
    private Bag<Integer>[] adj; //邻近表
    public Graph(int v){
        this.v = v;
        this.e = 0;
        adj = (Bag<Integer>[]) new Bag[v];
        for (int i=0; i<v; i++){
            adj[i] = new Bag<Integer>();
        }
    }

    public Graph(In in){
        this(in.readInt());
        int e = in.readInt();
        for (int i = 0 ; i<e; i++){
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v,w);
        }
    }
    public int v(){
        return v;
    }
    public int e(){
        return e;
    }
    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
        e = e+1;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }
}
