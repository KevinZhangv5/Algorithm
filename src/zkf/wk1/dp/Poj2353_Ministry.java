package zkf.wk1.dp;

import zkf.util.InputUtil;

public class Poj2353_Ministry extends InputUtil{
	public static void main(String[] args) {
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		
		int [][] v = new int[m+1][n+1];
		int [][] road = new int[m+1][n+1];
		int [][] dp = new int[m+1][n+1];
		for (int i = 1; i < v.length; i++) {
			for (int j = 1; j < v[i].length; j++) {
				v[i][j]=scanner.nextInt();
			}
		}
		
		//开始填表
		for (int j = 1; j <= n; j++) {
			dp[m][j]=v[m][j];
		}
		
		for(int i=m-1;i>=1;i--){
			for (int j = 1; j <= n; j++) {
				dp[i][j]=dp[i+1][j]+v[i][j];
				road[i][j]=j;
				if(j>1&&(dp[i][j-1]+v[i][j]<dp[i][j])){
					dp[i][j]=dp[i][j-1]+v[i][j];
					road[i][j]=j-1;
				}
			}
			
			for (int j = n-1; j >=1;j--) {
				if(dp[i][j+1]+v[i][j]<dp[i][j]){
					dp[i][j]=dp[i][j+1]+v[i][j];
					road[i][j]=j+1;
				}
			}
		}
		printArr(dp, 1, 1);
		
		printArr(road, 0,0);
		//打印
		int r=1;
		for (int i = 2; i <= n; i++) {
			int min=dp[1][1];
			if(dp[1][i]<min){
				min=dp[1][i];
				r=i;
			}
		}
		int i = 1;
		System.out.println(r);//第一个
		for(;;){//先进入再打印：最后一行；先打印再进入，倒数第二行。
			//两种情况，一种下一行，一种是结束
			if(road[i][r]==r){
				System.out.println(road[i][r]);
				if(i+1>=m) break;
				i++;
			}else {
				System.out.println(road[i][r]);
				r=road[i][r];
			}
		}
		System.out.println(Float.MAX_VALUE);
		
		
		
		
		
		
		/*for(;;){
			if(road[i][r]!=r){
				System.out.println(r);
				r=road[i][r];
			}else{
				if(i+1<=m+1)  i++;
				else break;
			}
		}*/
	}

}


