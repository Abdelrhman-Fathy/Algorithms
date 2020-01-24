package oa.amazon;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

import oa.amazon.TreasureTruck.Node;

public class CloudFrontFiles {
	//https://github.com/Abdelrhman-Fathy/Algorithms/blob/master/OA-Amazon-Q2.JPG
	//https://github.com/Abdelrhman-Fathy/Algorithms/blob/master/OA-Amazon-Q2-2.JPG
	//https://github.com/Abdelrhman-Fathy/Algorithms/blob/master/OA-Amazon-Q2-3.JPG
	
	public static void main(String[] args) {
		List<List<Integer>> servers = new ArrayList();
		servers.add(new ArrayList<>(Arrays.asList(0, 1, 1, 0, 1)));
		servers.add(new ArrayList<>(Arrays.asList(0, 1, 0, 1, 0)));
		servers.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 1)));
		servers.add(new ArrayList<>(Arrays.asList(0, 1, 0, 0, 0)));
		servers.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 1)));
		System.out.println("hours:" + solution(servers));
	}
	
	private static int solution(List<List<Integer>> servers) {
		int maxDepth = 0;
		int rows = servers.size();
		int cols = servers.get(0).size();
		int[] nr = new int[] { 1, -1, 0, 0 };
		int[] nc = new int[] { 0, 0, 1, -1 };
		List<List<Node>> graph = new ArrayList();
		Queue<Node> q = new ArrayDeque();
		for (int i = 0; i < rows; i++) {
			List<Node> nodeList = new ArrayList();
			graph.add(nodeList);
			for (int j = 0; j < cols; j++) {
				nodeList.add(new Node(i, j, servers.get(i).get(j), 0));
				if (servers.get(i).get(j).equals(1))
					q.add(graph.get(i).get(j));
			}
		}
			
		while (!q.isEmpty()) {
			Node n = q.poll();
			for (int i = 0; i < 4; i++) {
				int nRow = n.row + nr[i];
				int nCol = n.col + nc[i];
				if (nRow >= 0 && nRow < rows && nCol < cols && nCol >= 0) {
					Node nNode = graph.get(nRow).get(nCol);
					if(nNode.val == 0) {
						nNode.val = 1;
						nNode.depth = n.depth + 1;
						q.add(nNode);
						maxDepth = nNode.depth;
					}
				}
			}
			//System.out.println("depth:" + n.depth + " , row:" + n.row + ", col:" + n.col);
		}
		return maxDepth;
	}
	
	
	
	static class Node {
		public int col;
		public int row;
		public int val;
		public int depth;

		Node(int row, int col, int val, int depth) {
			this.col = col;
			this.val = val;
			this.row = row;
			this.depth = depth;
		}
	}

}
