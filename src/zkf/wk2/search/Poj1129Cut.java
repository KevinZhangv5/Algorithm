package zkf.wk2.search;


import java.util.Scanner;

public class Poj1129Cut {
	/* ��ɫͼ�����֦ */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i, j;

		int n;
		while ((n = sc.nextInt()) > 0) {

			Point[] node = new Point[n + 1]; // ���

			for (i = 1; i <= n; i++) {

				if (null == node[i]) // ��ʼ��
					node[i] = new Point();
				node[i].pn = 0;

				String ch = sc.next();
				ch = ch.substring(2);
				char[] cs = ch.toCharArray();
				for (int l = 0; l < cs.length; l++) {
					j = cs[l] - ('A' - 1); // �ѽ����ĸת��Ϊ��Ӧ�����֣���A->1 C->3
					node[i].next[++node[i].pn] = j;

				}

			}

			int color[] = new int[27]; // color[i]Ϊ��i����㵱ǰȾ����ɫ��0Ϊ��ɫ����Ⱦɫ��
			color[1] = 1; // ���A��ʼ��Ⱦ��1��ɫ
			int maxcolor = 1; // ��ǰ��ʹ�ò�ͬ��ɫ������

			for (i = 1; i <= n; i++){ // ö��ÿ������
			
				color[i] = n + 1; // �ȼ�����iȾ������ɫ
				boolean vist[] = new boolean[27]; // ��ǵ�i����ɫ�Ƿ��ڵ�ǰ�������ڽ��Ⱦ��
				for (j = 1; j <= node[i].pn; j++){ // ö�ٶ���i�����к��
					int k = node[i].next[j];
					if (color[k] != 0) // ����i�ĵ�j��ֱ�Ӻ����Ⱦɫ
						vist[color[k]] = true; // ��Ǹ�����ɫ
				}
				for (j = 1; j <= n; j++)
					// ����С����ɫ��ʼ��ö��ÿ����ɫ������ȷ�����i��Ⱦɫ
					if (!vist[j] && color[i] > j) {
						color[i] = j;
						break;
					}

				if (maxcolor < color[i]) {
					maxcolor = color[i];
					if (maxcolor == 4) // ����ɫ����֪���������Ⱦɫ��ͼ�����ֻ��������ɫ
						break; // ��˵�Ⱦɫ���̳��ֽ�����ɫΪ4ʱ���Ϳ��Զ϶�����Ҫ��4����ɫȾɫ
				}
			}

			if (maxcolor == 1)
				System.out.println("1 channel needed.");
			else
				System.out.println(maxcolor + " channels needed.");
		}
	}

}
