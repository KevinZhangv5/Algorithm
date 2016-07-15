package zkf.wk5.eulerproject;

import java.math.BigInteger;

public class Problem16Sum {
	public static void main(String[] args) {
		BigInteger int2 = new BigInteger("2");
		BigInteger res = int2.pow(1000);
//		int resint = res.intValue();
		System.out.println(res);
//		res.isProbablePrime(10);
		res.remainder(BigInteger.valueOf(1));
		res.mod(BigInteger.valueOf(1));
		
	}

}
