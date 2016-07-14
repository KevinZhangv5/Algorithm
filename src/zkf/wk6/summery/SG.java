package zkf.wk6.summery;

import java.util.HashSet;

public class SG {
	static int [] sg = new int[1024];
	public static void get(int [] arr,int n){
		sg[0]=0;
		for (int i = 1; i <=n; i++) {
			int [] hash = new int[1024];
			for (int j = 0; j < arr.length; j++) {
				if(i<arr[j]) break;
				hash[sg[i-arr[j]]]=1;
			}
			int g=0;
			for(int j=0;j<=n;j++){
				if(hash[j]!=1){
					sg[i]=j;
					break;
				}
			}
		}
		
	}
	public static void main(String[] args) {
		int a[] = new int[]{1,3,7,8};
		int n=18;
		SG.get(a, n);
		System.out.println(sg[n]);
		boolean f= (1^sg[n])==0;
		System.out.println(f);
	}

}
