
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CodeJam2016Round1 {
	//cd C:\Users\Abdelrhman\workspace\Tutorial\src\

//C:\Users\Abdelrhman\workspace\Tutorial\src>java CodeJam2016Round1 <C:\Users\Abdelrhman\Desktop\in1.txt> C:\Users\Abdelrhman\Desktop\out1.txt
    public static void main(String[] args){
        Map<Integer, Boolean> m = new HashMap<>();
        try(Scanner sc = new Scanner(System.in)){
	        int t = Integer.valueOf(sc.next());
	        for(int i =0; i < t; i++){
	            System.out.println("Case #" + (i+1) + ": " + checkIfContainsAllNumbers(Integer.valueOf(sc.next()), m));
	        }
        }
        
    }
    
    private static String checkIfContainsAllNumbers(int x, Map<Integer, Boolean> m){
        if(x == 0)
            return "INSOMNIA";
        m.clear();
        return checkNum(x, 1, x, m);
    }
    
    private static String checkNum(int curNum, int i, int x, Map<Integer, Boolean> m){
            int digit = curNum % 10;
            m.put(digit, true);
            curNum = curNum / 10;
            if(curNum == 0 && m.size() != 10)
                curNum = (++i) * x;
        if (curNum != 0 && m.size() != 10){
            return checkNum(curNum, i, x, m);
        }else {
            return "" + (i*x);
        }
    }
}
