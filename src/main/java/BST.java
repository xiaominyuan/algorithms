
public class BST {

    public static TreeNode root;

    public BST(){
        this.root = null;
    }

    public TreeNode search(int key){
        TreeNode current = root;
        while (root != null && key != current.value){
            if (key < current.value){
                current = current.left;
            }else {
                current = current.right;
            }
        }

        return current;
    }

    public TreeNode insert(int key){
        TreeNode newNode = new TreeNode(key);

        TreeNode current = root;

        TreeNode parent = null;

        if (current == null){
            root = newNode;
            return root;
        }

        while (true){
            parent = current;
            if (key < current.value){
                current = current.left;
                if (current == null){
                    parent.left = newNode;
                    return newNode;
                }else {
                    current = current.right;
                    if (current == null){
                        parent.right = newNode;
                        return newNode;
                    }
                }
            }
        }
    }

    public TreeNode delete(int key){
        TreeNode parent = root;
        TreeNode current = root;
        boolean isLeftTree = false;

        while (key != current.value){
            parent = current;
            if (key < current.value){
                isLeftTree = true;
                current = current.left;
            }else {
                isLeftTree = false;
                current = current.right;
            }
        }

        if (current.left == null && current.right == null){
            if (current == root){
                root = null;
            }

            if (isLeftTree){
                parent.left = null;
            }else {
                parent.right = null;
            }
        }
        else if (current.right == null){
            if (current == root){
                root = current.left;
            }else if (isLeftTree){
                parent.left = current.left;
            }else {
                parent.right = current.right;
            }
        }
        else if (current.left != null && current.right != null){
            TreeNode successor = getDeleteSuccessor(current);
            if (current == root){
                root = successor;
            }else if (isLeftTree){
                parent.left = successor;
            }else {
                parent.right = successor;
            }
        }

        return current;
    }

    public TreeNode getDeleteSuccessor(TreeNode deleteNode){
        TreeNode successer = null;
        TreeNode parentSuccesser = null;
        TreeNode current = deleteNode.right;

        while (current != null){
            parentSuccesser = successer;
            successer = current;
            current = current.left;
        }

        if (successer != deleteNode.right){
            parentSuccesser.left = successer.right;
            successer.right = deleteNode.right;
        }
        return successer;
    }

}

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;
    public TreeNode(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

