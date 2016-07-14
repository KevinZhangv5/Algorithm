package zkf.wk1.dp.pack;

import zkf.util.InputUtil;

public class MultiplePack extends InputUtil {
	static int capacity[];
	static int value[];
	static int num[];
	static int C;
	static int n;

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
		for (int i = 1; i < n + 1; i++) {
			num[i] = scanner.nextInt();
		}

		for (int i = 1; i <= n; i++) {
			multiple(dp, capacity[i], value[i], num[i]);
		}
		System.out.println(dp[C]);
	}

	public static void multiple(int[] dp, int cap, int val, int num) {
		if(num*cap>C){
			CompletePackMethod.complete(dp, cap, val);
		}else{
			int k=1;
			while(k<num){
				ZeroOnePackageMethod.ZeroOne(dp, k*cap, k*val);
				num-=k;
				k*=2;
			}
			ZeroOnePackageMethod.ZeroOne(dp, num*cap, num*val);
		}

	}
}
