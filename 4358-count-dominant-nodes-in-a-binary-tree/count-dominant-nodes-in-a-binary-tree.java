/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public int countDominantNodes(TreeNode root) {
        return helper(root, 0);
    }

    public static int helper(TreeNode root, int count) {
        if(root==null) return count;

        int max = getMax(root);

        if(root.val==max) count++;

        count = helper(root.left, count);
        count = helper(root.right, count);

        return count;
    }

    public static int getMax(TreeNode root) {
        if(root==null) return 0;

        int left = getMax(root.left);
        int right = getMax(root.right);

        return Math.max(root.val, Math.max(left, right));
    }
}