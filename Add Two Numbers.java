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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) return (l1 == null) ? l2 : l1;
        ListNode H = new ListNode(-1);
        ListNode cur = H;
        int res = 0;
        int sum = 0;
        while(l1 != null || l2 != null){
            sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + res;
            res = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            l1 = (l1 != null) ? l1.next : l1;
            l2 = (l2 != null) ? l2.next : l2;
        }
        if(res != 0)
            cur.next = new ListNode(res);
        return H.next;
    }
}
