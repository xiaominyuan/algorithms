package Graph;

public class CC {
    private boolean[] marked;
    private int[] id;
    private int count;

    public CC(Graph graph){
        marked = new boolean[graph.v()];
        id = new int[graph.v()];
        for (int s = 0; s<graph.v(); s++){
            if (!marked[s]){
                dfs(graph,s);
                count++;
            }
        }
    }

    private void dfs(Graph graph, int v){
        marked[v] = true;
        id[v] = count;
        for (int w : graph.adj(v)){
            if (!marked[w]){
                dfs(graph,w);
            }
        }
    }

    public boolean connected(int w, int v){
        return id[w] == id[v];
    }

    public int id(int v){
        return id[v];
    }

    public int count(){
        return count;
    }

}
