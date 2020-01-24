package oa.amazon;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

//https://github.com/Abdelrhman-Fathy/Algorithms/blob/master/OA-Amazon-Q1.JPG
public class TreasureTruck {
	public static void main(String[] args) {
		List<List<Integer>> areas = new ArrayList();
		areas.add(new ArrayList<>(Arrays.asList(0, 1, 1, 0, 0, 1)));
		areas.add(new ArrayList<>(Arrays.asList(0, 1, 0, 1, 1, 1)));
		areas.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 1)));
		areas.add(new ArrayList<>(Arrays.asList(1, 1, 0, 1, 1, 1)));
		System.out.println("Areas:" + solution(areas));
	}

	private static int solution(List<List<Integer>> areas) {
		int parks = 0;
		int rows = areas.size();
		int cols = areas.get(0).size();
		int[] nr = new int[] { 1, -1, 0, 0 };
		int[] nc = new int[] { 0, 0, 1, -1 };
		List<List<Node>> graph = new ArrayList();
		List<Node> nodes = new ArrayList();
		Queue<Node> q = new ArrayDeque();
		for (int i = 0; i < rows; i++) {
			List<Node> nodeList = new ArrayList();
			graph.add(nodeList);
			for (int j = 0; j < cols; j++) {
				nodeList.add(new Node(i, j, areas.get(i).get(j), 0));
				if (areas.get(i).get(j).equals(1))
					nodes.add(graph.get(i).get(j));
			}
		}
		for(Node node : nodes) {
			if(node.depth == 0) {
				node.depth = ++parks;
				q.add(node);
			}
			while (!q.isEmpty()) {
				Node n = q.poll();
				for (int i = 0; i < 4; i++) {
					int nRow = n.row + nr[i];
					int nCol = n.col + nc[i];
					if (nRow >= 0 && nRow < rows && nCol < cols && nCol >= 0) {
						Node nNode = graph.get(nRow).get(nCol);
						if(nNode.val == 1 && nNode.depth == 0) {
							nNode.depth = n.depth;
							q.add(nNode);
						}
					}
				}
				//System.out.println("depth:" + n.depth + " , row:" + n.row + ", col:" + n.col);
			}
			
		}
		
		return parks;
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
