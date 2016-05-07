import java.util.Scanner;

public class CodeJamR1P1 {
	/*cd C:\Users\Abdelrhman\workspace\Tutorial\src\
	javac CodeJamR1P1.java
	C:\Users\Abdelrhman\workspace\Tutorial\src>java CodeJam2016Round1 <C:\Users\Abdelrhman\Desktop\in1.txt> C:\Users\Abdelrhman\Desktop\out1.txt
	*/
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int t = Integer.valueOf(sc.next());
			for (int i = 0; i < t; i++) {
				System.out.println("Case #" + (i + 1) + ": " + solution(sc.next()));
			}
		}

	}

	private static String solution(String str) {
		String orderedStr = "";
		for (int i = 0;i < str.length(); i++){
			char ch = str.charAt(i);
			if(i == 0)
				orderedStr = String.valueOf(ch);
			else {
				if((int)ch >= (int)orderedStr.charAt(0))
					orderedStr = String.valueOf(ch) + orderedStr;
				else
					orderedStr = orderedStr + String.valueOf(ch);
			}
		}
		return orderedStr;
	}
}
