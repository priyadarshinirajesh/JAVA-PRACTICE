import java.util.Scanner;

class Node {
    int element;
    Node next;
    Node prev;

    public Node(int e) {
        element = e;
        next = null;
        prev = null;
    }
}

class doublylinkedlist {
    int size;
    Node head;
    Node tail;

    public doublylinkedlist() {
        size = 0;
        head = null;
        tail = null;
        System.out.println("Doubly linked list initialized");
    }

    public void insertfront(int e) {
        Node newNode = new Node(e);

        if (size == 0) {
            head = tail = newNode;
        }
        else if(size == 1) {
            head = newNode;
            head.next = tail;
            tail.prev = head; 
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size += 1;
        System.out.println(e+" inserted in doubly  linked list");
    }

    public void insertendd(int e) {
        Node newNode = new Node(e);

        if(size == 0) {
            head = tail = newNode;
        }
        else if(size == 1) {
            tail = newNode;
            head.next = tail;
            tail.prev = head;
        }
        else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size += 1;
        System.out.println(e+" inserted in the doublie linked list");
    }

    public void printlist() {
        if (size == 0) {
            System.out.println("linked list is empty");
        }
        else {
            Node c = head;
            for(int i=0;i<size;i++)  {
                System.out.print(c.element+" ");
                c = c.next;
            }
            System.out.println();
        }
    }

    public void deletefront() {
        if (size == 0) {
            System.out.println("doublye linked list is empty");
        }
        else if (size == 1) {
            int e = head.element;
            head = null;
            tail = null;
            size -=1;
            System.out.println(e+" is deleted from the doubly linked list");
        }
        else {
            int e = head.element;
            head = head.next;
            size -= 1;
            System.out.println(e+" is deleted from the doubly linked list");
        }
    }

    public void deleteend() {
        if (size == 0) {
            System.out.println("linked list is empty");
        }
        else if (size == 1)  {
            int e = tail.element;
            head = null;
            tail = null;
            size -= 1;
            System.out.println(e+" is deleted from the doubly linked list");
        }
        else {
            int e = tail.element;
            tail = tail.prev;
            tail.next = null;
            size -= 1;
            System.out.println(e+" is deleted from the doubly linked list");
        }
    }
}

public class doublylinkedlistimplement {
    public static void main(String args[]) {

        doublylinkedlist l = new doublylinkedlist();
        l.insertfront(1);
        l.insertfront(2);
        l.insertendd(3);
        l.insertendd(3);
        l.insertendd(3);
        l.printlist();
        l.deletefront();
        l.deleteend();
        l.printlist();
    }
}