import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

class Node {
    int element;
    Node parent;
    Node left;
    Node right;

    public Node(int e) {
        element = e;
        left = null;
        right = null;
        parent = null;
    }
}

class maxheap {
    Node root;

    public maxheap() {
        root = null;
        System.out.println("maxheap initialized");
    }

    public void heap_up(Node r) {
        while (r.parent != null && r.element>r.parent.element ) {
            int t = r.element;
            r.element = r.parent.element;
            r.parent.element = t;
            r = r.parent;
        }
    }

    public void insertnode(int e) {
        Node newNode = new Node(e);

        if (root == null) {
            root = newNode;
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node lastnode = null;
        while (!q.isEmpty()) {
            Node c = q.remove();
            if (c.left == null) {
                c.left = newNode;
                newNode.parent = c;
                lastnode = c.left;
                break;
            }
            if (c.right == null) {
                c.right = newNode;
                newNode.parent = c;
                lastnode = c.right;
                break;
            }
            if (c.left !=null) {
                q.add(c.left);
            }
            
            if (c.right != null)  {
                q.add(c.right);
            }
        }

        this.heap_up(lastnode);
    }

    public void level_order() {
        if (root == null) {
            System.out.println("maxheap not formed");
            return; 
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int s = q.size();
            for(int i=0;i<s;i++) {
                Node c = q.remove();
                System.out.print(c.element+" ");
                
                if (c.left != null)  {
                    q.add(c.left);
                }

                if (c.right != null) {
                    q.add(c.right);
                }
            }
            System.out.println();
        }
    }

    public Node findlastnode() {
        if (root == null) {
            System.out.println("no maxheap formed");
            return null;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node last = null;

        while(!q.isEmpty()) {
            Node c = q.remove();
            last = c;
            if (c.left != null) {
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
            Node largestNode = c;

            if (c.left!=null && c.left.element > largestNode.element) {
                largestNode = c.left;
            }
            if (c.right!=null && c.right.element > largestNode.element) {
                largestNode = c.right;
            }

            if (largestNode != c) {
                int t = largestNode.element;
                largestNode.element = c.element;
                c.element = t;
                c = largestNode;
            }
            else {
                break;
            }
        }
    }

    public void deletenode() {
        if (root == null) {
            System.out.println("no maxheap formed");
            return;
        }

        if (root.left == null && root.right == null) {
            root = null;
            return;
        }

        Node lastnode = this.findlastnode();
        int lastvalue = lastnode.element;

        root.element = lastvalue;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            Node c = q.remove();
            if (c.left != null && c.left.element == lastvalue)  {
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
public class maxheapimplement {
    public static void main(String args[]) {
        Scanner obj = new Scanner(System.in);
        maxheap m = new maxheap();

        System.out.println("enter the number of values:");
        int num = obj.nextInt();

        for(int i=0;i<num;i++) {
            m.insertnode(obj.nextInt());
        }

        m.level_order();
        m.deletenode();
        System.out.println("after deletion:");
        m.level_order();
    }
}
