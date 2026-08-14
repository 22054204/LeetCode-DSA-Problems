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
        //return bfs(root);
        // return iterativeDFS(root);
        return recursiveDFS(root, root);
    }
    private boolean iterativeDFS(TreeNode root) {
        if(root==null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode root1 = stack.pop();
            TreeNode root2 = stack.pop();
            if(root1==null&&root2==null) continue;
            if(root1==null||root2==null) return false;
            if(root1.val!=root2.val) return false;
            stack.push(root1.left);
            stack.push(root2.right);
            stack.push(root1.right);
            stack.push(root2.left);
        }
        return true;
    }
    private boolean recursiveDFS(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null) return false;
        if(root1.val!=root2.val)  return false;
        return recursiveDFS(root1.left, root2.right) && recursiveDFS(root1.right, root2.left);
    }
    private boolean bfs(TreeNode root) {
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


