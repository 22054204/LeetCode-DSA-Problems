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
  //Map<col, Map<row, List<values>>> map = new TreeMap<>();
    Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root, 0, 0);

        for(Integer col:map.keySet()){
            List<Integer> list = new ArrayList<>();
            for(Integer row:map.get(col).keySet()){
                List<Integer> values = map.get(col).get(row);
                Collections.sort(values);
                list.addAll(values);
            }
            ans.add(list);
        }
        return ans;
    }
    private void helper(TreeNode root, int row, int col){
        if(root==null) return;

        if(!map.containsKey(col)){
            map.put(col, new TreeMap<>());  
        }
        if(!map.get(col).containsKey(row)){
            map.get(col).put(row, new ArrayList<>());
        }
        map.get(col).get(row).add(root.val);

        helper(root.left, row+1, col-1);
        helper(root.right, row+1, col+1);
    }
}