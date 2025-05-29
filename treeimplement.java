import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int element;
    Node left;
    Node right;

    public Node(int e) {
        element = e;
        left = null;
        right = null;
    }
}

class Tree {
    Node root;

    public Tree() {
        root = null;
    }

    public Node buildtree(Integer[] arr,int i) {
        if (i>=arr.length || arr[i]==null) {
            return null;
        }

        Node newNode = new Node(arr[i]);
        newNode.left = this.buildtree(arr, (2*i)+1);
        newNode.right = this.buildtree(arr, (2*i)+2);

        return newNode;
    }

    public void level_order() {
        if (root == null) {
            System.out.println("tree not created");
        }
        else {
            System.out.println("Level order:");
            Queue<Node> q = new LinkedList<>();
            q.add(root);

            while (!q.isEmpty()) {
                Node c = q.remove();
                System.out.print(c.element+" ");

                if (c.left != null) {
                    q.add(c.left);
                }
                if (c.right != null) {
                    q.add(c.right);
                }
            }
            System.out.println();
        }
    }

    public int sum_of_nodes(Node r) {
        if (r == null) {
            return 0;
        }

        int sum1 = sum_of_nodes(r.left);
        int sum2 = sum_of_nodes(r.right);

        return sum1+sum2+r.element;
    }

    public int height_of_tree(Node r) {
        if (r == null) {
            return 0;
        }

        int s1 = height_of_tree(r.left);
        int s2 = height_of_tree(r.right);

        return Math.max(s1,s2)+1;
    }
}

public class treeimplement {
    public static void main(String args[]) {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int num = obj.nextInt();

        Integer[] arr = new Integer[num];

        for(int i=0;i<num;i++) {
            arr[i] = obj.nextInt();
        }

        Tree t = new Tree();
        t.root = t.buildtree(arr, 0);
        t.level_order();
        System.out.println("Sum of roots: "+t.sum_of_nodes(t.root));
    }
}