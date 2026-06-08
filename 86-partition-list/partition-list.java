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
    public ListNode partition(ListNode head, int x) {
        List<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        ListNode temp = head;
        while(temp!=null){
            list.add(temp.val);
            temp = temp.next;
        }
        result = pivotArray(list, result, x);

        ListNode ans = new ListNode(-1);
        ListNode p1 = ans;
        int idx = 0;
        while(idx<result.size()){
            p1.next = new ListNode(result.get(idx));
            p1 = p1.next;
            idx++;
        }
        return ans.next;
    }
    public List<Integer> pivotArray(List<Integer> list, List<Integer> result, int pivot) {

        for(int i=0;i<list.size();i++){
            if(list.get(i)<pivot){
                result.add(list.get(i));
            }
        }
        for(int i=0;i<list.size();i++){
            if(list.get(i)>=pivot){
                result.add(list.get(i));
            }
        }
        return result;
    }
}