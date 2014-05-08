package Leetcode;

import Leetcode.AddTwoNumbers.ListNode;

public class PartitionList {
	
	public static void main(String[] args) {
		PartitionList t = new PartitionList();
		ListNode head = t.new ListNode(1);
		head.next = t.new ListNode(1);
		t.partition(head, 2);
	}
	
	 public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	
	 /*Use two pointers. One points to the last Node that smaller than x, 
	  * one points to the current Node which we check its next
	  * 
	  * Update: too much trouble. Just store a pre pointer before cur
	  * 
	  * Update2：还是不对。查过思路之后，双指针遍历，但保留第一个比x大得数之前的位置，不断在这里插入
	  * 擦……都不知道怎么过的……不过注意，测试的时候 ListNode千万不能static!!!!!
	  * 
	  * */
	    public ListNode partition(ListNode head, int x) {
	        ListNode ins = new ListNode(x-1); // in case head.value >= x
	        ins.next = head;
	        head = ins;
	        ListNode p = head;
	        while (p != null && p.val < x) {
	            ins = p;
	            p = p.next;
	        }
	        if (p == null) return head.next;
	        
	        //p.val >= x, ins is the place after which smaller ListNode inserted
	        ListNode pre = ins;
	        while(p != null) {
	            if (p.val < x) {
	                pre.next = p.next;
	                p.next = ins.next;
	                ins.next = p;
	                ins = ins.next;
	                p = pre.next;
	            } else {
	                pre = p;
	                p = p.next;
	            }
	        }
	        ListNode tmp = head;
	        head = head.next;
	        tmp.next = null;
	        return head;

	    }
	 
	 
//	    public ListNode partition(ListNode head, int x) {
//	        ListNode pre = null;
//	        ListNode pointer = head;
//	        ListNode last = null;
//	        while (pointer != null) {
//	            if (pointer.val < x) {
//	                if (pre != null) {
//	                    pre.next = pointer.next;
//	                    pointer.next = last.next;
//	                    last.next = pointer;
//	                    last = pointer;
//	                    pointer = pre.next;
//	                } else {
//	                	pre = head;
//	                	last = pointer;
//	                	pointer = pointer.next;
//	                }
//	            } else {
//	                pre = pointer;
//	                pointer = pointer.next;
//	            }
//	        }
//	        return head;
//	    }
	 
	 
//    public ListNode partition(ListNode head, int x) {
//        
//        ListNode lastSmall = new ListNode(-1);
//        lastSmall.next = head;
//        
//        ListNode cur = lastSmall;
//        while (cur.next != null) {
//        	
//            if (cur.next.val < x) {
//                lastSmall.next = cur.next;
//                lastSmall = lastSmall.next;
//                cur.next = cur.next.next;
//
//            } else {
//                cur = cur.next;
//            }
//        }
//        return head;
//    }
}
