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

    public TreeNode2 insert(TreeNode2 root, TreeNode2 x){
        if (root == null){
            root = x;
        }

        TreeNode2 p = null;

        while (root != null){
            p = root;
            if (x.value <root.value){
                root = root.left;
            }else {
                root = root.right;
            }
        }

        x.parent = p;
        if (x.value < p.value){
            p.left = x;
        }else {
            p.right = x;
        }
        return root;
    }

    public void delete(TreeNode2 root, TreeNode2 x){
        if (root == null){
            return;
        }
        TreeNode2 p = null;

        while (root != null){
            if (x.value < root.value){
                p =root;
                root = root.left;
            }else if (x.value > root.value){
                p = root;
                root = root.right;
            }else {
                if (root.left == null && root.right == null){
                    if (p == null){
                        root = null;
                    }else if (p.left == null){
                        p.left = null;
                    }else {
                        p.right = null;
                    }
                }else if(root.left != null && root.right == null){
                    if (p == null){
                        root = root.left;
                    }else {
                        if (p.left == root){
                            p.left = root.left;
                        }else if (p.right == root){
                            p.right = root.left;
                        }
                    }
                }else if (root.left == null && root.right != null){
                    if (p == null){
                        root = root.right;
                    }else {
                        if (p.left == root){
                            p.left = root.right;
                        }else if (p.right == root){
                            p.right = root.right;
                        }
                    }
                }else {
                    TreeNode2 min = root.right;
                    TreeNode2 pmin = null;
                    while (min.left != null){
                        pmin = min;
                        min = min.left;
                    }

                    int nodeTmp = min.value;
                    min.value = root.value;
                    root.value = nodeTmp;

                    if (min == pmin.left){
                        min.left = pmin.left;
                    }else if (min == pmin.right){
                        pmin.right = min.right;
                    }
                }
                break;
            }
        }
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
