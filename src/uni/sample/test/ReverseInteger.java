package uni.sample.test;

import java.util.Arrays;

public class ReverseInteger {
	public static void main(String[] args) {
		ReverseInteger object = new ReverseInteger();
		System.out.println("result:" + object.calculate(123)  + ", expected:321");
		System.out.println("result:" + object.calculate(1234)  + ", expected:4321");
		System.out.println("result:" + object.calculate(12005)  + ", expected:50021");
		System.out.println("result:" + object.calculate(1)  + ", expected:1");
		System.out.println("result:" + object.calculate(1000)  + ", expected:1");
		System.out.println("result:" + object.calculate(0)  + ", expected:0");
		System.out.println("result:" + object.calculate(-12345)  + ", expected:-54321");
			
	}
	public int calculate(int num) {
		int result = 0;
		while(num != 0) {
			int pop = num%10;
			num = num/10;
			if(result == Integer.MAX_VALUE || result == Integer.MAX_VALUE/10 && pop > 8) return 0;
			if(result == Integer.MIN_VALUE || result == Integer.MIN_VALUE/10 && pop < -7) return 0;
			result = result *10 + pop;
		}
		return result;
	}
}
