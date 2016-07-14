package zkf.wk1.dp.pack;

import zkf.util.InputUtil;


public class ZeroOnePackageMethod extends InputUtil {
	static int c[];
	static int v[];
	static int C ;
	public static void main(String[] args) {
		C = scanner.nextInt();
		int n = scanner.nextInt();
		c = new int[n + 1];//����
		v = new int[n + 1];//��ֵ
		int dp[] = new int[C + 1];
		for (int i = 1; i < n + 1; i++) {
			c[i] = scanner.nextInt();
		}
		for (int i = 1; i < n + 1; i++) {
			v[i] = scanner.nextInt();
		}

		// ״̬ת�Ʒ���
		// dp[i][j]=max{dp[i-1][j],dp[i-1][j-c[i]]+v[i]};
		// ���ǿ��Խ�ԭ����ά�����ʾΪһά���ݣ�d(i-1, j-V)��Ϊd(j-V)�� d(i-1, j)��Ϊd(j)��������Ҫ����d(i, j)ʱ��ֻ��Ҫ�Ƚ�d(j)��d(j-V)+W�Ĵ�С�� �ýϴ��������d(j)���ɡ��ȵȣ������Ҫ����d(i, j+1)������ǡ��Ҫ�õ�d(i-1, j)��ֵ�� ��ô����ͳ����ˣ���Ϊ��ողŰ�������Ϊd(i, j)�ˡ���ô����ô���أ� ����j�ݼ���˳�򼴿ɱ����������⡣���磬�������d(i, j)�� ������Ҫ�������d(i,j-1)��������״̬ת�Ʒ���Ϊd(i, j-1)=max{ d(i-1, j-1), d(i-1, j-1-V)+W }�����������õ�d(i-1,j)��ֵ�����ԣ� ��ʹ��λ�õ�ֵ��������Ҳ����ν��
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
