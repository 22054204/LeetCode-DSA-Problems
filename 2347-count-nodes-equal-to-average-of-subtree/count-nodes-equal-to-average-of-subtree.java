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
    int count = 0;
    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return ans;
    }
    public void helper(TreeNode root){
        if(root==null) return;
        count = 0;
        int sum = solve(root);
        int avg = sum/count;
        if(avg==root.val) ans++;
        helper(root.left);
        helper(root.right);
    }
    public int solve(TreeNode root){
        if(root==null) return 0;
        count++;
        return root.val + solve(root.left) + solve(root.right);  
    }
}