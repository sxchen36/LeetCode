package Leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {

    /*AC   Merge Sort*/
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists.size() == 0) return null;
        return divideMerge(lists, 0, lists.size()-1);
    }
    
    private ListNode divideMerge(ArrayList<ListNode> lists, int l, int r) {
        if (l >= r) {
            return lists.get(l);
        } else {
            int m = (l+r) / 2;
            return merge(divideMerge(lists, l, m), divideMerge(lists, m+1, r));
        }
    }
    
    private ListNode merge(ListNode n1, ListNode n2) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        pre.next = n1;
        while (n1 != null && n2 != null) {
            if (n1.val > n2.val) {
                ListNode next = n2.next;
                n2.next = pre.next;
                pre.next = n2;
                n2 = next;
            } else {
                n1 = n1.next;
            }
            pre = pre.next;
        }
        
        if (n2 != null) pre.next = n2;
        
        return dummy.next;
    }
	
	
    /*AC 用Heap做排序哇~~
     * O(NlogK) time complexity with a min heap. Space complexity is O(K)*/
//    public ListNode mergeKLists(ArrayList<ListNode> lists) {
//        int k = lists.size();
//        if (k == 0) return null;
//        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(k, new Comparator<ListNode>(){
//            @Override
//            public int compare(ListNode n1, ListNode n2) {
//                return n1.val - n2.val;
//            }
//            
//            });
//        
//        for (ListNode node : lists) {
//            if (node != null)   heap.offer(node);
//        }
//        
//        ListNode head = null, pre = null;
//        while (heap.size() != 0) {
//            ListNode cur = heap.poll();
//            if (head == null) {
//                head = cur;
//                pre = head;
//            } else {
//                pre.next = cur;
//                pre = cur;
//            }
//            if (cur.next != null) heap.offer(cur.next);
//        }
//        
//        return head;
//    }
	
	
	/*没必要重新写一个Heap吧……直接用PriorityQueue就好了嗯~那个就是Heap~可以自定义Comparator~*/
//    /*O(NlogK) with a min heap*/
//    public ListNode mergeKLists(ArrayList<ListNode> lists) {
//        int k = lists.size();
//        ListNode[] heap = new ListNode[k];
//        
//        
//    }
//    
//    /* Maintain the min heap
//    Return the value of the subtree*/
//    private void bubbledown(ListNode[] heap){
//        int index = 0;
//        
//        while (index < heap.size()) {
//            int left = index*2+1;
//            if (left >= heap.size()) break;
//            int right = index*2 + 2;
//            if (right >= heap.size()) {
//                if (heap[index].val > heap[left].val) {
//                    swap(heap, index, left);
//                    index = left;
//                } else {
//                    break;
//                }
//            } else {
//                int smaller = (heap[left].val < heap[right].val ?) left :right;
//                if (heap[index].val > heap[smaller].val) {
//                    swap(heap, index, smaller);
//                    index = smaller;
//                } else {
//                    break;
//                }
//            }
//        }
//        
//    }
//    
//    private void swap(ListNode[] heap, n1, n2) {
//        ListNode tmp = heap[n1];
//        heap[n1] = heap[n2];
//        heap[n2] = tmp;
//    }
//    
//    
//    private void bubbleup(ListNode[] heap) {
//        int index = heap.size()-1;
//        int parent = (index-1)/2;
//        while ( parent >= 0 && heap[index] < heap[parent]) {
//            swap(heap, index, parent);
//            parent = (index-1)/2;
//            index = parent;
//        }
//    }
}
