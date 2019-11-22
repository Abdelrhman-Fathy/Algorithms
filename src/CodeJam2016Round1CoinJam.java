import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CodeJam2016Round1CoinJam {
	static Map<Integer, String[]> num = new HashMap<>();
	
	
	
	public static void main2(String[] args){
		num.put(0, "ZERO".split(""));
		num.put(1, "ONE".split(""));
		num.put(2, "TWO".split(""));
		num.put(3, "THREE".split(""));
		num.put( 4, "FOUR".split(""));
		num.put(5, "FIVE".split(""));
		num.put(6, "SIX".split(""));
		num.put(7, "SEVEN".split(""));
		num.put(8, "EIGHT".split(""));
		num.put(9, "NINE".split(""));
		
        try(Scanner sc = new Scanner(System.in)){
	        int t = Integer.valueOf(sc.next());
	        for(int i =0; i < t; i++){
	            //System.out.println("Case #" + (i+1) + ": " + test(sc.next()));
	        }
        }
    }
	
	public static void main(String[] args){
		num.put(0, "ZERO".split(""));
		num.put(1, "ONE".split(""));
		num.put(2, "TWO".split(""));
		num.put(3, "THREE".split(""));
		num.put( 4, "FOUR".split(""));
		num.put(5, "FIVE".split(""));
		num.put(6, "SIX".split(""));
		num.put(7, "SEVEN".split(""));
		num.put(8, "EIGHT".split(""));
		num.put(9, "NINE".split(""));
		generatePhone("OZONETOWER");
    }
	
	private static void generatePhone(String s){
		while(s.length() != 0){
			for(int i = 0; i < num.size(); i++){
				String[] numLetters = num.get(i);
				boolean numberExist = true;
				String oldString = new String(s);
				for(int j = 0; j < numLetters.length; j++){
					if(s.indexOf(numLetters[j]) == -1){
						numberExist = false;
						s = oldString;
						break;
					}else{
						//s.setCharAt(j, '');
					}
				}
				if(numberExist){
					
				}
			}
			
		}
	}
}