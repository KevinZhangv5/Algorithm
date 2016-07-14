package zkf.wk6.summery;

import java.util.Scanner;

/*
 * 今盒子里有n个小球，A、B两人轮流从盒中取球，每个人都可以看到另一个人取了多少个，
 * 也可以看到盒中还剩下多少个，并且两人都很聪明，不会做出错误的判断。 我们约定： 每个人从盒子中取出的球的数目必须是：1，3，7或者8个。
 * 轮到某一方取球时不能弃权！ A先取球，然后双方交替取球，直到取完。 被迫拿到最后一个球的一方为负方（输方）
 * 
 * 请编程确定出在双方都不判断失误的情况下，对于特定的初始球数，A是否能赢？ 程序运行时，从标准输入获得数据，其格式如下：
 * 先是一个整数n(n<100)，表示接下来有n个整数。然后是n个整数，每个占一行（整数<10000），表示初始球数。
 * 程序则输出n行，表示A的输赢情况（输为0，赢为1）。 例如，用户输入： 4 1 2 10 18 则程序应该输出： 0 1 1 0
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
				if(!dfs(n-c[i]))//对手的必败态就是我的必胜态
					return true;
			}
			
		}
		return false;//我没有
		
	}

}
