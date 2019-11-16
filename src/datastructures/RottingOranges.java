package datastructures;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class RottingOranges {

	public static void main(String[] args) {
		System.out.println(new RottingOranges().
				orangesRotting(new int[][] {{2,1,1},{1,1,0},{0,1,1}}));
		System.out.println(new RottingOranges().
				orangesRotting(new int[][] {{2,1,1},{0,1,1},{1,0,1}}));
	}
	
	public int orangesRotting(int[][] grid) {
		//Add all the rotten oranges to queue.
		int rowsCount = grid.length;
		int columnsCount = grid[0].length;
		Queue<Integer> rottenOranges = new ArrayDeque<>();
		Map<Integer,Integer> rottenOrangeDepth = new HashMap<>();
		for(int row = 0; row < rowsCount; row++) {
			for(int column = 0; column < columnsCount; column++) {
				if(grid[row][column] == 2) {
					int position = encodeItemPosition(row,column, columnsCount);
					rottenOranges.add(position);
					rottenOrangeDepth.put(position, 0);
				}
			}
		}
			
		//Calculate the minimum distance [depth] between rotten orange and good oranges
		int[] rowSteps = new int[] {-1,1,0,0};
		int [] columnSteps = new int[] {0,0,-1,1};
		int maxDistance = 0;
		while(!rottenOranges.isEmpty()) {
			//get the rotten orange position
			int position = rottenOranges.remove();
			int row = decodeRow(columnsCount, position);
			int column = decodeColumn(columnsCount, position);
			//check neighboring items
			for(int step = 0; step < 4; step++) {
				int nextRow = row + rowSteps[step];
				int nextColumn = column + columnSteps[step];
				if(nextRow >= 0 && nextRow < rowsCount && nextColumn >= 0 && nextColumn < columnsCount && grid[nextRow][nextColumn] == 1) {
					grid[nextRow][nextColumn] = 2;
					int nextItemPosition = encodeItemPosition(nextRow, nextColumn, columnsCount);
					rottenOranges.add(nextItemPosition);
					rottenOrangeDepth.put(nextItemPosition, rottenOrangeDepth.get(position) + 1);
					maxDistance = rottenOrangeDepth.get(nextItemPosition);
				}
				
			}
			
		}
		
		//check if still there is any good orange
        for (int[] row: grid)
            for (int orange: row)
                if (orange == 1)
                    return -1;
		
        return maxDistance;
    }
	
	public int decodeRow(int columnsCount, int position) {
		return (position/columnsCount);
	}
	public int decodeColumn(int columnsCount, int position) {
		return (position % columnsCount);
	}
	
	public int encodeItemPosition(int row, int column, int columnsCount) {
		return (row * columnsCount + column);
	}
}
//https://leetcode.com/problems/rotting-oranges/
/*In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

 

Example 1:



Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Note:

1 <= grid.length <= 10
1 <= grid[0].length <= 10
grid[i][j] is only 0, 1, or 2.
*/