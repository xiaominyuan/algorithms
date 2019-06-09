package Graph;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int start;

    public BreadthFirstPaths(Graph graph, int start){
        marked = new boolean[graph.v()];
        edgeTo = new int[graph.v()];
        this.start = start;
        bfs(graph, start);
    }

    private void bfs(Graph graph, int v){
        Queue<Integer> queue = new PriorityQueue<>();
        marked[start] = true;
        queue.add(start);
        while (!queue.isEmpty()){
            int v = queue.poll();
            for (int w : graph.adj(v)){
                if (!marked[w]){
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.add(w);
                }
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
        Stack<Integer> stack = new Stack<>();
        for (int x=v; x!= start; x=edgeTo[x]){
            stack.push(x);
        }
        stack.push(start);
        return stack;
    }
}
