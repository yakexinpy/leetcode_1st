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
        if(head == null)
            return null;
        ListNode node = head;
        while(head.next != null){
            if(head.val == head.next.val){
                head.next = head.next.next;
                continue;
            }
            head = head.next;
        }
        return node;
    }
}
