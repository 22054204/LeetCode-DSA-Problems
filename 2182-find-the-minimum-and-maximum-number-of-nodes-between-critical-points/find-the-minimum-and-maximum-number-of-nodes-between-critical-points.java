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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] result = new int[2];
        if(head.next.next==null){
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        ListNode prev = head;
        ListNode curr = prev.next;
        ListNode after = curr.next;
        int i=2;
        List<Integer> list = new ArrayList<>();
        while(after!=null){
            // local minima
            if(curr.val<prev.val && curr.val<after.val){
                list.add(i);
            }
            //local maxima
            else if(curr.val>prev.val && curr.val>after.val){
                list.add(i);
            }
            i++;
            prev = curr;
            curr = after;
            after = after.next;
        }
        if(list.size()<=1){
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        int minDistance = Integer.MAX_VALUE;
        int maxDistance = Integer.MIN_VALUE;
        for(i=1;i<list.size();i++){
            minDistance = Math.min(minDistance, list.get(i)-list.get(i-1));
        }
        result[0] = minDistance;
        result[1] = list.get(list.size()-1)-list.get(0);

        // System.out.println(list);
        // System.out.println(Arrays.toString(result));
        
        return result;
    }
}