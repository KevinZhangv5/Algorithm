package zkf.wk1.dp.pack;

import java.util.Scanner;

import zkf.util.InputUtil;

public class Poj1276_CashMachine extends InputUtil {
	static int need;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		cash N n1 D1 n2 D2 ... nN DN 
		need = scanner.nextInt();
		int kind = scanner.nextInt();
		int capacity[] = new int[kind+1];
		int num[] = new int[kind+1];
		int dp[]  = new int[need+1];
		
		for(int  i=1;i<=kind;i++){
			capacity[i]=scanner.nextInt();
			num[i]=scanner.nextInt();
		}
		
		for (int i = 1; i <=kind; i++) {
			multiple(dp, capacity[i], capacity[i], num[i]);
		}
		System.out.println(dp[need]);
		
	}
	public static void multiple(int[] dp, int cap, int val, int num) {
		if(num*cap>=need){
			complete(dp, cap, val);
		}else{
			int k=1;
			while(k<num){
				zeroOne(dp, k*cap, k*val);
				num-=k;
				k*=2;
			}
			zeroOne(dp, num*cap, num*val);
		}

	}
	public static void complete(int [] dp,int capa, int val) {
		for(int j=capa;j<=need;j++){
			if(dp[j]<dp[j-capa]+val)
				dp[j]=dp[j-capa]+val;
		}
	}
	public static void zeroOne(int[] dp, int capa,int value) {
		for(int j=need;j>=capa;j--){
			if(dp[j]<dp[j-capa]+value)
				dp[j]=dp[j-capa]+value;
		}
	}

}
