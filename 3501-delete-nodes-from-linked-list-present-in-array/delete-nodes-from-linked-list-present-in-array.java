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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        ListNode result = new ListNode(-1);
        ListNode ptr = result;

        ListNode temp = head;
        while(temp!=null){
            if(!set.contains(temp.val)){
                ptr.next = new ListNode(temp.val);
                ptr = ptr.next;
            }
            temp = temp.next;
        }
        return result.next;
    }
}