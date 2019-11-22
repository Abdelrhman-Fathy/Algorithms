package datastructures.hashtable;

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
	
	
	public List<String> solution(int numCompetitors, int topNCompetitors, List<String> competitors, 
			int numReviews, List<String> reviews){
		//if(topNCompetitors>competitors.size()) use only the competitors list
		//convert reviews to lower case
		//convert competitors to lower case
		reviews = toLowerCase(reviews);
		competitors = toLowerCase(competitors);
		Map<String, Integer> count = new HashMap<>();
		for(int i = 0; i < competitors.size(); i++) {
			for(int j = 0; j < reviews.size(); j++) {
				if(reviews.get(j).contains(competitors.get(i))) {
					if(count.get(competitors.get(i)) == null) {
						count.put(competitors.get(i), 1);
					} else {
						count.put(competitors.get(i), count.get(competitors.get(i)) + 1);
					}
				}
			}
		}
		//System.out.println(count);
		
		PriorityQueue<String> heap = new PriorityQueue<>((n1,n2)->count.get(n1)-count.get(n2));
		int k = (topNCompetitors>competitors.size()? competitors.size() : topNCompetitors);
		for(String i : count.keySet()) {
			heap.add(i);
			if(heap.size()>k)
				heap.poll();
		}
		
		List<String> result = new LinkedList<>();
		while(!heap.isEmpty()) {
			result.add(heap.poll());
		}
		Collections.reverse(result);
		return result;
	}
	
	public List<String> toLowerCase(List<String> input){
		for(int i = 0; i < input.size(); i++) {
			input.set(i, input.get(i).toLowerCase());
		}
		return input;
	}

}

//https://leetcode.com/discuss/interview-question/415729/
