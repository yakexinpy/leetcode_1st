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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode H = fakeHead;
        
        
        ListNode start = null, end = null;
        while(H.next != null){
            start = H.next;
            end = start.next;
            
            while(end != null && end.val == start.val)
                end = end.next;
            
            if(start.next != end) 
                H.next = end;
            else H = H.next;
        }
        return fakeHead.next;
    }
}
