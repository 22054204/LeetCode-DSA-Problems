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
    public List<Integer> preorderTraversal(TreeNode root) {
        // preorder = NLR -> Node Left Right
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        while(root!=null || !st.isEmpty()){
            while(root!=null){
                result.add(root.val);
                st.push(root);  
                root = root.left;
            }
            TreeNode node = st.pop();
            root = node.right;
        }
        return result;  
    }
}