package algorithms.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle {
	public int slidingPuzzle(int[][] board) {
	        int sc = 0;
	        int sr = 0;
	        int rows = board.length;
	        int cols = board[0].length;
	        search:
	        for(int i = 0; i < rows; i++){
	            for(int j = 0; j < cols; j++){
	                if(board[i][j] == 0){
	                    sr = i;
	                    sc = j;
	                    break search;
	                }
	            }
	        }
	        Node start = new Node(board, 0, sr, sc);
	        Queue<Node> q = new ArrayDeque();
	        String target = Arrays.deepToString(new int[][]{{1,2,3},{4,5,0}});
	        q.add(start);
	        int[] dr = new int[]{0,0,1,-1};
	        int[] dc = new int[]{1,-1,0,0};
	        Set<String> seen = new HashSet();
	        seen.add(start.boardString);
	        while(!q.isEmpty()){
	            Node n = q.poll();
	            if(n.boardString.equals(target))
	                return n.depth;
	            for(int i = 0; i < 4; i++){
	                int nr = dr[i] + n.r;
	                int nc = dc[i] + n.c;
	                
	                if(nr < rows && nr >= 0 && nc >= 0 && nc< cols){
	                    int[][] nBoard = new int[rows][cols];
	                    for(int j = 0; j < rows; j++)
	                        nBoard[j] = n.board[j].clone();
	                    nBoard[n.r][n.c] = nBoard[nr][nc];
	                    nBoard[nr][nc] = 0;
	                    Node nei = new Node(nBoard, n.depth+1, nr, nc);
	                    if(!seen.contains(nei.boardString)){
	                        q.add(nei);
	                        seen.add(nei.boardString);
	                    }
	                }
	            }
	            
	        }
	        return -1;
	    }
	}

	class Node{
	    int r;
	    int c;
	    int[][] board;
	    String boardString;
	    int depth;
	    Node(int[][] board, int depth, int r, int c){
	        this.c = c;
	        this.r = r;
	        this.board = board;
	        this.boardString = Arrays.deepToString(board);
	        this.depth = depth;
	    }
	    
	}
//https://leetcode.com/problems/sliding-puzzle/

/*
- search for the starting point, value equal to zero.
- instantiate new node from the starting point and add it to the queue
- add starting point meta data to the the seen HashSet.
- construct the target string.
- loop on the queue 
	- if target in the seen list return the depth of the node.
	- loop on the neighbors 
		- clone the board.
		- move the neighbor to the zero place.
		- construct the neighbor node object reflecting the current board state.
		- add the neighbor board string if not seen before and add it to the queue.
- if solution does not exist return -1.

=======Node class====
board arrays
string board string 
row 
column 
depth.
constructor.

/*