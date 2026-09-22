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
    int sum = 0;
    int low;
    int high;
    public int rangeSumBST(TreeNode root, int low, int high) {
        this.low = low;
        this.high = high;
        solve(root);
        return sum;
    }
    public int solve(TreeNode root){
        if(root==null) return 0;
        if(root.val>=low && root.val<=high) sum+=root.val;
        int left = solve(root.left);
        int right = solve(root.right);
        return sum;
    }
}