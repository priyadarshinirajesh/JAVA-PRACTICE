class ListNode {
    int element;
    ListNode next;

    public ListNode(int e) {
        element = e;
        next = null;
    }
}

class linkedlist {
    int size;
    ListNode head;

    public linkedlist() {
        size = 0;
        head = null;
        System.out.println("linked list initialized");
    }

    public void insertfront(int e) {
        ListNode newNode = new ListNode(e);

        if(size == 0) {
            head = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
        size += 1;
        System.out.println(e+" inserted in linked list");
    }

    public void insertend(int e) {
        ListNode newNode = new ListNode(e);

        if (size == 0) {
            head = newNode;
        }
        else {
            ListNode c = head;
            while (c.next != null) {
                c = c.next;
            }
            c.next = newNode;
        }
        size += 1;
        System.out.println(e+" inserted in linked list");
    }

    public void deletefront() {
        if (size == 0) {
            System.out.println("linked list is empty");
        }
        else {
            int e = head.element;
            head = head.next;
            size -= 1;
            System.out.println(e+" deletred from the linked list");
        }
    }

    public void deleteend() {
        if (size == 0) {
            System.out.println("linked list is empty");
        }
        else if (size == 1) {
            int e = head.element;
            head = null;
            size -= 1;
            System.out.println(e+" deleted from the linked list");
        }
        else {
            ListNode c = head;

            while(c.next.next != null) {
                c = c.next;
            }

            int e = c.next.element;
            c.next = null;
            size -=1;
            System.out.println(e+" deleted from the linked list");
        }
    }

    public void printlist() {
        if (size == 0) {
            System.out.println("linked list is empty");
        }
        else {
            ListNode c = head;
            for(int i=0;i<size;i++) {
                System.out.print(c.element+" ");
                c = c.next;
            }
            System.out.println();
        }
    }
}

public class linkedlistimplement {
    public static void main(String args[]) {
        linkedlist l = new linkedlist();
        l.insertfront(1);
        l.insertfront(2);
        l.insertend(3);
        l.insertend(4);
        l.insertend(5);
        l.printlist();
        l.deletefront();
        l.deleteend();
        l.deleteend();
        l.deletefront();
        l.deletefront();
        l.deleteend();

    }
}