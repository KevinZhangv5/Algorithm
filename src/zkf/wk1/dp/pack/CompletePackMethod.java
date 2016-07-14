package zkf.wk1.dp.pack;

import zkf.util.InputUtil;

public class CompletePackMethod extends InputUtil {
	static int capacity[];
	static int value[];
	static int C;
	static int n ;

	public static void main(String[] args) {
		C = scanner.nextInt();
		n = scanner.nextInt();
		capacity = new int[n + 1];// »›¡ø
		value = new int[n + 1];// º€÷µ
		int dp[] = new int[C + 1];
		for (int i = 1; i < n + 1; i++) {
			capacity[i] = scanner.nextInt();
		}
		for (int i = 1; i < n + 1; i++) {
			value[i] = scanner.nextInt();
		}
		
		for(int i=1;i<=n;i++){
			complete(dp,capacity[i],value[i]);
		}
		System.out.println(dp[C]);
	}

	public static void complete(int [] dp,int capa, int val) {
		for(int j=capa;j<=C;j++){
			if(dp[j]<dp[j-capa]+val)
				dp[j]=dp[j-capa]+val;
		}
	}
}
