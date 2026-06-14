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
        return Method2(head);
    }
    // Store linked list values in an ArrayList for O(1) index access.
    private int Method2(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null){
            list.add(temp.val);
            temp = temp.next;
        }
        return helper2(list);
    }
    private static int helper2(List<Integer> list){
        int n = list.size();
        int maxSum = 0;
        for(int i=0;i<=(n/2)-1;i++){
            maxSum = Math.max(maxSum, list.get(i)+list.get(n-1-i));
        }
        return maxSum;
    }
    //Cause TLE - because O(n*n)
    public int BruteForce(ListNode head) {
        int n = 0; // size of linked list
        ListNode temp1 = head;
        while(temp1!=null){
            n++;
            temp1 = temp1.next;
        }
        temp1 = head;
        int i=0;
        int maxSum = 0;
        while(i < n/2){
            int a = temp1.val;
            int b = helper1(head, n-1-i);
            maxSum = Math.max(maxSum, a+b);
            i++;
            temp1 = temp1.next;
        }
        return maxSum;
    }
    private static int helper1(ListNode head, int val){
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode temp = head;
        while(temp!=null){
            if(val==0){
                return temp.val;
            }
            else{
                val--;
            }
            prev = temp;
            temp = temp.next;
        }
        return prev.val;
    }
}