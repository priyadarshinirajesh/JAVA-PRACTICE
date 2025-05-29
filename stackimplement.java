import java.util.Scanner;

class Stack {
    int top;
    int total;
    int[] stackarray;

    public Stack(int num) {
        total = num;
        top = -1;
        stackarray = new int[total];

        System.out.println("stack initialized");
    }

    public void push(int e) {
        if (top == total - 1) {
            System.out.println("stack overflow");
        }
        else {
            top += 1;
            stackarray[top] = e;
            System.out.println(e+" inserted in the stack");
        }
    }

    public void pop() {
        if (top<0) {
            System.out.println("stack underflow");
        }
        else {
            int e = stackarray[top];
            top -= 1;
            System.out.println(e+" removed from the stack");
        }
    }

    public void printstack() {
        if (top<0) {
            System.out.println("stack is empty");
        }
        else {
            for(int i=0;i<=top;i++) {
                System.out.print(stackarray[i]+" ");
            }
            System.out.println();
        }
    }

    public void topelement() {
        if (top<0) {
            System.out.println("stack is empty");
        }
        else {
            System.out.println(stackarray[top]);
        }
    }

    public void isempty() {
        if (top<0) {
            System.out.println("stack is empty");
        }
        else {
            this.printstack();
        }
    }
}
public class stackimplement {
    public static void main(String args[]) {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter the size of the stack");
        int num = obj.nextInt();
        Stack s = new Stack(num);
        s.push(1);
        s.push(1);
        s.push(1);
        s.push(1);
        s.push(1);
        s.push(1);
        s.printstack();
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        s.push(1);
        s.push(2);
        s.topelement();

    }
}