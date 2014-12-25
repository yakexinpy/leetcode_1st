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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        
        int lenA = 0, lenB = 0;
        ListNode tempA = headA, tempB = headB;
        
        while(tempA != null){
            lenA ++;
            tempA = tempA.next;
        }
        while(tempB != null){
            lenB ++;
            tempB = tempB.next;
        }
        
        int dif = (lenA > lenB) ? (lenA - lenB) : (lenB - lenA);
        tempA = headA;
        tempB = headB;
        if(lenA > lenB){
            while(dif > 0){
                tempA = tempA.next;
                dif--;
            }
        }
        else{
            while(dif > 0){
                tempB = tempB.next;
                dif --;
            }
        }
        
        while(tempA != null && tempB != null){
            if(tempA == tempB) return tempA;
            else{
                tempA = tempA.next;
                tempB = tempB.next;
            }
        }
        return null;
    }
}
