package algorithms.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.IntStream;

public class WordLadderII {
	
	 public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
	       Set<String> wordSet = new HashSet<>(wordList);
	        List<List<String>> r = new ArrayList<>();
	        
	        if(!wordSet.contains(endWord)){
	            return r;
	        }
	        
	        Map<String, List<String>> nodeWithParents = new HashMap<>();
	        Map<String, Integer> distance = new HashMap<>();
	        
	        //BFS to populate distance and nodeWithParentd
	        populate(beginWord, endWord, wordList, 
	                         nodeWithParents,
	                         distance,
	                         wordSet);
	        
	        //BFS to find all shortest path
	        findPaths(beginWord, endWord,
	                         wordList,
	                         nodeWithParents,
	                         distance,
	                         wordSet,
	                         r);
	        return r;
	        
	    }
	    
	    private void findPaths(String beginWord, String endWord,
	                         List<String> wordList,
	                         Map<String, List<String>> nodeWithParents,
	                         Map<String, Integer> distance,
	                         Set<String> wordSet,
	                         List<List<String>> r){
	        
	        Queue<List<String>> q = new LinkedList<>();
	        List<String> list = new ArrayList<>();
	        list.add(endWord);
	        
	        q.offer(new ArrayList<>(list));
	        
	        while(!q.isEmpty()){
	            int size = q.size();
	            while(size>0){
	                list = q.poll();
	                String s = list.get(0);
	                for(String parent: nodeWithParents.get(s)){
	                    list.add(0, parent);
	                    if(parent.equals(beginWord)){
	                        r.add(new ArrayList<>(list));
	                    }else if(distance.containsKey(s) && distance.get(parent) +1 == distance.get(s)){
	                        q.offer(new ArrayList<>(list));
	                    }
	                    list.remove(0);
	                }
	                size--;
	            }
	        }
	    }
	    
	    private void populate(String beginWord, String endWord, List<String> wordList, 
	                         Map<String, List<String>> nodeWithParents,
	                         Map<String, Integer> distance,
	                         Set<String> wordSet){
	        
	        //start word
	        distance.put(beginWord, 0);
	        wordSet.add(beginWord);
	        
	        for(String word: wordSet){
	            nodeWithParents.put(word, new ArrayList<String>());
	        }
	        
	        Queue<String> q = new LinkedList<>();
	        q.offer(beginWord);
	        
	        while(!q.isEmpty()){
	            String word = q.poll();
	            List<String> validWords = validTransformedWords(word, wordSet);
	            for(String validWord: validWords){
	                nodeWithParents.get(validWord).add(word);
	                if(!distance.containsKey(validWord)){
	                    distance.put(validWord, distance.get(word)+1);
	                    q.offer(validWord);
	                }
	            }
	        }
	        System.out.println(distance);
	    }
	    
	    private List<String> validTransformedWords(String word, Set<String> wordSet){
	        List<String> validWords = new ArrayList<>();
	        if(word.length() == 0){
	            return validWords;
	        }
	        
	        StringBuffer sb = new StringBuffer(word);
	        for(int i=0;i<sb.length();i++){
	            char temp = sb.charAt(i);
	            for(char c='a';c<='z';c++){
	                if(temp == c){
	                    continue;
	                }
	                sb.setCharAt(i, c);
	                String newWord = new String(sb);
	               //  System.out.println(newWord);
	                if(wordSet.contains(newWord)){
	                    validWords.add(newWord);
	                }
	            }
	            sb.setCharAt(i, temp);
	        }
	        return validWords;
	    }
	    

}

//https://leetcode.com/problems/word-ladder-ii/
