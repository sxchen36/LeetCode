package Leetcode;
import java.util.HashSet;
import java.util.Set;


public class LinkedListCycleAdvanced2 {
	private class ListNode {
		int val;
		ListNode next;
		
		public ListNode(int v){
			val = v;
			next = null;
		}
	}
    public ListNode detectCycle(ListNode head) {
        ListNode cur = head;
        ListNode pointer = head;
        while(pointer != null){
            if (pointer == cur) return cur;
        }
        return null;
    }
}
