import java.util.Scanner;

public class OrdenaPilhaInvertendo {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int length = Integer.parseInt(sc.nextLine());
        String[] tokens = sc.nextLine().split(" ");
        Stack stack = new Stack(length);
        for (int i = 0; i < length; i++)
            stack.push(Integer.parseInt(tokens[i]));
        for (int i = 0; i < length; i++){
            stack.inverte(stack.getIndexMax(length - 1 - i));
            stack.inverte(length - 1 - i);
        }
        System.out.println("-");
        while (!stack.isEmpty())
            System.out.println(stack.pop());
    }

}

class Stack{
    
    private int[] stack;
    private int top;

    public Stack(int capacity){
        this.stack = new int[capacity];
        this.top = -1;
    }

    public boolean isEmpty(){
        return this.top == -1;
    }

    public boolean isFull(){
        return this.top == this.stack.length - 1;
    }

    public void push(int value){
        if (!this.isFull())
            this.stack[++this.top] = value;
    }

    public int pop(){
        if (!this.isEmpty())
            return this.stack[this.top--];
        throw new IndexOutOfBoundsException("já está vazia");
    }

    public int size(){
        return top + 1;
    }

    public int get(){
        return this.stack[top];
    }

    public String toString(){
        String out = "";
        Stack auxStack = new Stack(this.size());
        while (!this.isEmpty())
            auxStack.push(this.pop());
        while (!auxStack.isEmpty()){
            out += String.format("%d", auxStack.get());
            this.push(auxStack.pop());
            if (!auxStack.isEmpty())
                out += ", ";
        }
        return out;
    }

    public int getIndexMax(int index) {
        if (this.isEmpty())
            throw new IndexOutOfBoundsException("vazia mano"); 
        if (index < 0 || index > this.size() - 1)
            throw new IndexOutOfBoundsException("fora do range");
        Stack auxStack = new Stack(index + 1);
        int indexMaior = 0;
        int maior = this.pop();
        auxStack.push(maior);
        for (int i = 1; i <= index; i++){
            if (this.get() > maior){
                maior = this.get();
                indexMaior = i;
            }
            auxStack.push(this.pop());
        }
        while (!auxStack.isEmpty())
            this.push(auxStack.pop());
        return indexMaior;
    }

    public void inverte(int index){
        if(index < 0 || index > this.size() - 1)
            throw new IndexOutOfBoundsException("fora do range");
        Stack auxStack = new Stack(index + 1);
        Stack auxStack2 = new Stack(index + 1);
        for (int i = 0; i < index + 1; i++)
            auxStack.push(this.pop());
        for (int i = 0; i < index + 1; i++)
            auxStack2.push(auxStack.pop());
        for (int i = 0; i < index + 1; i++)
            this.push(auxStack2.pop());
    }

}
