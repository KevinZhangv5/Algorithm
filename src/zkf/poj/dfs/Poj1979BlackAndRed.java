package zkf.poj.dfs;

import java.util.Scanner;

public class Poj1979BlackAndRed {
	static char[][] t=new char[21][21];
	static int count=0;
	static int[] x={0,0,1,-1};
	static int[] y={1,-1,0,0};
	static int sumj;
	static int sumi;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		sumj = scanner.nextInt();//x
		sumi = scanner.nextInt();//y
		while(sumi!=0&&sumj!=0){
			scanner.nextLine();
			int startj = 0,starti=0;
			for (int i = 0; i < sumi; i++) {
				String s= scanner.nextLine();
				char[] arr = s.toCharArray();
				for (int j = 0; j < sumj; j++) {
					if(arr[j]=='@'){
						starti=i;startj=j;
					}
					t[i][j]=arr[j];
				}
			}
			for (int i = 0; i < t.length; i++) {
				for (int j = 0; j < t[i].length; j++) {
					System.out.println(t[i][j]);
				}
			}
			dfs(starti,startj);
			System.out.println(count);
			t=new char[20][20];
			count=0;
			sumj = scanner.nextInt();
			sumi = scanner.nextInt();
		}

	}
	/*private static void dfs(int i, int j) {
		for(int a=0;a<x.length;a++){
			for(int b=0;b<y.length;b++){
				if(0<=i+x[a]&&i+x[a]<sumi&&0<=j+y[b]&&j+y[b]<sumj&&t[i+x[a]][j+y[b]]=='.'){
					count++;
					t[i+x[a]][j+y[b]]='#';
					dfs(i+x[a],j+y[b]);
				}
			}
		}
	}*/
	/*private static void dfs(int i,int j) {
		for(int a=0;a<x.length;a++){
			for(int b=0;b<y.length;b++){
				if(0<=i+x[a]&&i+x[a]<20&&0<=j+y[b]&&j+y[b]<20&&t[i+x[a]][j+y[b]]=='.'){
					dfs(i+x[a],j+y[b]);
				}
			}
			return;
		}
	}*/
	private static void dfs(int i,int j){
		if(i<0||i>sumi-1||j<0||j>sumj-1||t[i][j]=='#')
			return ;
		count++;
		t[i][j]='#';
		dfs(i,j+1);
		dfs(i,j-1);
		dfs(i-1,j);
		dfs(i+1,j);
		
	}
}
