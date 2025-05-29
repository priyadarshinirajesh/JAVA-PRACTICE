import java.util.Scanner;

class Queue {
    int size;
    int total;
    int front;
    int end;
    int[] queuearray;

    public Queue(int num) {
        total = num;
        size = 0;
        front = 0;
        end = -1;
        queuearray = new int[total];
        System.out.println("queue initialized");
    }

    public void enqueue(int e) {
        if (size == total) {
            System.out.println("queue overflow");
        }
        else {
            end = (end+1)%total;
            queuearray[end] = e;
            size += 1;
            System.out.println(e+" inserted in queue");
        }
    }

    public void dequeue() {
        if(size == 0) {
            System.out.println("queue underflow");
        }
        else {
            int e = queuearray[front];
            front = (front + 1)%total;
            size -= 1;
            System.out.println(e+" deleted from the queue");
        }
    }

    public void printqueue() {
        if (size == 0) {
            System.out.println("queue is empty");
        }
        else {
            int c = front;
            for(int i=0;i<size;i++) {
                System.out.print(queuearray[c]+" ");
                c = (c+1)%total;
            }
            System.out.println();
        }
    }

    public void frontelemnt() {
        if (size == 0) {
            System.out.println("queue is empty");
        }
        else {
            System.out.println(queuearray[front]);
        }
    }

    public void lastelement() {
        if (size == 0) {
            System.out.println("queue is empty");
        }
        else {
            System.out.println(queuearray[end]);
        }
    }
}

public class queueimplement {
    public static void main(String args[]) {
        Scanner obj = new Scanner(System.in);
        int num = obj.nextInt();

        Queue q = new Queue(num);

        q.enqueue(1);
        q.enqueue(1);
        q.enqueue(1);
        q.enqueue(1);
        q.enqueue(1);
        q.enqueue(1);
        q.printqueue();

        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.frontelemnt();
        q.lastelement();
    }
}