package zkf.wk4.math;

import java.util.Scanner;
/**
 * ����Ի�ʤ���ƶ�������
 * */

import javax.swing.text.AbstractDocument.BranchElement;

/**
 * ����Ի�ʤ���ƶ�������TLE
 * */
public class Poj975Nim {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a[] = new int[1020];
		int d;
		while ((d = scanner.nextInt()) != 0) {
			int xor = 0;
			for (int i = 0; i < d; i++) {
				a[i] = scanner.nextInt();
				xor ^= a[i];
			}
			if (xor == 0) {
				System.out.println("0");
			} else {
				int count = 0;
				 for (int i = 0; i < d; i++) {// ��i��
					label1:
					for (int k = 1; k <= a[i]; k++) {// �ڵ�i ����ȡk��
						int sum = 0;
						sum ^= a[i] - k;
						for (int j = 0; j < d; j++) {
							if (j != i) {
								sum ^= a[j];// ���������
							}
						}
						if (sum == 0){
							count++;// �ذ�
							break label1;
						}

					}
				}
				System.out.println(count);
			}
		}
	}

}
