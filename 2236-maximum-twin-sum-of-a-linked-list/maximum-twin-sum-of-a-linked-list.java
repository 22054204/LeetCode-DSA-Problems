/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null){
            list.add(temp.val);
            temp = temp.next;
        }
        return helper(list);
    }
    private static int helper(List<Integer> list){
        int n = list.size();
        int maxSum = 0;
        for(int i=0;i<n;i++){
            int a = 0;
            int b = 0;
            if(i>=0 && i<=(n/2)-1){
                a = list.get(i);
                b = list.get(n-1-i);
            }
            maxSum = Math.max(maxSum, a+b);
        }
        return maxSum;
    }
}