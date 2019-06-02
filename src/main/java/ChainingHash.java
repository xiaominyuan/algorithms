public class ChainingHash<key, value> {
    int capacity;
    Node[] nodeHeadList;
    public ChainingHash(int n){
        capacity = n;
        nodeHeadList = new Node[n];
    }

    class Node<key, value>{
        key k;
        value v;
        Node<key, value> next;
        public Node(){}
        public Node(key k, value v, Node<key, value> next){
            this.k = k;
            this.v = v;
            this.next = next;
        }
    }

    int hashcode(key k){
        return (k.hashCode()&0x7ffffff)%capacity;
    }

    public void put(key k, value v){
        int h = hashcode(k);
        for(Node<key,value> n = nodeHeadList[h]; n!=null; n=n.next){
            if (k.equals(n.k)){
                n.v = v;
            }
        }
        Node<key, value> head = nodeHeadList[h];
        nodeHeadList[h] = new Node(k, v, head);
    }

    public value get(key k){
        int h = hashcode(k);
        if (nodeHeadList[h] == null){
            return null;
        }

        for (Node<key, value> node = nodeHeadList[h]; node != null; node = node.next){
            if (k.equals(node.k)){
                return node.v;
            }
        }
        return null;
    }
}
