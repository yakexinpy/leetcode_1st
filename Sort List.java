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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode right = head;
        ListNode left = head;
        while(left.next != null && left.next.next != null){
            right = right.next;
            left = left.next.next;
        }
        
        left = head;
        ListNode tmp = right;
        right = right.next;
        tmp.next = null;
        
        ListNode leftHalf = null, rightHalf = null;
        if(left != right){
            leftHalf = sortList(left);
            rightHalf = sortList(right);
        }
        return merge2List(leftHalf, rightHalf);
    }
    
    private ListNode merge2List(ListNode node1, ListNode node2){
        ListNode H = new ListNode(-1);
        ListNode h = H;
        
        while(node1 != null && node2 !=null){
            if(node1.val < node2.val){
                h.next = node1;
                node1 = node1.next;
            }
            else{
                h.next = node2;
                node2 = node2.next;
            }
            h = h.next;
        }
        if(node1 != null)
            h.next = node1;
        if(node2 != null)
            h.next = node2;
        
        return H.next;
    }
}
