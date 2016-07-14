package zkf.wk4.math;

import java.util.Random;

public class MillerRabinTest {
	public static boolean isPrime(int n){
		//n-1=2^k*m,random d;v=b^m%n;judge v
		int k=0,m;
		if(n<2) return false;
		if(n==2) return true;
		if(n%2==0) return false; 
		m= n-1;//m-1ÊÇÅ¼Êý
		while((m%2)==0){ m=m/2; k++; }
		int b,v;
		Random random = new Random();
		for(int i = 0;i<10;i++){
			b = random.nextInt(n-2)+2;
			b=((int) (Math.pow(b, m))%n);
//			b=modExp(b,m,n);
			if(b==1) continue;
			int j;
			for (j = 0; j < k; j++) {
				if(b==n-1) break;
				b=b*b%n;
			}
			if(j<k)
				continue;
			else 
				return false;
		}
		return true;
	}
	/*private static int modExp(int b, int m, int n) {
		int sum=1;
		for(int i=0;i<m;i++){
			sum*=b;
		}
		return sum%n;
	}*/
	public static void main(String[] args) {
		/*for (int i = 0; i < 100; i++) {
			if(MillerRabinTest.isPrime(i))
				System.out.println(i);
			
		}*/
		System.out.println(MillerRabinTest.isPrime(19));;
	}

}
