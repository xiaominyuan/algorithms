import sun.reflect.generics.tree.Tree;

public class BST2 {
    public TreeNode2 getMin(TreeNode2 root){
        if (root == null){
            return null;
        }
        while (root.left != null){
            root = root.left;
        }
        return root;
    }

    public TreeNode2 getMax(TreeNode2 root){
        if (root == null){
            return null;
        }
        while (root.right != null){
            root = root.right;
        }
        return root;
    }

    public TreeNode2 preNode(TreeNode2 x){
        if (x == null){
            return null;
        }
        if (x.left != null){
            return getMax(x.left);
        }
        TreeNode2 p = x.parent;
        while (p != null && p.left == x){
            x = p;
            p = p.parent;
        }
        return p;
    }

    public TreeNode2 postNode(TreeNode2 x){
        if (x == null){
            return null;
        }
        if (x.right != null){
            return getMin(x.right);
        }

        TreeNode2 p = x.parent;
        while (p != null && p.right == x){
            x = p;
            p = p.parent;
        }
        return p;
    }

    public TreeNode2 search(TreeNode2 root, int val){
        if (root == null){
            return root;
        }

        while (root != null){
            if (val < root.value) {
                root = root.left;
            }else if (val > root.value){
                root = root.right;
            }else {
                return root;
            }
        }
        return root;
    }


}

class TreeNode2{
    int value;
    TreeNode2 parent;
    TreeNode2 left;
    TreeNode2 right;

    public TreeNode2(int value, TreeNode2 parent, TreeNode2 left, TreeNode2 right) {
        this.value = value;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
}
