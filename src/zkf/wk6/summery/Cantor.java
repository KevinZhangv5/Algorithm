package zkf.wk6.summery;

import java.util.ArrayList;
import java.util.Arrays;

public class Cantor {
	static int[] fac={1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
	public static int code(int[] s){
		int sum=0;
		for (int i = 0; i < s.length; i++) {
			int t=0;
			for (int j = i+1; j < s.length; j++) {
				if(s[i]>s[j]){
					t++;
				}
			}
			sum+=fac[s.length-i-1]*t;
		}
		return sum;
		
		
	}
	public static Object[] decode(int num,int length){
		ArrayList<Integer> list = new ArrayList<Integer>();//比i小的数有list[i]个
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = 1; i < 20; i++) {
//			list.add(i, i-1);
			list.add(i-1);
		}
		for(int i=length-1;i>=0;i--){
			int index=num/fac[i];
			num=num%fac[i];
			res.add(list.get(index)+1);
			list.remove(index);
			
		}
		return res.toArray();
		
	}
	public static void main(String[] args) {
		int a[]={3,1,2,5,4};
		/*System.out.println(code(a));
		Object[] decode = decode(49,5);
		for (Object object : decode) {
			System.out.print(object);
		}*/
		System.out.println(Arrays.hashCode(a));
		
		
	}

}
