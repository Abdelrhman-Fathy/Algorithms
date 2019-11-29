package algorithms.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class WordLadderII {
	
	 public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
	        List<List<String>> result = new ArrayList<>();
	        if(!wordList.contains(endWord)){
	            return result;
	        }
	        Queue<Node> q = new LinkedList<>();
	        List<Node> tree = new ArrayList<>();
	        tree.add(new Node());
	        tree.get(0).path = new ArrayList<>();
	        tree.get(0).path.add(beginWord);
	        tree.get(0).arrIndex = -1;
	        tree.get(0).index = 0;
	        tree.get(0).parentIndex = -1;
	        tree.get(0).word = beginWord;
	        q.add(tree.get(0));
	        int min = 0;
	        while(!q.isEmpty()){
	            int count = q.size();
	            for(int i = 0; i < count; i++){
	                Node node = q.poll();
	                for(int j =  node.arrIndex + 1; j < wordList.size(); j++){
	                    int diff = calcDiff(wordList.get(j), node.word);
	                    if(diff == 1){
	                        Node child = new Node();
	                        child.arrIndex = j;
	                        child.word = wordList.get(j);
	                        child.parentIndex = node.index;
	                        child.path = new ArrayList<String>(tree.get(child.parentIndex).path);
	                        child.path.add(child.word);
	                        child.index = tree.size();
	                        if(endWord.equals(child.path.get(child.path.size()-1)) && (min == 0 || min >= child.path.size() )){
	                            if(min == 0 || min > child.path.size()){
	                                result.clear();
	                                min = child.path.size();
	                            }
	                            result.add(child.path);
	                        } 
	                        tree.add(child);
	                        q.add(child);
	                    }  
	                }

	            }
	        }
	        return result;
	    }
	    private int calcDiff(String str1, String str2){
	        return ((int) IntStream.range(0, str1.length())
	                .filter(i -> str1.charAt(i) != str2.charAt(i)) 
	                         .count());
	    }
	    
	    class Node{
	        public int parentIndex;
	        public List<String> path;
	        public int arrIndex;
	        public int index;
	        public String word;
	    }
	    

}

//https://leetcode.com/problems/word-ladder-ii/
