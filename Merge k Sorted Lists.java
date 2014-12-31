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
    public ListNode mergeKLists(List<ListNode> lists) {
        int size = lists.size();
        if(size == 0) return null;
        if(size == 1) return lists.get(0);
        
        while(size > 1){
            for(int i = 0; i < size / 2; i++){
                lists.set(i, merge2Lists(lists.get(i), lists.get(size - 1 - i)));
            }
            if(size % 2 != 0)
                lists.set(0, merge2Lists(lists.get(0), lists.get(size/2)));
            size  = size >> 1;
        }
        return lists.get(0);
    }
    
    private ListNode merge2Lists(ListNode l1, ListNode l2){
        ListNode root = new ListNode(-1);
        ListNode H = root;
        
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                H.next = l1;
                l1 = l1.next;
            }
            else{
                H.next = l2;
                l2 = l2.next;
            }
            H = H.next;
        }
        if(l1 != null)
            H.next = l1;
        if(l2 != null)
            H.next = l2;
        return root.next;
    }
}
