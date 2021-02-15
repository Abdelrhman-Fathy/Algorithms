package oa.zalando;

import java.util.Arrays;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

public class Solution {
	public static void main(String[] args) {
		
		long interval = 300000l;
		//System.out.println(1579354805011l + 5* 1000000000000l);
		
		long time  = System.currentTimeMillis() + interval;
		for(int i = 0; i < 10; i++) {
			System.out.println(time + i*interval);
		}
		
		
		
		
	}
	
	

}
