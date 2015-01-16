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
    public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k < 2)
			return head;

		ListNode fakeHead = new ListNode(-1);
		fakeHead.next = head;

		int size = 0;
		ListNode H = head;
		while (H != null) {
			H = H.next;
			size++;
		}
		
		int res = size % k;

		int count = 0, curLen = 0;
		ListNode pre = fakeHead, nextK = pre.next;
		H = head;
		while (H != null && count + res <= size) {
			if (curLen < k) {
				if (pre.next != H) {
					ListNode tmp = H.next;
					H.next = pre.next;
					pre.next = H;
					nextK.next = tmp;
					H = tmp;
				}else
					H = H.next;
			} else {
				pre = nextK;
				H = pre.next;
				nextK = pre.next;
				curLen = -1;
				count--;
			}
			curLen++;
			count++;
		}

		return fakeHead.next;
	}
}
