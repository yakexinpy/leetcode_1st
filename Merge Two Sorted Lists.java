/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
            
        ListNode result;
        if(l1.val < l2.val){
            result = l1;
            l1 = l1.next;
        }
        else{
            result = l2;
            l2 = l2.next;
        }
        
        ListNode head = new ListNode(-1);
        head.next = result;
        
        while(l1!= null && l2 != null){
            if(l1.val > l2.val){
                result.next = l2;
                l2 = l2.next;
                result = result.next;
            }
            else{
                result.next = l1;
                l1 = l1.next;
                result = result.next;
            }
        }
        if(l1 != null)
            result.next= l1;
        if(l2 != null)
            result.next = l2;
        
        return head.next;
    }
}
