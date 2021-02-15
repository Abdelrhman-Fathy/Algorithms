package algorithms.bfs;

import java.awt.Point;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BusRoutes {
	public int numBusesToDestination(int[][] routes, int s, int t) {
		if (s == t)
			return 0;
		List<Node> graph = new ArrayList();
		int n = routes.length;
		Queue<Node> q = new ArrayDeque();
		for (int i = 0; i < n; i++) {
			Arrays.sort(routes[i]);
			Node bus = new Node();
			graph.add(bus);
			bus.name = i;
			if (Arrays.binarySearch(routes[i], s) >= 0) {
				bus.s = true;
				bus.depth = 0;
				bus.visited = true;
				q.add(bus);
			}
			if (Arrays.binarySearch(routes[i], t) >= 0) {
				bus.t = true;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (intersect(routes[i], routes[j])) {
					graph.get(i).neighbors.add(j);
					graph.get(j).neighbors.add(i);
				}
			}
		}
		while (!q.isEmpty()) {
			Node bus = q.poll();
			if (bus.t)
				return bus.depth + 1;
			for (int i = 0; i < bus.neighbors.size(); i++) {
				Node nei = graph.get(bus.neighbors.get(i));
				if (!nei.visited) {
					q.add(nei);
					nei.visited = true;
					nei.depth = bus.depth + 1;
				}
			}
		}
		return -1;

	}

	public boolean intersect(int[] a, int[] b) {
		int i = 0, j = 0;
		while (i < a.length && j < b.length) {
			if (a[i] == b[j])
				return true;
			if (a[i] < b[j])
				i++;
			else
				j++;
		}
		return false;
	}

	public class Node {
		int name;
		boolean visited;
		List<Integer> neighbors = new ArrayList();
		int depth;
		boolean s;
		boolean t;
	}
}
//https://leetcode.com/problems/bus-routes/
/*
#convert buses array to list of buses.
	#set the name for each node
#sort arrays buses.
get intersections for each bus.
#get if bus has target 
	#set target flag = true
#check if bus has source 
	#set source flag = true
	#add to queue
	#set visited = true
	#set depth = 0;
	
#loop on the queue 
	#if node has target
	#	return depth+1
	#else
		#loop on neighbours
			#add neighbours to the queue 
			#set neighbors as visited 
			#set depth = parent depth +1 

if queue is empty and still we cannot find the bus return -1
			
*/