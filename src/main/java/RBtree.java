

//https://www.cnblogs.com/skywang12345/p/3624343.html
public class RBtree<T extends Comparable<T>> {

    private RBNode<T> root;

    private final boolean RED = false;
    private final boolean BLACK = true;

    private void leftRotate(RBNode<T> x){
        RBNode<T> y = x.right;
        x.right = y.left;
        if (y.left != null){
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null){
            this.root = y;
        }else {
            if (x.parent.left == x){
                x.parent.left = y;
            }else {
                x.parent.right = y;
            }
        }

        y.left = x;
        x.parent = y;
    }

    private void rightRotate(RBNode<T> y){
        RBNode<T> x = y.left;

        y.left = x.right;
        if (x.right != null){
            x.right.parent = y;
        }

        x.parent = y.parent;

        if (y.parent == null){
            this.root = x;
        }else {
            if (y == y.right){
                y.parent.right = x;
            }else {
                y.parent.left = x;
            }
        }
        x.right = y;
        y.parent = x;
    }

    private void insert(RBNode<T> node){
        int cmp;
        RBNode<T> y = null;
        RBNode<T> x = this.root;

        while (x != null){
            y =x;
            cmp = node.key.compareTo(x.key);
            if (cmp < 0){
                x = x.left;
            }else {
                x = x.right;
            }
        }

        node.parent = y;

        if (y != null){
            cmp = node.key.compareTo(y.key);
            if (cmp < 0){
                y.left = node;
            }else {
                y.right = node;
            }
        }

        node.color =  RED;

    }

    public void insert(T key){
        RBNode<T> node = new RBNode<T>( BLACK,key, null, null,null);
        if (node != null){
            insert(node);
        }
    }

    public void insertFixUp(RBNode<T> node){
        RBNode<T> parent;
        RBNode<T> grandParent;
// 若“父节点存在，并且父节点的颜色是红色”
        while ((parent = parentOf(node))!=null && (isRED(parent)) ){
            grandParent = parentOf(parent);
            //若“父节点”是“祖父节点的左孩子”
            if (parent == grandParent.left){
                // Case 1条件：叔叔节点是红色
                RBNode<T> uncle = grandParent.right;
                if ((uncle != null) && isRED(uncle)){
                    setBLACK(uncle);
                    setBLACK(parent);
                    setRED(grandParent);
                    node = grandParent;
                    continue;
                }
                // Case 2条件：叔叔是黑色，且当前节点是右孩子
                if (parent.right == node){
                    RBNode<T> tmp;
                    leftRotate(parent);
                    tmp = parent;
                    parent = node;
                    node = tmp;
                }
                // Case 3条件：叔叔是黑色，且当前节点是左孩子。
                setBLACK(parent);
                setRED(grandParent);
                rightRotate(grandParent);
            }else {//若“z的父节点”是“z的祖父节点的右孩子”
                // Case 1条件：叔叔节点是红色
                RBNode<T> uncle = grandParent.left;
                if ((uncle != null) && (isRED(uncle))){
                    setBLACK(uncle);
                    setBLACK(parent);
                    setRED(grandParent);
                    node = grandParent;
                    continue;
                }
// Case 2条件：叔叔是黑色，且当前节点是左孩子
                if (parent.left == node){
                    RBNode<T> tmp;
                    rightRotate(parent);
                    tmp = parent;
                    parent = node;
                    node = tmp;
                }
// Case 3条件：叔叔是黑色，且当前节点是右孩子。
                setBLACK(parent);
                setRED(grandParent);
                leftRotate(grandParent);
            }
        }

        setBLACK(this.root);

    }



    public class RBNode<T extends Comparable<T>>{
        boolean color;
        T key;  //键值
        RBNode<T> left;
        RBNode<T> right;
        RBNode<T> parent;

        public RBNode(boolean color, T key, RBNode<T> left, RBNode<T> right, RBNode<T> parent) {
            this.color = color;
            this.key = key;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        public T getKey(){
            return this.key;
        }

        public String toString(){
            return ""+key+(this.color == RED ? "R":"B");
        }
    }

    private RBNode<T> parentOf(RBNode<T> node){
        if (node != null){
            return node.parent;
        }else {
            return null;
        }
    }

    private boolean colorOf(RBNode<T> node){
        if (node != null){
            return node.color;
        }else {
            return BLACK;
        }
    }

    private boolean isRED(RBNode<T> node){
        if ((node != null) && (node.color==RED)){
            return true;
        }else {
            return false;
        }
    }

    private boolean isBLACK(RBNode<T> node){
        return !isRED(node);
    }

    private void setRED(RBNode<T> node){
        if (node != null){
            node.color = RED;
        }
    }

    private void setBLACK(RBNode<T> node){
        if (node != null){
            node.color = BLACK;
        }
    }

}

