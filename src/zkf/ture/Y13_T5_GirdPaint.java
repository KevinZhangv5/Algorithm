package zkf.ture;

import java.util.Scanner;

public class Y13_T5_GirdPaint {
	static int[] [] gird;
	static boolean[][] visit = new boolean[1001][1001];
	static int n,sum;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		gird=new int[2][n];
		int total=0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < n; j++) {
				visit[i][j]=true;
				dfs(i,j,1);
				visit[i][j]=false;
				System.out.println("sum:"+sum);
				total+=sum;
				sum=0;
			}
			
		}
		
		System.out.println("total:"+total);
	}
	//提前一步dfs，注意第一步也要标记已经访问
	public static void dfs(int i, int j,int step) {
		if(step==2*n){
//			System.out.println(step);
			sum++;
			return ;
		}
		for(int di=-1;di<=1;di++){
			for(int dj=-1;dj<=1;dj++){
				if((!(di==0&&dj==0))&&0<=i+di&&i+di<2&&0<=j+dj&&j+dj<n&&!visit[i+di][j+dj]){
					visit[i+di][j+dj]=true;
					dfs(i+di,j+dj,step+1);
					visit[i+di][j+dj]=false;
					
				}
			}
		}
	}

}
