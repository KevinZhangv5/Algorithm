package zkf.wk1.dp.pack;

import zkf.util.InputUtil;

public class CompletePack extends InputUtil {
	static int capacity[];
	static int value[];

	public static void main(String[] args) {
		int C = scanner.nextInt();
		int n = scanner.nextInt();
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
			for(int j=capacity[i];j<=C;j++){
				if(j>=capacity[i]&&dp[j]<dp[j-capacity[i]]+value[i]){
					dp[j]=dp[j-capacity[i]]+value[i];
				}
			}
		}
		System.out.println(dp[C]);
	}
}
