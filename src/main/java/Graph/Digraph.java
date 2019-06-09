package Graph;

public class Digraph {
    private int v;
    private int e;
    private Bag<Integer>[] adj;

    public Digraph(int v){
        this.v = v;
        this.e = 0;
        adj = (Bag<Integer>[]) new Bag[v];

        for (int i = 0; i<v; i++){
            adj[i] = new Bag<Integer>();
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
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public Digraph reverse(){
        Digraph reverse = new Digraph(v);
        for (int i = 0; i<v; i++){
            for (int w: adj[i]){
                reverse.addEdge(w,i);
            }
        }
        return reverse;
    }
}
