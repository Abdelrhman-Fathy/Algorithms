package datastructures.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class AmazonTopNCompetitors {


	public static void main(String[] args) {
		System.out.println(new AmazonTopNCompetitors().
				solution(6, 2, Arrays.asList(new String[]{"Newshop", "shonow", "afashion", "fashionbeats","mymarket","tcellular"}),
						6, Arrays.asList(new String[]{"newshop review", "newshop review2", "fashionbeats review", 
								"fashionbeats review2","mymarket review","Newshop review 3"})
						)
				);

	}
	
	
	public List<String> solution(int numToys, int topToys, List<String> toys, 
			int numQuotes, List<String> quotes){
		//if(topNCompetitors>competitors.size()) use only the competitors list
		//convert reviews to lower case
		//convert competitors to lower case
		
		ArrayList<String> result = new ArrayList<>();
		quotes = toLowerCase(quotes);
		toys = toLowerCase(toys);
		Map<String, Integer> count = new HashMap<>();
		for(int i = 0; i < toys.size(); i++) {
			for(int j = 0; j < quotes.size(); j++) {
				if(quotes.get(j).contains(toys.get(i))) {
					if(count.get(toys.get(i)) == null) {
						count.put(toys.get(i), 1);
					} else {
						count.put(toys.get(i), count.get(toys.get(i)) + 1);
					}
				}
			}
		}
		//System.out.println(count);
		
		PriorityQueue<String> heap = new PriorityQueue<>((n1,n2)->compare(count, n1,n2));
		int k = (topToys>toys.size()? toys.size() : topToys);
		for(String i : count.keySet()) {
			heap.add(i);
			if(heap.size()>k)
				heap.poll();
		}
		
		
		while(!heap.isEmpty()) {
			result.add(heap.poll());
		}
		Collections.reverse(result);
		return result;
	}
	
	public int compare(Map<String, Integer> count, String n1, String n2){
		if(count.get(n1) == count.get(n2)) return n1.compareTo(n2);
		else return count.get(n1)-count.get(n2);
	}
	
	public List<String> toLowerCase(List<String> input){
		for(int i = 0; i < input.size(); i++) {
			input.set(i, input.get(i).toLowerCase());
		}
		return input;
	}

}

//https://leetcode.com/discuss/interview-question/415729/
