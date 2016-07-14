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

		// ״̬ת�Ʒ���
		// dp[i][j]=max{dp[i-1][j],dp[i-1][j-c[i]+v[i]};
		// ˼��ʱi��i-1������i-1��i����ǰi����Ʒ��ǰi-1����Ʒ�����ٵ�i�ţ�����ã���������������Ӧ��ֵ��������ã�j����
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
