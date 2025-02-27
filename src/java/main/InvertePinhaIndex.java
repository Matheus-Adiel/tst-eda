import java.util.Scanner;

public class InvertePilhaIndex {

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int capacity = Integer.parseInt(sc.nextLine());
       String[] line = sc.nextLine().split(" ");
        Stack stack = new Stack(capacity);
        
        for (int i = 0; i < line.length; i++)
            stack.push(Integer.parseInt(line[i]));
        
        int index = sc.nextInt();
        System.out.println("-");
        
        Stack stackAux = new Stack(index + 1);
        for (int i = 0; i < index + 1; i++)
            stackAux.push(stack.pop());
        while (!stackAux.isEmpty())
            System.out.println(stackAux.pop());
        while (!stack.isEmpty())
            System.out.println(stack.pop());
    }

}

public class Stack {

    private int[] stack;
    private int top;

    public Stack (int capacity){
        this.stack = new int[capacity];
        this.top = -1;
    }

    public void push (int value){
        this.stack[++top] = value;
    }

    public int pop (){
        return this.stack[top--];
    }

    public boolean isEmpty(){
        return this.top == -1;
    }

}

