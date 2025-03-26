import java.util.Scanner;
import java.util.ArrayList;

public class PredecessorBST {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BST bst = new BST();
        String[] line = sc.nextLine().split(" ");
        for (String element : line)
            bst.add(Integer.parseInt(element));
        int value = sc.nextInt(); 
        System.out.println(bst.caminhoPredecessor(value));
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
        if (node.left != null)
            return max(node.left);
        Node aux = node.parent;
        while (aux != null && aux.value > value)
            aux = aux.parent;
        return aux.value;
    }

    //método apenas para a resolução da questão
    public ArrayList caminhoPredecessor (int value) {
        ArrayList path = new ArrayList<Integer>();
        Node node = this.search(value);
        path.add(value);
        if (node.left != null){
            node = node.left;
            path.add(node.value);
            while (node.right != null){
                node = node.right;
                path.add(node.value);
            }
            return path;
        }
        node = node.parent;
        while (node != null){
            path.add(node.value);
            if (node.value < value)
                break;
            node = node.parent;
        }
        return path;
    }
    
    public Node search(int value){
        Node aux = this.root;
        while (aux != null){
            if (value == aux.value)
                return aux;
            else if (value > aux.value)
                aux = aux.right;
            else
                aux = aux.left;
        }
        return null;
    }

    public int max(Node node){
        if (node.right == null)
            return node.value;
        return max(node.right);
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
