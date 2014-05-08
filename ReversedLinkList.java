package Leetcode;

public class ReversedLinkList {
	public static void main(String[] args) {
		ReversedLinkList t = new ReversedLinkList();
		ListNode head = t.new ListNode(3);
		head.next = t.new ListNode(5);
		t.reverseBetween(head, 1, 2);
	}
	
	
	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	         next = null;
	      }
}
	
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;
        
        // special case:m=1,then it reverse from head... how about create a fake head
    	ListNode fakeHead = new ListNode(-1);
    	
    	fakeHead.next = head;
        
        ListNode right = head;
		for (int i=0; i< n-m+1; i++) { // move n to reach n+1 th Node
			right = right.next;
        }
        ListNode left = fakeHead;
        for (int i=0; i<m-1; i++) { // move m-1 to reach Node before m from fakeHead
        	left = left.next;
        	right = right.next;
        }
        // left.next is m, right.prev is n
        // Update: failed when n == m, loop
        // how about judge in the beginning? 
        ListNode p = left.next;
        for (int i=0; i< n - m + 1; i++) { // n-m+1 Node -> n-m+1 movement
        	ListNode next = p.next;
        	p.next = right;
        	right = p;
        	p = next;
        }
        left.next = right;
        return fakeHead.next;
    }
}
