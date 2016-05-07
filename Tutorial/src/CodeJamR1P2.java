import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CodeJamR1P2 {
	public static void main2(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int t = Integer.valueOf(sc.next());
			int n = Integer.valueOf(sc.next());
			Map<Integer, String[]> m1 = new HashMap<>();
			Map<String, Boolean> elms = new HashMap<>();
			for (int i = 0; i < t; i++) {
				for (int j = 0; j < n; j++)
					System.out.println("Case #" + (i + 1) + ": " + solution(sc.next(), n, j, m1, elms));
			}
			String[] row = new String[n];
			if(isValidRow(m1, row)){
				
			}
		}
			
	}

	private static String solution(String rowStr, int n, int rowNum, Map<Integer, String[]> m1, Map<String, Boolean> elms) {
		String[] row = rowStr.split(" ");
		for(String elm : row)
			elms.put(elm,  true);
		m1.put(m1.size() - 1, row);
		return "";
	}
	private static boolean isValidRow(Map<Integer, String[]> m1, String row[]){
		int count = 0;
		for(int j =0; j < m1.size(); j++){
			count = 0;
			for(int i =0; i < row.length; i++){
				if(row[i].equals(m1.get(j)[i]))
					count++;
			}
			
		}
		if(count == 2 * row.length)
			return true;
		return false;
	}
}
