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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        treeToListInOrder(p, list1);
        treeToListInOrder(q, list2);

        return list1.equals(list2);
    }

    public void treeToListInOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            list.add((int)-10e4+1);
            return;
        }
        list.add(node.val);
        treeToListInOrder(node.left, list);
        treeToListInOrder(node.right, list);
    }
}