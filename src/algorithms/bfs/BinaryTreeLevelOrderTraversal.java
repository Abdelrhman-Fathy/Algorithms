package algorithms.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
	       Queue<TreeNode> q = new LinkedList<>();
	        q.add(root);
	        int level = 0;
	        List<List<Integer>> result = new ArrayList<>();
	        while(!q.isEmpty()){
	            int li = q.size();
	            List<Integer> itemsInLevel = new ArrayList<>();
	            for(int i = 0; i < li; i++){
	                TreeNode item = q.poll();
	                    itemsInLevel.add(item.val);
	                    if(item.left != null) q.add(item.left);
	                    if(item.right != null) q.add(item.right);
	            }
	            if(itemsInLevel.size() != 0)
	                result.add(itemsInLevel);
	            level++;
	        }
	        return result;
	    }
	

	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }

}
//https://leetcode.com/problems/binary-tree-level-order-traversal/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 */
