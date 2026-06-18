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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode st = head;
        ListNode end = head;
        
        for(int i=1;i<k;i++){
            st = st.next;
        }

        // size of LinkedList
        ListNode temp = head;
        int size = 0;
        while(temp!=null){
            size++;
            temp = temp.next;
        }

        for(int i=1;i<=size-k;i++){
            end = end.next;
        }

        // swap values
        int temp1 = st.val;
        st.val = end.val;
        end.val = temp1;

        return head;
    }
}