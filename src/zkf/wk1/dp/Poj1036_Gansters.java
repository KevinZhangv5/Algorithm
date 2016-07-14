package zkf.wk1.dp;

import zkf.util.InputUtil;

public class Poj1036_Gansters extends InputUtil{

	public static void main(String[] args) {
		int n=scanner.nextInt(),k=scanner.nextInt(),tn=scanner.nextInt();
		int[] t = new int[n];
		int[] p = new int[n];
		int[] stout = new int[n];
		for(int i=0;i<n;i++){
			t[i]=scanner.nextInt();
		}
		for(int i=0;i<n;i++) p[i]=scanner.nextInt();
		for(int i=0;i<n;i++) stout[i]=scanner.nextInt();
		
		int dp[][] = new int[tn][k+1];
		
	}

}
