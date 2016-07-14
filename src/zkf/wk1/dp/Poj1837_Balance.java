package zkf.wk1.dp;

import zkf.util.InputUtil;

public class Poj1837_Balance extends InputUtil {
	public static void main(String[] args) {
		int c=scanner.nextInt();//钩子数
		int g = scanner.nextInt();//砝码个数
		
		int gloca[] = new int[c];//第i个钩子位置
		int goumaz[] = new int[g+1];//第i个钩码的重量
		int dp[][] = new int[20][15000];
		for(int i=0;i<c;i++){
			gloca[i]=scanner.nextInt();
		}
		for(int i=1;i<g+1;i++){
			goumaz[i]=scanner.nextInt();
		}
		//没有砝码
		dp[0][7500]=1;
		for (int i = 1; i <=g; i++) {
			for(int j =0 ;j<15000;j++){
				if(dp[i-1][j]!=0){
					for(int a=0;a<c;a++){
						dp[i][j+goumaz[i]*gloca[a]]+=dp[i-1][j];
					}
				}
			}
			
		}
		System.out.println(dp[g][7500]);
		
		
		
	}

}
