package Leetcode;

import Leetcode.AddTwoNumbers.ListNode;

public class MergeTwoSortList {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode head = l1;

		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		if (l1.val > l2.val) {
			head = l2;
			p2 = p2.next;
		} else {
			p1 = p1.next;
		}
		ListNode curLast = head;
		while (p1 != null && p2 != null) {
			if (p1.val > p2.val) {
				curLast.next = p2;
				p2 = p2.next;
			} else {
				curLast.next = p1;
				p1 = p1.next;
			}
			curLast = curLast.next;
		}
		if (p1 == null) {
			curLast.next = p2;
		} else {
			curLast.next = p1;
		}
		return head;
	}
}
