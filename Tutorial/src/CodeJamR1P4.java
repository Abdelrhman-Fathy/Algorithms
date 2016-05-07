
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Arturs Licis
 */

public class CodeJamR1P4 {
	private static Scanner sc = new Scanner(System.in);
	static int i, j, k, m, n, l;
	static Map<Integer,Integer> cnt = new HashMap<>();
	
	public static void main(String[] args) {
	    //freopen("x.in", "r", stdin);

		//freopen("B-small-attempt0.in", "r", stdin);
		//freopen("B-small-attempt0.out", "w", stdout);

		//freopen("B-large.in", "r", stdin);
		//freopen("B-large.out", "w", stdout);
		
		int tt = 0 , tn;
		tn = sc.nextInt();
		for(tt = 1; tt <= tn; tt++){
			//cerr << tt << endl;
			 n = sc.nextInt();
			
			 for(int i = 0; i <  n*(2 * n - 1); i++){
				 j = sc.nextInt();
				 if(cnt.get(j) == null)
					 cnt.put(j,0);
				cnt.put(j, cnt.get(j)^ 1) ;
			 }
			System.out.print("Case #" + tt + ":");

			 for(int i = 0; i < cnt.size(); i++){
				 if (cnt.get(i) != null && cnt.get(i) > 0)
				 System.out.print(" " + i);
			 }
		}
	}

	
}