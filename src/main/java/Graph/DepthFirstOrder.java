package Graph;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversePost;

    public DepthFirstOrder(Digraph digraph){
        pre = new PriorityQueue<>();
        post = new PriorityQueue<>();
        reversePost = new Stack<>();
        marked = new boolean[digraph.v()];

        for (int v = 0; v<digraph.v(); v++){
            if (!marked[v]){
                dfs(digraph,v);
            }
        }
    }

    public void dfs(Digraph digraph, int v){
        pre.add(v);

        for (int w : digraph.adj(v)){
            if (!marked[w]){
                dfs(digraph,w);
            }
        }

        post.add(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre(){
        return pre;
    }
    public Iterable<Integer> post(){
        return post;
    }
    public Iterable<Integer> reversePost(){
        return reversePost;
    }
}
