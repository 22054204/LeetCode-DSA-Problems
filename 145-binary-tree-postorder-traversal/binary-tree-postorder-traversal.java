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
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode lastVisited = null;
        while(root!=null || !st.isEmpty()){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            TreeNode node = st.peek();
            if(node.right != null && lastVisited != node.right){
                root = node.right;
            } else {
                result.add(node.val);
                lastVisited = st.pop();
            }
        }
        return result;
    }
}