public class PredecessorBST {

    public static void main(String[] args){
        BST bst = new BST();
        bst.add(10);
        System.out.println(bst.toString());
        bst.add(5);
        bst.add(15);
        System.out.println(bst.toString());
    }

}

class BST {

    private Node root;
    private int size;
    
    public BST (){
        root = null;
        size = 0;
    }

    public void add (int value){
        if (this.root == null)
            this.root = new Node(value);
        else 
            addRec(value, root);
    }

    private void addRec (int value, Node node){
        if (value > node.value)
            if (node.right == null){
                node.right = new Node(value);
                node.right.parent = node;
            } else
                addRec(value, node.right);
        else{
            if (node.left == null){
                node.left = new Node(value);
                node.left.parent = node;
            } else
                addRec(value, node.left);
        }
    }

    public int predecessor (int value){
        Node node = this.search(value);
        if (node == null)
            throw new IndexOutOfBoundsException("não encontrou o vértice");
        if (node.right != null)
            return max(node);
        //TODO: Lógica para pegar os sucessóres
    }

    public int max(Node node){
        if (node.right == null)
            return node.value;
        max(node.right);
    }

    public String toString(){
        preOrder(this.root);
        return "foi";
    }

    private void preOrder(Node node){
        if (node != null){ 
            System.out.println(node.value);
            preOrder(node.left);
            preOrder(node.right);
        }
    }
}

class Node {
    
    int value;
    Node left;
    Node right;
    Node parent;

    public Node (int value){
        this.value = value;
        left = null;
        right = null;
        parent = null;
    }
}
