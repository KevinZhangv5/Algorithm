package zkf.wk5.eulerproject;

import java.math.BigInteger;

public class BingIntDemo {
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			if(new BigInteger(i + "").isProbablePrime(1000)){
				System.out.println(i);
			}
			
		}
		BigInteger.valueOf(2);
	}

}
