import java.util.Queue;
import java.util.LinkedList;

class TreeNode {
    int element;
    TreeNode left;
    TreeNode right;

    public TreeNode(int e) {
        left = null;
        right = null;
        element = e;
    }
}

class Solution {
    TreeNode root;
    public Solution() {
        root = null;
    }

    public TreeNode buildtree(int[] nums,int i) {
        if (i>=nums.length) {
            return null;
        }
        TreeNode newnode = new TreeNode(nums[i]);
        newnode.left = this.buildtree(nums, (2*i)+1);
        newnode.right = this.buildtree(nums, (2*i)+2);

        return newnode;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        while (!q.isEmpty()) {
            TreeNode c = q.remove();
            if (c.left != null && c.right!= null) {
                int t = c.left.element;
                c.left.element = c.right.element;
                c.right.element = t;
            }
            else if (c.left!=null && c.right==null) {
                c.right = new TreeNode(c.left.element);
                c.left = null;
            }
            else if (c.right!=null && c.left==null) {
                c.left = new TreeNode(c.right.element);
                c.right = null;
            }
        }

        return root;
    }
}
public class graphimplment {
    public static void main(String args[]) {

    }
}