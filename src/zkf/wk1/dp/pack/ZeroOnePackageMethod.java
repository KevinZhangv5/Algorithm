package zkf.wk1.dp.pack;

import zkf.util.InputUtil;


public class ZeroOnePackageMethod extends InputUtil {
	static int c[];
	static int v[];
	static int C ;
	public static void main(String[] args) {
		C = scanner.nextInt();
		int n = scanner.nextInt();
		c = new int[n + 1];//容量
		v = new int[n + 1];//价值
		int dp[] = new int[C + 1];
		for (int i = 1; i < n + 1; i++) {
			c[i] = scanner.nextInt();
		}
		for (int i = 1; i < n + 1; i++) {
			v[i] = scanner.nextInt();
		}

		// 状态转移方程
		// dp[i][j]=max{dp[i-1][j],dp[i-1][j-c[i]]+v[i]};
		// 我们可以将原来二维数组表示为一维数据：d(i-1, j-V)变为d(j-V)， d(i-1, j)变为d(j)。当我们要计算d(i, j)时，只需要比较d(j)和d(j-V)+W的大小， 用较大的数更新d(j)即可。等等，如果我要计算d(i, j+1)，而它恰好要用到d(i-1, j)的值， 那么问题就出来了，因为你刚刚才把它更新为d(i, j)了。那么，怎么办呢？ 按照j递减的顺序即可避免这种问题。比如，你计算完d(i, j)， 接下来要计算的是d(i,j-1)，而它的状态转移方程为d(i, j-1)=max{ d(i-1, j-1), d(i-1, j-1-V)+W }，它不会再用到d(i-1,j)的值！所以， 即使该位置的值被更新了也无所谓。
		for (int i = 1; i <= n; i++) {
			ZeroOne(dp,c[i],v[i]);
		}
		System.out.println(dp[C]);
	}

	public static void ZeroOne(int[] dp, int capa,int value) {
		for(int j=C;j>=capa;j--){
			if(dp[j]<dp[j-capa]+value)
				dp[j]=dp[j-capa]+value;
		}
	}

}
