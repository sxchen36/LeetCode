package Leetcode;

public class insertionSortList {
	 public static final void main(String[] args){
		 ListNode first = new ListNode(1);
		 
		 ListNode second = new ListNode(1);
		 first.next = second;
		 
		 System.out.print(insertionSortList(first) == second);
	 }
	
	
	  public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }
	/* Accepted. My 1st try. Claim previous Nodes for both point and current
	 * I think it's better than a seperate method called findPreNode(Node n)
	 * It will inefficient for time*/
	  
    public static ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode curHead = head;
        ListNode point = head;
        ListNode current = head.next;
        ListNode preP = head;
        ListNode preC = head;
        while(current != null) {
            while(point != current && point.val < current.val){
                preP = point;
                point = point.next;
            }
            if (point == curHead) {
                preC.next = current.next;
                current.next = curHead;
                curHead = current;
                current = preC.next;
            } else if (point == current) {
                preC = current;
                current = current.next;
            } else { //point.val >= current.val, preP -> current -> point, preC unchanged
                preP.next = current;
                preC.next = current.next;
                current.next = point;
                current = preC.next;
            }
            
            point = curHead;
        }
        return curHead;
    }
	  
	  
	  /*Wrong! no way to reset the preNode.next of the current node to null*/
//	  /* Use nextC instead of preC to keep the next current location should be better
//	   * And no need to use curHead, just use head*/
//	  public static ListNode insertionSortList(ListNode head){
//		  if(head == null) return head;
//		  
//		  ListNode point, preP, cur, nextC;
//		  point = head;
//		  preP = null;
//		  cur = head.next;
//		  while(cur != null){
//			  nextC = cur.next; // locate next current first! Brilliant!!!
//			  if(cur.val < head.val){
//				  cur.next = head;
//				  head = cur;
//			  } else {
//	  				preP = head;
//	  				point = head.next;
//				  while(point!= null && cur.val > point.val){
//	  				preP = point;
//	  				point = point.next
//				  }
//				  preP.next = cur;
//				  cur.next = point;
//			  }
//			  point = head;
//			  preP = head;
//			  cur = nextC;
//		  }
//		  return head;
//	  }

}
