package zkf.wk6.summery;

import java.util.Scanner;

/*
 * ���������n��С��A��B���������Ӻ���ȡ��ÿ���˶����Կ�����һ����ȡ�˶��ٸ���
 * Ҳ���Կ������л�ʣ�¶��ٸ����������˶��ܴ�������������������жϡ� ����Լ���� ÿ���˴Ӻ�����ȡ���������Ŀ�����ǣ�1��3��7����8����
 * �ֵ�ĳһ��ȡ��ʱ������Ȩ�� A��ȡ��Ȼ��˫������ȡ��ֱ��ȡ�ꡣ �����õ����һ�����һ��Ϊ�������䷽��
 * 
 * ����ȷ������˫�������ж�ʧ�������£������ض��ĳ�ʼ������A�Ƿ���Ӯ�� ��������ʱ���ӱ�׼���������ݣ����ʽ���£�
 * ����һ������n(n<100)����ʾ��������n��������Ȼ����n��������ÿ��ռһ�У�����<10000������ʾ��ʼ������
 * ���������n�У���ʾA����Ӯ�������Ϊ0��ӮΪ1���� ���磬�û����룺 4 1 2 10 18 �����Ӧ������� 0 1 1 0
 */
public class TakeBall {
	static int c[] ={1,3,7,8};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		System.out.println(dfs(n));
	}

	private static boolean dfs(int n) {
		if(n==1/*||n==3|n==7*/) return false;
		if(n==8) return true;
		for (int i = 0; i < c.length; i++) {
			if(n-c[i]>=1){
				if(!dfs(n-c[i]))//���ֵıذ�̬�����ҵı�ʤ̬
					return true;
			}
			
		}
		return false;//��û��
		
	}

}
