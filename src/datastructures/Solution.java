package datastructures;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution {
	
	
	
	int[] rowSteps = new int[] {0,0,1,-1};
	int[] columnSteps = new int[] {1,-1,0,0};
	int count = 0;
	Map<Integer, Integer> areas;
	Map<Integer, Boolean> graph;

	int numberAmazonTreasureTrucks(int rows, int column, List<List<Integer>> grid) {
		areas = new HashMap<>();
		
		graph = new HashMap<>();
		Map<Integer,Integer> zombiesDistance = new HashMap<>();
		for(int row = 0; row < rows; row++) {
			for(int col = 0; col < column; column++) {
				int position = encodeItemPosition(row,col, column);
				if(grid.get(row).get(col) == 1) {
					graph.put(position, true);
					for(int step = 0; step < 4; step++) {
						int nextRow = row + rowSteps[step];
						int nextColumn = column + columnSteps[step];
						if(nextRow >= 0 && nextRow < rowsCount && nextColumn >= 0 && nextColumn < columnsCount 
								&& grid[nextRow][nextColumn] == 0) {
							grid[nextRow][nextColumn] = 1;
							int nextPosition = encodeItemPosition(nextRow, nextColumn, columnsCount);
							zombies.add(nextPosition);
							zombiesDistance.put(nextPosition, zombiesDistance.get(position)+1);
							maxDistance = zombiesDistance.get(nextPosition);
						}
					}
				}
					
				
			}
		}
		
		int size = rows * column;
		for(int row = 0; row < rows; row++) {
			for(int col = 0; col < column; col++) {
				if(grid.get(row).get(col) == 1) {
					
				}
			}
			
		}
		return count;
		
    }
	
	public int encodeItemPosition(int row, int column, int columnsCount) {
		return (row*columnsCount + column);
	}
	
	public int  decodeRow(int position, int columnsCount) {
		return (position/columnsCount);
	}
	public int  decodeColumn(int position, int columnsCount) {
		return (position%columnsCount);
	}
	


	public static void main(String[] args) {

		
		System.out.println(new Solution().numberAmazonTreasureTrucks(5,4, twoDArrayToList(new Integer[][] 
				{{1,1,0,0},{0,0,1,0},{0,0,0,0},{1,0,1,1},{1,1,1,1}})));

		

	}
	
	

	//------do not add---
	
	
	public static List<List<Integer>> twoDArrayToList(Integer[][] twoDArray) {
		List<List<Integer>> list = new ArrayList<>();
	    for(int row = 0; row < twoDArray.length; row++) {
	    	List<Integer> innerList = new ArrayList<>();
 	    	for(int column = 0; column < twoDArray[row].length; column++) {
 	    		innerList.add(twoDArray[row][column]);
	    	}
 	    	list.add(innerList);
	    }
	    return list;
	}

}
