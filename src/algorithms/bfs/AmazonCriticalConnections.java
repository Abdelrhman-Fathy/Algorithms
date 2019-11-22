package algorithms.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AmazonCriticalConnections {

	public static void main(String[] args) {
		//System.out.println(new AmazonCriticalConnections().criticalConnections(4, twoDArrayToList(new Integer[][] {{0,1},{1,2},{2,0},{1,3}})));
		System.out.println(new AmazonCriticalConnections().criticalConnections(9, twoDArrayToList(new Integer[][] {{1, 2}, {1, 3}, {2, 3}, {3, 4}, {3, 6}, {4, 5}, {6, 7}, {6, 9}, {7, 8}, {8, 9}})));
		
		
		 
		
	}
	
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
	
	
	// the order of visiting vertices
    private Map<Integer,Integer> ord;
    
    // the lowest index of the vertex that this vertex can reach
    private Map<Integer, Integer> low;
    
    // keep track of the current order;
    private int count;
    
    // result
    private List<List<Integer>> result;
    
    // graph
    private Map<Integer, List<Integer>> graph;
    
    private Map<Integer, Boolean> visited;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // find bridge of a graph.
        
        // first, build the graph with map
        graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        
        for (List<Integer> connection : connections) {
            int v = connection.get(0);
            int w = connection.get(1);
            graph.get(v).add(w);
            graph.get(w).add(v);
        }
        
        ord = new HashMap<>();
        low = new HashMap<>();
        visited = new HashMap<>();
        result = new ArrayList<>();
     
        // next, do dfs to keep track of the ord and low data of each vertex
        for (int i = 1; i <= n; i++) {
            if (visited.get(i) == null || !visited.get(i))
                dfs(i, i);
        }
        
        return result;
    }
    
    
    
    private void dfs(int v, int parent) {
        // visit this vertex
        visited.put(v,true);
        ord.put(v, count++);
        low.put(v,ord.get(v));
        
        List<Integer> adjs = graph.get(v);
        for (int w : adjs) {
            if (visited.get(w) == null || !visited.get(w)) {
                dfs(w, v);
                low.put(v, Math.min(low.get(w), low.get(v)));
                if (low.get(w) > ord.get(v)) {
                    List<Integer> bridge = new ArrayList<>();
                    bridge.add(v);
                    bridge.add(w);
                    result.add(bridge);
                }
            } else {
                if (w != parent) {
                    low.put(v, Math.min(low.get(v), low.get(w)));
                }
            }
        }
    }
	

	

}
//https://leetcode.com/problems/critical-connections-in-a-network/

/*
 * There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections forming a network where connections[i] = [a, b] represents a connection between servers a and b. Any server can reach any other server directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some server unable to reach some other server.

Return all critical connections in the network in any order.

 

Example 1:



Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.
 

Constraints:

1 <= n <= 10^5
n-1 <= connections.length <= 10^5
connections[i][0] != connections[i][1]
There are no repeated connections.
 */
