package Leetcode;
import java.util.HashSet;
import java.util.Set;
public class LinkedListCycle2 {

	private class ListNode {
		int val;
		ListNode next;
		
		public ListNode(int v){
			val = v;
			next = null;
		}
	}
	
	public static boolean hasCycle(ListNode head){
		ListNode faster = head;
		ListNode lower = head;
		while(faster!=null && faster.next!=null){
			lower = lower.next;
			faster = faster.next.next;
			if(lower==faster){
				return true;
			}
		}
		return false;
	}

}
