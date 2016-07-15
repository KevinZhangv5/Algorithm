package zkf.wk6.summery.test;

import java.util.LinkedList;
import java.util.List;


public class Cantor {
	static int[] fac={1,1,2,6,24,120,720,5040,40320,362880};
	public static void main(String[] args) {
		System.out.println(cantor("2143",4));
		decode(cantor("4312",4),4);
		
	}

	private static int decode(int num, int n) {
		List<Integer> tab = new LinkedList<Integer>();
		List<Integer> res = new LinkedList<Integer>();
		for(int i=0;i<=n;i++){
			tab.add(i);//有i个比本身大的数，这个数是tab[i]
		}
		num--;
		int s,y,beichu=num;
		/*while((y=num%fac[n-1])!=0){
			System.out.println(y);
		}*/
		for(int i=n-1;i>=0;i--){
			y=beichu/fac[i];
			res.add(tab.get(y)+1);
			tab.remove(y);
			beichu=beichu%fac[i];
		}
		System.out.println(res);
		return 0;
	}

	private static int cantor(String s, int n) {
		char[] arr = s.toCharArray();
		int sum=0;
		for (int i = 0; i <n; i++) {
			int t=0;
			for (int j = i+1; j <n; j++) {
				if(arr[j]<arr[i]){
					t++;
				}
			}
			sum+=t*fac[n-i-1];
		}
		return sum+1;
	}

	

}
