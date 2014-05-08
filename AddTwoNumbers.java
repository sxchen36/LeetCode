package Leetcode;


public class AddTwoNumbers {
	
	 public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }
	
	public static void main(String[] args) {
		AddTwoNumbers a = new AddTwoNumbers();
 ListNode la  = new ListNode(0);
 ListNode lb  = new ListNode(0);
		a.addTwoNumbers(la,lb);
	}
    /* reverse order means: head of the List is basic unit*/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        int offset = 0;
        ListNode l1p = l1;
        ListNode l2p = l2;
        ListNode pre = l1;
        while (l1p != null) {
            if (l2p != null) {
                l1p.val = l1p.val + l2p.val + offset;
                l2p = l2p.next;
            } else {
                l1p.val = l1p.val + offset;
            }
            if (l1p.val >= 10) {
                offset = 1;
                l1p.val %= 10;
            } else {
                offset = 0;
            }
            pre = l1p;
            l1p = l1p.next;
        }
        pre.next = l2p;
        while (l2p != null){
            l2p.val = l2p.val+offset;
            if (l2p.val >= 10) {
                offset = 1;
                l2p.val %= 10;
            } else {
                offset = 0;
            }
            pre = l2p;
            l2p = l2p.next;
        }
        if (offset == 1) pre.next = new ListNode(1);
        return l1;
    }
}
