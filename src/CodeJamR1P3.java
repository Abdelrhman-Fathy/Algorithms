import java.util.Scanner;

public class CodeJamR1P3 {
	private static Scanner sc = new Scanner(System.in);
	static int i, j, k, m, n, l;
	static int[] cnt = new int[2501];
	
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
			 for(i = 0; i < 2500; i++){
				 cnt[i] = 0;
			 }
			 for(int i = 0; i <  n*(2 * n - 1); i++){
				 j = sc.nextInt();
				cnt[j] ^= 1;
			 }
			System.out.print("Case #" + tt + ":");

			 for(int i = 1; i < 2500; i++){
				 if (cnt[i] > 0)
				 System.out.print(" " + i);
			 }
		}
	}

	
}
