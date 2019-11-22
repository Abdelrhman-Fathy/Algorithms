package datastructures;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class BFSGeneral {

	private static final int ArrayDeque = 0;

	public static void main(String[] args) {
		System.out.println(new BFSGeneral().
				zombieTime(new int[][] {{0, 1, 1, 0, 1},
				                            {0, 1, 0, 1, 0},
				                            {0, 0, 0, 0, 1},
				                            {0, 1, 0, 0, 0}}));

	}
	
	
	
	
	public int zombieTime(int[][] grid) {
		
		//put all nodes of interest in a queue
		//general code
		int rowsCount = grid.length;
		int columnsCount = grid[0].length;
		Queue<Utils.Node<Integer, Integer>> zombies = new ArrayDeque<>();
		for(int row = 0; row < rowsCount; row++) {
			for(int column = 0; column < columnsCount; column++) {
				if(grid[row][column] == 1/*add to queue condition*/) {
					int position = Utils.encodeItemPosition(row,column, columnsCount);
					Utils.Node<Integer, Integer>node = new Utils.Node<>(row, column,new Integer(grid[row][column]));
					zombies.add(node);
					//custome logic
					node.setFeature(new Integer(0));
				}
			}
		}
		
		//calculate distance for each item
		int maxDistance = 0; //custome logic
		int[] rowSteps = new int[] {0,0,1,-1};
		int[] columnSteps = new int[] {1,-1,0,0};
		
		while(!zombies.isEmpty()) {
			Utils.Node node = zombies.remove();
			
			for(int step = 0; step < 4; step++) {
				Utils.Node nextNode = new Utils.Node (node.getRow() + rowSteps[step], node.getColumn() + columnSteps[step], null,new Integer(0));
				if(Utils.withinArray(nextNode,  rowsCount,  columnsCount) && grid[nextNode.getRow()][nextNode.getRow()] == 0) {
					grid[nextNode.getRow()][nextNode.getRow()] = 1;
					zombies.add(nextNode);
					if(nextNode.getFeature() == null)
						nextNode.setFeature(0);
					nextNode.setFeature((Integer)nextNode.getFeature() + 1);
					maxDistance = (Integer)nextNode.getFeature();
				}
				
			}
		}
		
		//check if anyone still human!
		for(int row = 0; row < rowsCount; row++) {
			for(int column = 0; column < columnsCount; column++) {
				if(grid[row][column] == 0)
					return -1;
			}
		}
		
		return maxDistance;
	}
	
	

}

/*https://leetcode.com/discuss/interview-question/411357/
 * Given a 2D grid, each cell is either a zombie 1 or a human 0. Zombies can turn adjacent (up/down/left/right) human beings into zombies every hour. Find out how many hours does it take to infect all humans?

Example:

Input:
[[0, 1, 1, 0, 1],
 [0, 1, 0, 1, 0],
 [0, 0, 0, 0, 1],
 [0, 1, 0, 0, 0]]

Output: 2

Explanation:
At the end of the 1st hour, the status of the grid:
[[1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1],
 [0, 1, 0, 1, 1],
 [1, 1, 1, 0, 1]]

At the end of the 2nd hour, the status of the grid:
[[1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1]]
 */
