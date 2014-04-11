package Leetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


public class CloneGraph {
	  class UndirectedGraphNode {
		      int label;
		      ArrayList<UndirectedGraphNode> neighbors;
		      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
		  };
	
	
//	/*Accepted. 1st try
//	 * Use Map to keep the old and new copy graph
//	 * 1st recursion make copy of each old node in graph to new one, including label
//	 * 2nd recursion ensure their corresponding neighbor
//	 * For the tranverse part, BFS should be better, but here I am using DFS*/
//    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
//        if (node == null) return null;
//        
//        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = 
//            new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
//        Boolean newAdded = false;
//        tranverse(node, map);
//        copy(node,map);
//        return map.get(node);
//    }
//    
//    // It's a DFS actually.
//    // To use BFS, need a queue
//    private void tranverse(UndirectedGraphNode cur, HashMap<UndirectedGraphNode,UndirectedGraphNode> map){
//        if (!map.containsKey(cur)) {
//            map.put(cur, new UndirectedGraphNode(cur.label));
//            for (UndirectedGraphNode neigh: cur.neighbors){
//                tranverse(neigh, map);
//            }
//        } else {
//            return;
//        }
//    }
//    
//    private void copy(UndirectedGraphNode cur, HashMap<UndirectedGraphNode,UndirectedGraphNode> map){
//        UndirectedGraphNode newNode = map.get(cur);
//        if (!newNode.neighbors.isEmpty() || (newNode.neighbors.isEmpty() && cur.neighbors.isEmpty())) {
//            return;
//        }
//        for (UndirectedGraphNode neigh: cur.neighbors) {
//            newNode.neighbors.add(map.get(neigh));
//        }
//        for (UndirectedGraphNode news: cur.neighbors) {
//            copy(news, map);
//        }
//    }
		  
		  
	/* Practise BFS without recursion, using Queue*/
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;

		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

		LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		map.put(node, new UndirectedGraphNode(node.label));
		queue.addLast(node);
		while (!queue.isEmpty()) {
			UndirectedGraphNode cur = queue.removeFirst();
			for (UndirectedGraphNode neighbor : cur.neighbors) {
				if (!map.containsKey(neighbor)) {
					map.put(neighbor, new UndirectedGraphNode(neighbor.label));
					queue.addLast(neighbor);
				}
				map.get(cur).neighbors.add(map.get(neighbor));
			}
		}
		return map.get(node);
	}
}
