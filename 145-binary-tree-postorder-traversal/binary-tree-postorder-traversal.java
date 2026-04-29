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
    public List<Integer> postorderTraversal(TreeNode root) {
      // postorder = LRN -> Left Right Node
        List<Integer> list = new ArrayList<>();
        PostOrder(root, list);
        return list;
    }
    private static void PostOrder(TreeNode root, List<Integer> list){
        if(root == null) return;
        PostOrder(root.left, list);
        PostOrder(root.right, list);
        list.add(root.val);
    }
}