package Leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ZigzagBinaryTree {

	/*AC
	 * 注意， 加入到result里的时候要新创建一个arraylist，不然会被清空的*/
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        Queue<TreeNode> nodes = new ArrayDeque<TreeNode>();
        Queue<Integer> layers = new ArrayDeque<Integer>();
        LinkedList<Integer> layerRes = new LinkedList<Integer>();
        boolean l2r = true;
        if (root == null) return res;
        
        nodes.add(root);
        layers.add(0);
        while (nodes.size()!= 0) {
            TreeNode cur = nodes.poll();
            int layer = layers.poll();
            
            if (cur.left != null) {
                nodes.add(cur.left);
                layers.add(layer+1);
            }
            if (cur.right != null) {
                nodes.add(cur.right);
                layers.add(layer+1);
            }
            
            if(l2r) {
                layerRes.addLast(cur.val);
            } else {
                layerRes.addFirst(cur.val);
            }
            
            int nextLayer = (layers.size() != 0) ? layers.peek() : -1;
            if (layer != nextLayer) {
                // cur is the last node of this layer
                res.add(new ArrayList<Integer>(layerRes));
                layerRes.clear();
                l2r = !l2r;
            }
        }
        return res;
    }
}
