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
        if (head == null || head.next == null || k == 0) return head;
       ArrayList<Integer> list = new ArrayList<>();
       ListNode temp = head;
       while(temp!=null){
        list.add(temp.val);
        temp = temp.next;
       }
        int n = list.size();
        k = k%n;
        if(k == 0) return head;

        rotate(list, 0, n-1);
        rotate(list, 0, k-1);
        rotate(list, k, n-1);

        temp = head;
        int i = 0;
        while(temp!=null){
            temp.val = list.get(i);
            i++;    
            temp = temp.next;
        }
       return head;
    }
    void rotate(ArrayList<Integer> list, int i, int j){
        while(i<j){
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
        i++;
        j--;
        }
    }
}