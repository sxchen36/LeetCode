package Leetcode;
import java.util.HashSet;
import java.util.Set;
public class LinkedListCycle {

	private class ListNode {
		int val;
		ListNode next;
		
		public ListNode(int v){
			val = v;
			next = null;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean hasCycle(ListNode head){
		Set<ListNode> set = new HashSet<ListNode>();
		if(head == null) return false;
		if(head.next == head) return true;
		while(head.next!=null){
			head = head.next;
			if(set.contains(head)){
				return true;
			}
			set.add(head);
		}
		return false;
	}

}
