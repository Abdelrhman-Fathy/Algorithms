package algorithms.backtrack;

import java.util.Arrays;

public class SudokuSolver {
	public static void main(String[] args) {
		
		char[][] board = {
				{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
				{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
				{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
				{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
				{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
				{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
				{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
				{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
				{'.', '.', '.', '.', '8', '.', '.', '7', '9'},
		};
		SudokuSolver solve = new SudokuSolver();
		solve.solveSudoku(board);
		System.out.println(Arrays.deepToString(board));
		
	}
	
	
	
	int getBoxId(int row, int col) {
		int rowVal = (row / 3) * 3;
		int colVal = col / 3;
		return rowVal + colVal;
	}

	boolean isValid(boolean[] box, boolean[] row, boolean[] col, int num) {
		return !(box[num] || row[num] || col[num]);
	}

	boolean solveBacktrack(char[][] board, boolean[][] boxes, boolean[][] rows, boolean[][] cols, int r, int c){
		if(board[0].length == c || board.length == r) return true;
		int nr = r;
		int nc = c;
		if(c == board[0].length - 1){
			nc = 0;
			nr++;
		} else {
			nc++;
		}
		if(board[r][c] == '.'){
			boolean[] box = boxes[getBoxId(r,c)];
			boolean[] row = rows[r];
			boolean[] col = cols[c];
			for(int num = 1; num <= 9; num++){
				if(isValid(box,row,col,num)){
					board[r][c] = (char) ('0'+num);
					box[num] = true;
					row[num] = true;
					col[num] = true;
					if(solveBacktrack(board, boxes, rows, cols, nr,nc)) return true;
					board[r][c] = '.';
					box[num] = false;
					row[num] = false;
					col[num] = false;
				}
			}
			
		} else {
			if(solveBacktrack(board, boxes, rows, cols, nr, nc)) return true;
		}
		
		return false;
	}
	void solveSudoku(char[][] board) {
		int n = board.length;
		boolean[][] boxes = new boolean[n][n + 1];
		boolean[][] rows = new boolean[n][n + 1];
		boolean[][] cols = new boolean[n][n + 1];

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (board[r][c] != '.') {
					int val = Character.getNumericValue(board[r][c]);
					boxes[getBoxId(r, c)][val] = true;
					rows[r][val] = true;
					cols[c][val] = true;
				}
			}
		}
		solveBacktrack(board, boxes, rows, cols, 0, 0);
	}
		
}
