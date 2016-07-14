package zkf.wk4.math;

import java.util.Scanner;
// Wrong answer?
public class Poj1503Code {
	static int[][] ct=new int[27][27];
	public static void main(String[] args) {
//		System.out.println(c(1320,0));
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		int sum=0;
		for (int i = 1; i < str.length(); i++) {
			sum+=c(26,i);
		}
//		System.out.println(sum+1);
		char[] strarr = str.toCharArray();
		for (int i = 0; i < strarr.length; i++) {
			char ch=(char) ((i==0)?'a':strarr[i-1]+1);
			while(ch<strarr[i]){
				sum+=c('z'-ch,strarr.length-i-1);
				ch++;
			}
		}
		System.out.println(sum+1);
	}
	/**
	 * 求组合数
	 * @param i
	 * @param j
	 * @return
	 */
	public static int c(int i, int j) {
		if(j>i) return 0;
		if(j==0) return 1;
		if(j==1) return i;
		if(i==j) return 1;
		if(ct[i][j]!=0) return ct[i][j];
		if(ct[i-1][j-1]==0)
			ct[i-1][j-1]=c(i-1,j-1);
		if(ct[i-1][j]==0)
			ct[i-1][j]=c(i-1,j);
		return ct[i-1][j-1]+ct[i-1][j];
	}

}
