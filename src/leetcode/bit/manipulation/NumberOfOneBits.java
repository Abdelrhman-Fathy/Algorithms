package leetcode.bit.manipulation;

public class NumberOfOneBits {

	public static void main(String[] args) {
		NumberOfOneBits numberOfOneBits = new NumberOfOneBits();

		numberOfOneBits.hammingWeight(00000000000000000000000000001011);
	}

	public int hammingWeight(int n) {
		int bits = 0;
		int mask = 1;
		for (int i = 0; i < 32; i++) {
			if ((n & mask) != 0)
				bits++;
			mask <<= 1;
		}

		return bits;
	}
	
	public int hammingWeight2(int n) {
		int bits = 0;
        while(n != 0){
            bits++;
            n &= (n-1);
        }
        return bits;
	}
}
//https://leetcode.com/problems/number-of-1-bits/