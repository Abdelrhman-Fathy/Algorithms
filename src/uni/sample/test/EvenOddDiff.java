package uni.sample.test;

public class EvenOddDiff {

	public static void main(String[] args) {
		EvenOddDiff object = new EvenOddDiff();
		System.out.println("result:" + object.calculate(new int[] {1}) + ", expected:1");
		System.out.println("result:" + object.calculate(new int[] {1, 2}) + ", expected:-1");
		System.out.println("result:" + object.calculate(new int[] {1, 2, 3}) + ", expected:2");
		System.out.println("result:" + object.calculate(new int[] {1, 2, 3, 4}) + ", expected:-2");
		System.out.println("result:" + object.calculate(new int[] {3, 3, 4, 4}) + ", expected:-2");
		System.out.println("result:" + object.calculate(new int[] {3, 2, 3, 4}) + ", expected:0");
		System.out.println("result:" + object.calculate(new int[] {4, 1, 2, 3}) + ", expected:-2");
		System.out.println("result:" + object.calculate(new int[] {1, 1}) + ", expected:2");
		System.out.println("result:" + object.calculate(new int[] {}) + ", expected:0");
	}
	public int calculate(int[] arr) {
		int result = 0;
		if(arr == null || arr.length == 0) return result;
		for(int x : arr) {
			if(x%2 == 0) result -=x;
			else result +=x;
		}
		return result;
	}

}
