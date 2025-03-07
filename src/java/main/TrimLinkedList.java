import java.util.Scanner;

public class TrimLinkedList {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] tokens = sc.nextLine().split(" ");
        int qtd = sc.nextInt();
        LinkedList ll = new LinkedList();
        for (int i = 0; i < tokens.length; i++)
            ll.addLast(Integer.parseInt(tokens[i]));
        trim(ll, qtd);
        System.out.println(ll.toString());
    }

    public static void trim(LinkedList ll, int qtd){
        for (int i = 0; i < qtd; i++){
            try {
                ll.removeFirst();
                ll.removeLast();
            } catch (IndexOutOfBoundsException e){
                break;
            }
        }
    }

}

class LinkedList {

    private Node head;
    private Node tail;
    private int size;

    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addLast(int value){
        if (this.isEmpty()){
            this.head = new Node(value);
            this.tail = this.head;
        } else {
            this.tail.next = new Node(value);
            this.tail.next.prev = this.tail;
            this.tail = this.tail.next;
        }
        this.size++;
    }

    public int removeFirst(){
        if (this.isEmpty())
            throw new IndexOutOfBoundsException("vazia já");
        int value = this.getFirst();
        if (this.head.next == null){
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.prev = null;
        }
        this.size--;
        return value;
    }

    public int removeLast(){
        if (this.isEmpty())
            throw new IndexOutOfBoundsException("vazia já");
        int value = this.getLast();
        if (this.head == this.tail)
            return this.removeFirst();
        else {
            this.tail = this.tail.prev;
            this.tail.next = null;
            this.size--;
        }
        return value;
    }

    public int getFirst() {
        if (this.isEmpty())
            throw new IndexOutOfBoundsException("tá vazia");
        return this.head.value;
    }

    public int getLast() {
        if (this.isEmpty())
            throw new IndexOutOfBoundsException("tá vazia");
        return this.tail.value;
    }

    public String toString() {
        if(this.isEmpty())
            return "vazia";
        String out = "";
        Node aux = this.head;
        while (aux.next != null){
            out += String.format("%d ", aux.value);
            aux = aux.next;
        }
        out += aux.value;
        return out;
    }

}

class Node {

    int value;
    Node prev;
    Node next;

    public Node (int value){
        this.value = value;
        this.prev = null;
        this.next = null;
    }

}
