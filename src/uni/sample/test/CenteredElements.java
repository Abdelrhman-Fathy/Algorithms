package uni.sample.test;

public class CenteredElements {
	public static void main(String[] args) {
		CenteredElements object = new CenteredElements();
		System.out.println("result:" + object.isCentered(new int[] {1, 2, 3, 4, 5}) + ", expected:0");
		System.out.println("result:" + object.isCentered(new int[] {3, 2, 1, 4, 5}) + ", expected:1");
		System.out.println("result:" + object.isCentered(new int[] {3, 2, 1, 4, 1}) + ", expected:0");
		System.out.println("result:" + object.isCentered(new int[] {1, 2, 3, 4}) + ", expected:0");
		System.out.println("result:" + object.isCentered(new int[] {}) + ", expected:0");
		System.out.println("result:" + object.isCentered(new int[] {10}) + ", expected:1");
		
	}
	
	public int isCentered(int[] elm){
		if(elm == null || elm.length == 0 || elm.length%2 == 0) return 0;
		int mid = elm.length/2;
		for(int i = 0; i < elm.length; i++) {
			if(i!= mid && elm[i] <= elm[mid]) return 0;
		}
		return 1;
	}
	
	
}
