package Leetcode;
import java.util.ArrayList;


public class MergeKList {
	
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		         next = null;
		      }
	}
	public static void main(String[] args){
		MergeKList superclass = new MergeKList();
		ArrayList<ListNode> list = new ArrayList<ListNode>();
		
		ListNode a1 = superclass.new ListNode(1);
		ListNode a2 = superclass.new ListNode(2);
		ListNode a3 = superclass.new ListNode(3);
		a1.next = a2;
		a2.next = a3;
		ListNode b1 = superclass.new ListNode(1);
		ListNode b2 = superclass.new ListNode(3);
		ListNode b3 = superclass.new ListNode(4);
		b1.next = b2;
		b2.next = b3;
		
		//list.add(a1);
		//list.add(b1);
		
		list.add(null);
		System.out.println(list.indexOf(null));
		System.out.println(list.isEmpty());
		
		ListNode result = mergeKLists(list);
//
//		while(result!=null){
//			System.out.print(result.val+" ");
//			result = result.next;
//		}

	}

	public static ListNode mergeKLists(ArrayList<ListNode> lists) {
		if (lists == null){
			return null;
		}

        while(!lists.isEmpty()&&lists.get(0)==null){
        	lists.remove(0);
        }
        
        ListNode head = null;
        while(!lists.isEmpty()){

            int min = lists.get(0).val;
            int index = 0;
            for (int i=0; i<lists.size(); i++){
                ListNode cur = lists.get(i);
                if (min > cur.val){
                    min = cur.val;
                    index = i;
                }
            }
            ListNode tmp = lists.get(index);
            lists.set(index, lists.get(index).next);
            tmp.next = head;
            head = tmp;
            if(lists.get(index)==null){
                lists.remove(index);
            }
        }
        return head;
    }
}
