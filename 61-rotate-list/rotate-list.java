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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null||k==0) return head;
        int size = 0;
        ListNode temp1 = head;
        ListNode last = null;
        while(temp1!=null){
            size++;
            last = temp1;
            temp1 = temp1.next;
        }
        k = k%size;
        if(k == 0) return head;
        
        // Step 1: reverse whole list
        head = helper(head);

        // Step 2: reverse first k nodes
        ListNode firstHead = head;
        ListNode temp = head;
        for(int i = 1; i < k; i++){
            temp = temp.next;
        }
        ListNode secondHead = temp.next;
        temp.next = null;
        firstHead = helper(firstHead);
        secondHead = helper(secondHead);

        // Step 3: connect both parts
        ListNode curr = firstHead;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = secondHead;

        return firstHead;
    }
    public static ListNode helper(ListNode head){
        ListNode dummy = null;
        ListNode prev = dummy;
        ListNode curr = head;
        while(curr!=null){
            ListNode Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }
        return prev;
    }
}