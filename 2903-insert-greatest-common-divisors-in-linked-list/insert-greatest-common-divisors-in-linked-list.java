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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return head;

        ListNode ptr1 = head;
        ListNode ptr2 = head.next;
        ListNode result = new ListNode(ptr1.val);
        ListNode ptr = result;
        while(ptr1!=null && ptr2!=null){
            int a = ptr1.val;
            int b = ptr2.val;
            ptr.next = new ListNode(gcd(a, b));
            ptr.next.next = new ListNode(b);
            ptr = ptr.next.next;
            ptr1 = ptr2;
            ptr2 = ptr2.next;
        }
        return result;
    }
    public int gcd(int a, int b){
        return b==0?a:gcd(b, a%b);
    }
}