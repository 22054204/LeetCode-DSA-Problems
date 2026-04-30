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
        if(root == null) return result;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            if(root.right!=null) st.push(root.right);
            if(root.left!=null) st.push(root.left);
            TreeNode node = st.pop();
            result.add(node.val);
            root = node;
        }
        helper(result);
        return result;
    }
    public static void helper(List<Integer> result){
        Collections.reverse(result);
        Collections.reverse(result.subList(1, result.size()));
    }
}