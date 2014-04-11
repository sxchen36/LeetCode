package Leetcode;
import java.util.HashSet;
import java.util.Set;


public class LinkedListCycleAdvanced {
	private class ListNode {
		int val;
		ListNode next;
		
		public ListNode(int v){
			val = v;
			next = null;
		}
	}
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<ListNode>();
        while(head!=null){
            if(set.contains(head)) return head;
            set.add(head);
            head=head.next;
        }
        return null;
    }
}
