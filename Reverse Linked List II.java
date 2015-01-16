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
    public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || m == n)
			return head;

		ListNode fakeHead = new ListNode(-1);
		fakeHead.next = head;
		ListNode H = fakeHead;
		int count = 0;
		// find start node m
		while (H.next != null && count + 1 < m) {
			H = H.next;
			count++;
		}

		if (count + 1< m)
			return head;
		
		ListNode pre = H;
		H = H.next;
		ListNode nNode = pre.next;
		count++;
		// keep track of pre nodes and post nodes
		while (H != null && count <= n) {
			ListNode tmp = H.next;
			H.next = pre.next;
			pre.next = H;
			nNode.next = tmp;
			H = tmp;
			count++;
		}
		return fakeHead.next;
	}
}
