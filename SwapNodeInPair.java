package Leetcode;
public class SwapNodeInPair {
	/**
	 * AC. 注意： 1. 这一对pair swap完了后的最后一个node指向的是nextHead.next 2. nextHead 也许是null,
	 * 或者nextHead.next可以是null，无论哪种，此时指向nextHead
	 * 
	 * @param head
	 * @return
	 */

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}

		public ListNode swapPairs(ListNode head) {
			ListNode p = head;
			while (p != null && p.next != null) {
				ListNode nextHead = p.next.next;
				if (p == head) {
					head = p.next;
				}
				p.next.next = p;
				p = p.next;
				if (nextHead != null && nextHead.next != null) {
					p.next.next = nextHead.next;
				} else {
					p.next.next = nextHead;
				}
				p = nextHead;
			}
			return head;
		}

	}
}
