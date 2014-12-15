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
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null)
            return null;
        if(n == 0)
            return head;
        ListNode node = head;
        int size = 1;
        while(node.next != null){
            node = node.next;
            size++;
        }
        n = n % size;
        
        ListNode p1 = head;
        int rest = 1;
        while(rest + n < size){
            p1 = p1.next;
            rest ++;
        }
        
        node.next = head;
        head = p1.next;
        p1.next = null;
        
        return head;
    }
}
