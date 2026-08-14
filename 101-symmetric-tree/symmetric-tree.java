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
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(root);
        q2.offer(root);
        
        while(!q1.isEmpty()&&!q2.isEmpty()){
            TreeNode root1 = q1.poll();
            TreeNode root2 = q2.poll();
            if(root1==null&&root2==null) continue;
            if(root1==null||root2==null) return false;
            if(root1.val!=root2.val) return false;
            q1.offer(root1.left);
            q1.offer(root1.right);
            
            q2.offer(root2.right);
            q2.offer(root2.left);
        }
        
        return true;
    }
}