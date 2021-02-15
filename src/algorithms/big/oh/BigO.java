package algorithms.big.oh;

public class BigO {
	public static void main(String[] args) {
		long a = 1, b =100000;
		long start = System.currentTimeMillis();
		long result = multiply1(a, b);
		long end = System.currentTimeMillis();
		System.out.println("result: " + result + ", execution time for o(1) : "+ (end-start));
		
		start = System.currentTimeMillis();
		result = multiplyN(a, b);
		end = System.currentTimeMillis();

		System.out.println("result: " + result + ", execution time for o(N) : "+ (end-start));
		//----n vs n^2

		start = System.currentTimeMillis();
		bigOhofNPow2(b);
		end = System.currentTimeMillis();
		System.out.println("result: " + result + ", execution time for o(N^2) : "+ (end-start));
	}
	
	private static long multiply1(long a, long b) {
		return (long) (a * b);
	}
	
	private static long multiplyN(long a, long b) {
		long result = 0;
		for(int i = 0; i < b; i++) {
			result = result + a;
		}
		return result;
	}
	
	
	private static void bigOhofNPow2(long a) {
		int b = 0;
		for(long i = 0; i < a; i++) {
			for(long j = 0; j < a; j++) {
				b += 0;
			}
		}
	}
	private static void bigOhof2PowN(long a) {
		if(a == 0)
			return;
		//return bigOhof2PowN(a) + bigOhof2PowN(--a);
	}
	
}
