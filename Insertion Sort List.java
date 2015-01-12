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
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return null;
        ListNode H = new ListNode(Integer.MIN_VALUE);
        H.next = head;
        
        ListNode node = H;
        while(node.next != null){
            ListNode pos = helper(H, node.next);
            if(node.next == pos.next)
                node = node.next;
            else{
                ListNode temp = node.next.next;
                node.next.next = pos.next;
                pos.next = node.next;
                node.next = temp;
            }
        }
        return H.next;
    }
    
    private ListNode helper(ListNode start, ListNode end){
        ListNode ret = null;
        while(start != null && start != end & start.val <= end.val){
            ret = start;
            start = start.next;
        }
        return ret;
    }
}
