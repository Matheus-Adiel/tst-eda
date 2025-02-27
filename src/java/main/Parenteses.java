import java.util.Scanner;

public class Parenteses {
    
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        Stack stack = new Stack(line.length());
        boolean isValid = true;
        int i = 0;
        while (isValid && i < line.length()){
            if (line.charAt(i) == '(')
                stack.push(1);
            else {
                if (stack.isEmpty())
                    isValid = false;
                else
                    stack.pop();
            }
            i++;
        }
        System.out.println(isValid && stack.isEmpty() ? "S" : "N");
    }

}

class Stack {

    int[] stack;
    int top;

    public Stack (int capacity){
        stack = new int[capacity];
        top = -1;
    }

    public void push(int value){
        stack[++top] = value;
    }

    public int pop(){
        return stack[top--];
    }

    public boolean isEmpty(){
        return top == -1;
    }

}
