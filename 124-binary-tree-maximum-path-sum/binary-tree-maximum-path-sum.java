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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        solve(root);
        return maxSum;
    }
    public int solve(TreeNode root){
        if(root==null) return 0;
        int left = solve(root.left);
        int right = solve(root.right);

        //case 1 
        int niche_hi_milgya_ans = left+right+root.val;

        //case 2
        int koi_ek_acha = Math.max(left, right) + root.val;

        //case 3
        int only_root_acha = root.val; 

        maxSum = Math.max(maxSum, Math.max(niche_hi_milgya_ans, Math.max(koi_ek_acha, only_root_acha)));

        return Math.max(koi_ek_acha, only_root_acha); 
    }
}