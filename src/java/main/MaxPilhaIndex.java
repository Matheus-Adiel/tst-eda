import java.util.Scanner;

public class MaxPilhaIndex {
    
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        int limit = Integer.parseInt(sc.nextLine());

        Stack stack = new Stack(line.length);
        for (int i = 0; i < line.length; i++)
            stack.push(Integer.parseInt(line[i]));

        Stack stackAux = new Stack(limit + 1);
        int maior = stack.pop();
        stackAux.push(maior);
        for (int i = 1; i <= limit; i++) {
            if (stack.peek() > maior)
                maior = stack.peek();
            stackAux.push(stack.pop());
        }

        for (int i = 1; i <= limit; i++)
            stack.push(stackAux.pop());
            
        System.out.println(maior);

    }

}


public class Stack {

    int[] stack;
    int top;

    public Stack (int capacity) {
        stack = new int[capacity];
        top = -1;
    }

    public void push (int value){
        if (!this.isFull())
            this.stack[++top] = value;
    }

    public int pop (){
        if (!this.isEmpty())
            return this.stack[top--];
        return -1;
    }

    public boolean isFull(){
        return top == this.stack.length - 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public int peek(){
        if (!this.isEmpty())
            return stack[top];
        return -1;
    }

}
