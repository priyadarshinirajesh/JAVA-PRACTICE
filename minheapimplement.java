import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

class Node {
    int element;
    Node left;
    Node right;
    Node parent;

    public Node(int e) {
        element = e;
        left = null;
        right = null;
        parent = null;
    }
}

class minheap {
    Node root;

    

    public minheap() {
        root = null;
        System.out.println("minheap initialized");
    }
    public void heap_up(Node r) {
        while (r.parent != null && r.element<r.parent.element) {
            int t = r.element;
            r.element = r.parent.element;
            r.parent.element = t;
            r = r.parent;
        }
    }

    public void insertnode(int e) {
        Node newnode = new Node(e);
        if (root == null) {
            root = newnode;
            return;
        }
        Node lastNode = null;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node c = q.remove();
            if (c.left == null) {
                c.left = newnode;
                newnode.parent = c;
                lastNode = c.left;
                break;
            }

            if (c.right == null)  {
                c.right = newnode;
                newnode.parent = c;
                lastNode = c.right;
                break;
            }

            if (c.left != null) {
                q.add(c.left);
            }

            if (c.right != null) {
                q.add(c.right);
            }
        }

        this.heap_up(lastNode);
    }

    public void level_order() {
        if (root == null) {
            System.out.println("no minheap  formed");
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int s = q.size();
            for(int i=0;i<s;i++) {
                Node c = q.remove();
                System.out.print(c.element+" ");
                if (c.left != null) {
                    q.add(c.left);
                }
                if (c.right != null)  {
                    q.add(c.right);
                }
            }
            System.out.println();
        }
    }

    public Node findlastnode() {
        if (root == null)  {
            return null;
        }

        if (root.right == null && root.left == null) {
            return root;
        }

        Node last = null;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            Node c = q.remove();
            last = c;
            if (c.left != null)  {
                q.add(c.left);
            }

            if (c.right != null) {
                q.add(c.right);
            }
        }

        return last;
    }

    public void heap_down() {
        Node c = root;
    
        while (c != null) {
            Node smallesnode = c;

            if (c.left != null && c.left.element < smallesnode.element) {
                smallesnode = c.left;
            }

            if (c.right != null && c.right.element < smallesnode.element) {
                smallesnode = c.right;
            }

            if (smallesnode != c) {
                int t = smallesnode.element;
                smallesnode.element = c.element;
                c.element = t;
                c = smallesnode;
            }
            else {
                break;
            }
        }
    }

    public void deletenode() {
        if (root == null) {
            System.out.println("no minheap formed");
            return;
        }

        if(root.right == null && root.left == null) {
            root = null;
            return;
        }

        Node lastnode = this.findlastnode();
        int lastvalue = lastnode.element;

        root.element = lastvalue;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node c = q.remove();
            if (c.left != null && c.left.element == lastvalue) {
                c.left = null;
                break;
            }

            if (c.right != null && c.right.element == lastvalue) {
                c.right = null;
                break;
            }

            if (c.left != null) {
                q.add(c.left);
            }

            if (c.right != null) {
                q.add(c.right);
            }
        }

        this.heap_down();
    }
}

public class minheapimplement {
    public static void main(String args[]) {
        Scanner obj = new Scanner(System.in);
        System.out.println("enter the number of values: ");
        int num = obj.nextInt();

        minheap m = new minheap();

        for(int i=0;i<num;i++) {
            m.insertnode(obj.nextInt());
        }
        m.level_order();
        m.deletenode();
        System.out.println("after deletion:");
        m.level_order();

    }
}