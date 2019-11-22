package algorithms.bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if(root == null) return levels;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while(!q.isEmpty()){
            List<Integer> levelList = new ArrayList<>();
            int levelSize = q.size();
            for(int i = 0; i < levelSize; i++){
                TreeNode item = q.poll();
                levelList.add(item.val);
                if(item.left != null) q.add(item.left);
                if(item.right != null) q.add(item.right);
            }
            if(level % 2 == 1)
                Collections.reverse(levelList);
            levels.add(levelList);
            level++;
        }
        return levels;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/submissions/
/*
 * 103. Binary Tree Zigzag Level Order Traversal
Medium

1340

74

Favorite

Share
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 * 
 */

