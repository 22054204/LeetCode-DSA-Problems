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
    public List<Integer> inorderTraversal(TreeNode root) {
      // inorder = LNR -> Left Node Right
        List<Integer> list = new ArrayList<>();
        InOrder(root, list);
        return list;
    }
    private static void InOrder(TreeNode root, List<Integer> list){
        if(root == null) return;
        InOrder(root.left, list);
        list.add(root.val);
        InOrder(root.right, list);
    }
}