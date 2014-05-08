package Leetcode;


public class RotateList {
	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	         next = null;
	      }
	}
	/* Anyway you have to go through the list to make the last.next = head, so O(N)
	 * when rotate, it needs to go len - n steps, n%len ensure it's positive*/
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || n == 0) return head;
        ListNode p = head;
        int len = 1;
        while (p.next != null) {
            p = p.next;
            len++;
        }
        p.next = head;
        for (int i=0; i< len - n%len; i++) {
            p = p.next;
        }
        head = p.next;
        p.next = null;
        return head;
    }
}
