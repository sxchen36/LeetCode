package Leetcode;

import Leetcode.ReversedLinkList.ListNode;

public class ReverseNodeInKGroup {
	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	         next = null;
	      }
}
	
	public static void main(String[] args){
		ReverseNodeInKGroup k = new ReverseNodeInKGroup();
		ListNode head = k.new ListNode(1);
		head.next = k.new ListNode(2);
		head.next.next = k.new ListNode(3);
	}
	
		/*
		 * 1. the number of groups need to be reversed is length/k, but we don’t
		 * have length -- may get from one time scan (can it be skipped?? can we
		 * do without length?? -- probabaly not) 2. then it will be a for loop
		 * for length/k times 3. within each loop, there will be k nodes need to
		 * be reverse. 4. constant memory. so can’t use k pointers marks the
		 * beginning point…
		 * 
		 * Well how about we use a window which is two nodes larger than k and
		 * just move the window until the right edge reach the end? In this way
		 * we don’t need to get the length, and avoid to use k pointers 1. we
		 * need a fakeHead here
		 * 
		 * 还是上网找的别人的答案更靠谱啊，好简单……仔细研究一下
		 */
		
		 public ListNode reverseKGroup(ListNode head, int k) {
		        if (head == null || k == 1) return head;
		        ListNode dummy = new ListNode(0);
		        dummy.next = head;
		        ListNode cur = head;
		        int count = 0;
		        ListNode pre = dummy;
		        while (cur != null) {
		            count++;
		            if (count % k == 0) {
		                pre = reverseList(pre, cur.next);
		                cur = pre.next;
		            } else {
		                cur = cur.next;                
		            }

		        }
		        return dummy.next;
		        

			}

		    /*Reverse the nodes between head and next(both exclusive)
		      there should be at least two nodes between preHead and next
		    */
			private ListNode reverseList(ListNode pre, ListNode next) {
			    ListNode last = pre.next;
			    ListNode cur = last.next;
			    while (cur != next) {
			        last.next = cur.next;
			        cur.next = pre.next;
			        pre.next = cur;
			        cur = last.next;
			    }
			    return last;
			}
	
		
		
//    if (head == null) return head;
//        
//        ListNode cur = head;
//        ListNode preHead = null, preTail = null, curHead = head;
//        int c = 0;
//        while (cur != null) {
//            c++;
//            if(c == k){
//                reverseList(curHead, cur);// after reverse, cur will point to the head while curHead will be tail
//                if (preHead == null) preHead = cur;
//                if(preTail != null){
//                    preTail.next = cur;
//                }
//                preTail = curHead;
//                cur = curHead;
//                curHead = curHead.next;
//                c = 0;
//            }
//            cur = cur.next;
//        }
//        
//		if (preTail != null) preTail.next = curHead;
//
//		return (preTail == null) ? head : preHead;
//	}
//		
//		
//		private void reverseList(ListNode left, ListNode right) {
//		    if (left == right) return;
//		    
//			ListNode prev = null;
//			ListNode cur = left;
//			ListNode next = left.next;
//			while (cur != right) {
//			    cur.next = prev;
//			    prev = cur;
//			    cur = next;
//			    next = cur.next;
//			}
//			cur.next = prev;
//		}
		
		
//		ListNode fakeHead = new ListNode(-1);
//		fakeHead.next = head;
//		ListNode left = fakeHead;
//		ListNode right = fakeHead;
//		for (int i = 0; i < k + 1; i++) {// right should be the node after kth
//			right = right.next;
//		}
//		// right points to the k+1th
//		boolean isEnd = false;
//		while (!isEnd) {
//			for (int i = 0; i < k; i++) {
//				if (right == null) {
//					isEnd = true;
//					break;
//				}
//				left = left.next;
//				right = right.next;
//			}
//			if (!isEnd)
//				reverseList(left, right);
//		}
//		return fakeHead.next;
//
//	}
//
//	private void reverseList(ListNode left, ListNode right) {
//		if (left == right) return;
//		
//		ListNode end = right;
//		ListNode p = left.next;
//		while (p != end) {
//			ListNode next = p.next;
//			p.next = right;
//			right = p;
//			p = next;
//		}
//		left.next = right;
//	}


}
