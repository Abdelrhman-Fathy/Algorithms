package algorithms.bfs;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class ZombieInMatrixAmazon {

	private static final int ArrayDeque = 0;

	public static void main(String[] args) {
		System.out.println(new ZombieInMatrixAmazon().
				zombieTime(new int[][] {{0, 1, 1, 0, 1},
				                            {0, 1, 0, 1, 0},
				                            {0, 0, 0, 0, 1},
				                            {0, 1, 0, 0, 0}}));

	}
	
	
	public int zombieTime(int[][] grid) {
		
		//put all zombies in a queue
		int rowsCount = grid.length;
		int columnsCount = grid[0].length;
		Queue<Integer> zombies = new ArrayDeque<>();
		Map<Integer,Integer> zombiesDistance = new HashMap<>();
		for(int row = 0; row < rowsCount; row++) {
			for(int column = 0; column < columnsCount; column++) {
				if(grid[row][column] == 1) {
					int position = row*columnsCount + column;
					zombies.add(position);
					zombiesDistance.put(position, 0);
				}
			}
		}
		
		//calculate distance for each item
		int maxDistance = 0;
		int[] rowSteps = new int[] {0,0,1,-1};
		int[] columnSteps = new int[] {1,-1,0,0};
		
		while(!zombies.isEmpty()) {
			int position = zombies.remove();
			int row = position/columnsCount;
			int column = position%columnsCount;
			for(int step = 0; step < 4; step++) {
				int nextRow = row + rowSteps[step];
				int nextColumn = column + columnSteps[step];
				if(nextRow >= 0 && nextRow <rowsCount && nextColumn >= 0 && nextColumn < columnsCount && grid[nextRow][nextColumn] == 0) {
					grid[nextRow][nextColumn] = 1;
					int nextPosition = nextRow * columnsCount + column; 
					zombies.add(nextPosition);
					zombiesDistance.put(nextPosition, zombiesDistance.get(position)+1);
					maxDistance = zombiesDistance.get(nextPosition);
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
