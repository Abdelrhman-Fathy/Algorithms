import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CodeJam2016Round1Pancackes {
	public static void main(String[] args){
        Map<Integer, Boolean> m = new HashMap<>();
        try(Scanner sc = new Scanner(System.in)){
	        int t = Integer.valueOf(sc.next());
	        for(int i =0; i < t; i++){
	            System.out.println("Case #" + (i+1) + ": " + getPancackesFilpsCount(sc.next()));
	        }
        }
    }
	
	public static int getPancackesFilpsCount(String str){
		int sections = 1; 
		for(int i = 0; i< str.length() - 1 ; i++){
			if(!str.substring(i, i+1).equals(str.substring(i + 1 , i + 2))){
				sections++;
			}
		}

		boolean startWithHappy = false;
		if(str.substring(0, 1).equals("+"))
			startWithHappy = true;
		if((startWithHappy && sections % 2 == 0)||((!startWithHappy) && sections % 2 != 0))
			return sections;
		else
			return sections - 1;
	}
}
