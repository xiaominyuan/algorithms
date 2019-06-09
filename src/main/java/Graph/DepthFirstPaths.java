package Graph;

import java.util.Stack;

public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int start; //起点

    public DepthFirstPaths(Graph graph, int start){
        marked = new boolean[graph.v()];
        edgeTo = new int[graph.v()];
        this.start = start;
        dfs(graph,start);
    }

    private void dfs(Graph graph, int v){
        marked[v] = true;
        for (int w : graph.adj(v)){
            if (!marked[w]){
                edgeTo[w] = v;
                dfs(graph,w);
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if (!hasPathTo(v)){
            return null;
        }

        Stack<Integer> stack = new Stack<Integer>();
        for (int x = v; x!=start; x=edgeTo[x]){
            stack.push(x);
        }
        stack.push(start);
        return stack;
    }
}
