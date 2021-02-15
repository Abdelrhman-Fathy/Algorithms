package algorithms.bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CutOffTreesForGolfEvent {

	public int cutOffTree(List<List<Integer>> forest) {
		List<Node> trees = new ArrayList();
		List<List<Node>> graph = new ArrayList();
		for (int r = 0; r < forest.size(); r++) {
			graph.add(new ArrayList());
			for (int c = 0; c < forest.get(0).size(); c++) {
				Node tree = new Node(r, c, forest.get(r).get(c));
				graph.get(r).add(tree);
				if (forest.get(r).get(c) > 1)
					trees.add(tree);
			}
		}
		Collections.sort(trees, (a, b) -> Integer.compare(a.height, b.height));
		// System.out.println("trees" + trees);
		Node source = graph.get(0).get(0);
		int ans = 0;
		for (int i = 0; i < trees.size(); i++) {
			int d = distBFS(graph, source, trees.get(i));
			// System.out.println("d: " + d);
			if (d < 0)
				return -1;
			ans += d;
			source = trees.get(i);
		}
		return ans;

	}

	private int distBFS(List<List<Node>> graph, Node s, Node t) {
		int[] dr = new int[] { 0, 0, 1, -1 };
		int[] dc = new int[] { 1, -1, 0, 0 };

		Queue<Node> q = new LinkedList();
		q.add(s);
		s.depth = 0;

		boolean[][] visited = new boolean[graph.size()][graph.get(0).size()];
		visited[s.row][s.col] = true;
		while (!q.isEmpty()) {
			Node tree = q.poll();
			if (tree.row == t.row && tree.col == t.col)
				return tree.depth;

			for (int i = 0; i < 4; i++) {
				int r = dr[i] + tree.row;
				int c = dc[i] + tree.col;
				if (r >= 0 && r < graph.size() && c >= 0 && c < graph.get(0).size() && !visited[r][c]
						&& graph.get(r).get(c).height > 0) {
					Node next = graph.get(r).get(c);

					q.add(next);
					visited[next.row][next.col] = true;
					next.depth = tree.depth + 1;
					// System.out.println(next);
				}
			}
		}
		return -1;

	}

	public class Node {
		int depth;
		int row;
		int col;
		int height;

		Node(int row, int col, int height) {
			this.row = row;
			this.col = col;
			this.height = height;
		}
		/*
		 * public String toString(){ return "{depth: " + depth + ", row: " + row +
		 * ", col: " + col + ", height: " + height + "}"; }
		 */
	}
}
//https://leetcode.com/problems/cut-off-trees-for-golf-event/solution/

/*
----main logic------
Find tree list 
sort tree list based on height.
set first point 0,0
loop on tree list 
	get distance between first tree and next tree
	if distance less than 0 return -1
	add distance to total distance.
	set source to distination
return total distance;

--------calculate distance---------
add source to the queue
mark source as seen
reset visited array
loop on the queue 
	if node equals target
		return source depth
	get source neighbors 
	if not seen and walkable neighbor and in range 
		add it to the queue
		mark it as seen.
return -1
 */
