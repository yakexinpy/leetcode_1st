/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = head;
        
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        
        //reverse the second half
        ListNode fake = new ListNode(-1);
        fake.next = slow;
        slow = slow.next;
        ListNode last = fake.next;
        while(slow != null){
            ListNode tmp = slow.next;
            slow.next = fake.next;
            fake.next = slow;
            slow = tmp;
            last.next = tmp;
        }
        
        fast = head;
        slow = fake.next;
        ListNode node = fake;
        while(fast != null && slow != null){
            node.next = fast;
            fast = fast.next;
            node = node.next;
            
            node.next = slow;
            slow = slow.next;
            node = node.next;
        }
        if(fast != null)
            node.next = fast;
        if(slow != null)
            node.next = slow;
        
        
        return;
    }
}
