package Graph;


public class DepthFirstSearch {
    private boolean[] marked;
    private int count;
    public DepthFirstSearch(Graph graph, int s){
        marked = new boolean[graph.v()];
        dfs(graph,s);
    }

    private void dfs(Graph graph, int v){
        marked[v] = true;
        count = count+1;
        for (int w : graph.adj(v)){
            if (!marked[w]){
                dfs(graph, w);
            }
        }
    }

    public boolean marked(int w){
        return marked[w];
    }
    public int count(){
        return count;
    }
}
