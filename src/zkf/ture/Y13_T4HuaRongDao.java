package zkf.ture;

import java.util.Scanner;

public class Y13_T4HuaRongDao {
	static int[][] a=new int[3][3];
	static int[][] b=new int[3][3];
	static int starti,startj,res;
	static int targeti,targetj;
	static int dx[]={0,0,-1,1};
	static int dy[]={-1,1,0,0};
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] arr1 = scanner.nextLine().toCharArray();
		char[] arr2 = scanner.nextLine().toCharArray();
		for (int i = 0; i < arr1.length; i++) {
			int x=i/3;
			int y=i%3;
			if(arr1[i]=='.'){
				starti=x;startj=y;
			}else {
				a[x][y]=arr1[i]-'0';
			}
			
			if(arr2[i]=='.'){
				targeti=x;targetj=y;
			}else {
				b[x][y]=arr2[i]-'0';
			}
		}
		dfs(starti,startj,0,-1,-1);
		System.out.println(res);
		/*for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[i][j]+"  ");
			}
			System.out.println();
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(b[i][j]+"  ");
			}
			System.out.println();
		}*/
	}
	private static void dfs(int i, int j,int step,int pi,int pj) {
		if(i==targeti&&j==targetj){
			if(ju()){
				if(res==0||step<res){
					res=step;
				 	return ;
				}
			}
		}
		if(step>25) return;
		for (int x = 0; x <= 3; x++) {
			int ni = i + dx[x];
			int nj = j + dy[x];
			if (0 <= ni && ni < 3 && 0 <= nj && nj < 3 && ni != pi && nj != pj) {
				exch(a, i, j, ni, nj);
				dfs(ni, nj, step + 1, i, j);
				exch(a, i, j, ni, nj);

			}
		}
	}
	private static void exch(int[][] a, int i, int j, int ni, int nj) {
		int t=a[i][j];a[i][j]=a[ni][nj];a[ni][nj]=t;
	}
	private static boolean ju() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(a[i][j]!=b[i][j])
					return false;
			}
			
		}
		return true;
	}

}
