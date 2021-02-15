package algorithms.backtrack;

public class BackspaceCompare {

	public static void main(String[] args) {
		BackspaceCompare sol = new BackspaceCompare();

		System.out.println("result:" + sol.backspaceCompare("ab#c", "ad#c"));
		System.out.println("result:" + sol.backspaceCompare("abzzz###c", "adz#c"));
		System.out.println("result:" + sol.backspaceCompare("ab##", "c#d#"));
		System.out.println("result:" + sol.backspaceCompare("bxj##tw", "bxo#j##tw"));
		System.out.println("result:" + sol.backspaceCompare("bxj##tw", "bxj###tw"));
	}

	public boolean backspaceCompare(String S, String T) {
		int p1 = S.length() - 1, p2 = T.length() - 1;
		while (p1 >= 0 || p2 >= 0) {
			p1 = backspace(S, p1);
			p2 = backspace(T, p2);
			if (p1 >= 0 && p2 >= 0 && S.charAt(p1) != T.charAt(p2))
				return false;
			if ((p1 >= 0) != (p2 >= 0))
				return false;
			p1--;
			p2--;
		}
		return true;
	}

	int backspace(String s, int p) {
		int skip = 0;
		while (p >= 0) {
			if (s.charAt(p) == '#') {
				skip++;
				p--;
			} else if (skip > 0) {
				skip--;
				p--;
			} else
				break;
		}
		return p;
	}
}
