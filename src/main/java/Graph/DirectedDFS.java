package Graph;

public class DirectedDFS {
    private boolean[] marked;

    public DirectedDFS(Digraph graph, int start){
        marked = new boolean[graph.v()];
        dfs(graph,start);
    }

    public DirectedDFS(Digraph graph, Iterable<Integer> source){
        marked = new boolean[graph.v()];
        for (int s : source){
            if (!marked[s]){
                dfs(graph, s);
            }
        }
    }

    private void dfs(Digraph graph, int v){
        marked[v] = true;
        for (int w : graph.adj(v)){
            if (!marked[w]){
                dfs(graph,w);
            }
        }
    }


}
