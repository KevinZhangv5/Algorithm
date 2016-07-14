package zkf.wk2.search;


import java.util.Scanner;

public class Poj1129Cut {
	/* 四色图定理剪枝 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i, j;

		int n;
		while ((n = sc.nextInt()) > 0) {

			Point[] node = new Point[n + 1]; // 结点

			for (i = 1; i <= n; i++) {

				if (null == node[i]) // 初始化
					node[i] = new Point();
				node[i].pn = 0;

				String ch = sc.next();
				ch = ch.substring(2);
				char[] cs = ch.toCharArray();
				for (int l = 0; l < cs.length; l++) {
					j = cs[l] - ('A' - 1); // 把结点字母转换为相应的数字，如A->1 C->3
					node[i].next[++node[i].pn] = j;

				}

			}

			int color[] = new int[27]; // color[i]为第i个结点当前染的颜色，0为无色（无染色）
			color[1] = 1; // 结点A初始化染第1种色
			int maxcolor = 1; // 当前已使用不同颜色的种数

			for (i = 1; i <= n; i++){ // 枚举每个顶点
			
				color[i] = n + 1; // 先假设结点i染最大的颜色
				boolean vist[] = new boolean[27]; // 标记第i种颜色是否在当前结点的相邻结点染过
				for (j = 1; j <= node[i].pn; j++){ // 枚举顶点i的所有后继
					int k = node[i].next[j];
					if (color[k] != 0) // 顶点i的第j个直接后继已染色
						vist[color[k]] = true; // 标记该种颜色
				}
				for (j = 1; j <= n; j++)
					// 从最小的颜色开始，枚举每种颜色，最终确定结点i的染色
					if (!vist[j] && color[i] > j) {
						color[i] = j;
						break;
					}

				if (maxcolor < color[i]) {
					maxcolor = color[i];
					if (maxcolor == 4) // 由四色定理知，最终完成染色后，图上最多只有四种颜色
						break; // 因此当染色过程出现结点的颜色为4时，就可以断定最少要用4种颜色染色
				}
			}

			if (maxcolor == 1)
				System.out.println("1 channel needed.");
			else
				System.out.println(maxcolor + " channels needed.");
		}
	}

}
