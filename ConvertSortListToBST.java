package Leetcode;
public class ConvertSortListToBST {

    /* Accept 1. Create a method by find the mid of list by +1point & +2 point
    2. devide and insert into a tree.
       devide stops when listsize = 1 or null
       Devide and merge and return root of the subtree*/
	public TreeNode sortedListToBST(ListNode head) {
		return help(head);
	}

	// return the root of the subtree
	private TreeNode help(ListNode head) {
		if (head == null)
			return null;

		if (head.next == null)
			return new TreeNode(head.val);

		ListNode p1 = head;
		ListNode p2 = head.next; // important, if p2 = head; then {1,3} p1 will
									// point to 3, wrong

		ListNode preP1 = null;
		while (p2 != null && p2.next != null) { // if p2 == null odd, p2.next ==
												// null even
			preP1 = p1;
			p1 = p1.next;
			p2 = p2.next.next;
		}
		ListNode secHead = p1.next;
		p1.next = null;
		TreeNode t = new TreeNode(p1.val);
		if (p1 != head) {
			preP1.next = null;
			t.left = help(head);
		}
		t.right = help(secHead);
		return t;
	}
	
	
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
