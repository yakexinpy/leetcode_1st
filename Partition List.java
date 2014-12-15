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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null)
            return head;
        ListNode H = new ListNode(0);
        H.next = head;
        
        head = H;
        ListNode pre = head;
        
        while(pre.next != null){
            ListNode curr = pre.next;
            if(curr.val < x){
               if(pre == head)
                    pre = pre.next;
                else{
                    pre.next = curr.next;
                    curr.next = head.next;
                    head.next = curr;
                }
                head = head.next;
            }
            else{
                pre = pre.next;
            }
        }
        return H.next;
    }
}
