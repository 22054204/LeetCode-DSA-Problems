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
    int ans = 0;
    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return ans;
    }
    public void helper(TreeNode root){
        if(root==null) return;
        int[] count = {0};
        int avg = solve(root, count)/count[0];
        if(avg==root.val) ans++;
        helper(root.left);
        helper(root.right);
    }
    public int solve(TreeNode root, int[] count){
        if(root==null) return 0;
        count[0]++;
        return root.val + solve(root.left, count) + solve(root.right, count);  
    }
}