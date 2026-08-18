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
    int count = 0;
    public int countDominantNodes(TreeNode root) {
        helper(root);
        return count;
    }
    public int helper(TreeNode root){
        if(root==null) return 0;
        if(isLeaf(root)){
            count++;
            return root.val;
        }
        int leftMax =  helper(root.left);
        int rightMax = helper(root.right);
        int maxDesc = Math.max(leftMax, rightMax);
        if(root.val >= maxDesc) {
            count++;
        }
        return Math.max(root.val, maxDesc);
    }
    public static boolean isLeaf(TreeNode root){
        if(root.left==null && root.right==null) return true;
        return false;
    }

}