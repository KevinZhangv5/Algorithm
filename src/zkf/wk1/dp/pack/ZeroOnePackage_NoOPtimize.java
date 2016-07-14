package zkf.wk1.dp.pack;

import zkf.util.InputUtil;

public class ZeroOnePackage_NoOPtimize extends InputUtil {
	
	public static void main(String[] args) {
		int C = scanner.nextInt();
		int n = scanner.nextInt();
		int c[] = new int[n + 1];
		int v[] = new int[n + 1];
		int dp[][] = new int[n + 1][C + 1];
		for (int i = 1; i < n + 1; i++) {
			c[i] = scanner.nextInt();
		}
		for (int i = 1; i < n + 1; i++) {
			v[i] = scanner.nextInt();
		}

		// 状态转移方程
		// dp[i][j]=max{dp[i-1][j],dp[i-1][j-c[i]+v[i]};
		// 思考时i向i-1，计算i-1到i。从前i件物品到前i-1件物品，面临第i号，如果拿，背包容量减少相应的值，如果不拿，j不变
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= C; j++) {
				dp[i][j] = dp[i - 1][j];
				if (c[i] <= j && dp[i - 1][j - c[i]] + v[i] > dp[i][j]) {
					dp[i][j] = dp[i - 1][j - c[i]] + v[i];
				}
			}
		}
		System.out.println(dp[n][C]);
	}

}
