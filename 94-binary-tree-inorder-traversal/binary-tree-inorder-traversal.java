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
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        while(root!=null || !st.isEmpty()){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            TreeNode node = st.pop();
            result.add(node.val);
            root = node.right;
        }
        return result;
    }
}