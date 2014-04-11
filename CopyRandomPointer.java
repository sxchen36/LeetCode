package Leetcode;
import java.util.HashMap;


public class CopyRandomPointer {
	  class RandomListNode {
		      int label;
		      RandomListNode next, random;
		      RandomListNode(int x) { this.label = x; }
		  };
		  
//		  /*Accepted; 1st Attempt
//		   * Space complexity O(3N), time complexity O(N)*/
//	public RandomListNode copyRandomList(RandomListNode head) {
//        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
//        RandomListNode p1 = head;
//        while(p1 != null){
//            map.put(p1, new RandomListNode(p1.label));
//            p1 = p1.next;
//        }
//        p1 = head;
//        while(p1 != null){
//            RandomListNode p2 = map.get(p1);
//            p2.random = map.get(p1.random);
//            p2.next = map.get(p1.next);
//            p1 = p1.next;
//        }
//        return map.get(head);
//    }
		  
		  /* Super solution learned from others*/
	public RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode c = head;
		// Add duplicated node after each node
		// The list is 2*N now
		while (c != null){
			RandomListNode n = new RandomListNode(c.label);
			n.next = c.next;
			n.random = c.random;
			c.next = n;
			c = n.next;
		}
		c = head;
		// Only modify duplicated Nodes, change their random pointer
		// to random.next, which should be the right random nodes for them
		while(c != null){
			c = c.next;
			if (c.random != null){
				c.random = c.random.next;		
			}

			c = c.next; // if c is not null, the duplicated node is not null
		}
		
		/*Wrong because I didn't reset original node next*/
		RandomListNode newHead = new RandomListNode(0);
//		newHead.next = head;
//		RandomListNode newP = newHead;
//		c = head;
//		while(c!=null){
//			newP.next = c.next;
//			c = c.next.next;
//			newP = newP.next;
//		}
//		return newHead.next;
		
        newHead.next = head;
        c = head;
        RandomListNode cNew = newHead;
        while (c != null) {
           cNew.next = c.next;
           c.next = c.next.next;
           cNew = cNew.next;
           c = c.next;
        }
        return newHead.next;
	}
}
