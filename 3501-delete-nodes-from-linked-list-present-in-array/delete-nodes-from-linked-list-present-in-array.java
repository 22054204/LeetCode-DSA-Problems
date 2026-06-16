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
        ListNode temp = head;
        List<Integer> list = new ArrayList<>();
        while(temp!=null){
            list.add(temp.val);
            temp = temp.next;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        List<Integer> result = new ArrayList<>();
        for (int num : list) {
            if (!set.contains(num)) {
                result.add(num);
            }
        }
        ListNode ans = new ListNode(-1);
        ListNode ptr = ans;
        int i=0;
        while(i<result.size()){
            ptr.next = new ListNode(result.get(i));
            ptr = ptr.next;
            i++;
        }
        return ans.next;
    }
}