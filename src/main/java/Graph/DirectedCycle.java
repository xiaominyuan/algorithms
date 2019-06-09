package Graph;

import java.util.Stack;

public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private boolean[] onStack;

    public DirectedCycle(Digraph digraph){
        onStack = new boolean[digraph.v()];
        edgeTo = new int[digraph.v()];
        marked = new boolean[digraph.v()];
        for (int v = 0; v<digraph.v(); v++){
            if (!marked[v]){
                dfs(digraph,v);
            }
        }
    }

    public void dfs(Digraph digraph, int v){
        onStack[v] = true;
        marked[v] = true;
        for (int w : digraph.adj(v)){
            if (this.hasCycle()){
                return;
            }else if (!marked[w]){
                edgeTo[w] = v;
                dfs(digraph,w);
            }else if (onStack[w]){
                cycle = new Stack<Integer>();
                for (int x=v; x != w; x=edgeTo[x]){
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle(){
        return cycle != null;
    }

    public Iterable<Integer> cycle(){
        return cycle;
    }
}
