
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
class Solution {
    public int height_of_tree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int s1 = this.height_of_tree(root.left);
        int s2 = this.height_of_tree(root.right);

        return Math.max(s1,s2)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int s1 = this.diameterOfBinaryTree(root.left);
        int s2 = this.diameterOfBinaryTree(root.right);
        int s3 = this.height_of_tree(root.left)+this.height_of_tree(root.right)+1;

        return Math.max(s1,Math.max(s2,s3));
    }
}