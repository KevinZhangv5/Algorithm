package zkf.suanfarumen;

import java.util.Scanner;
import java.util.Stack;

/**
 * 入栈
 * @author Kevin
 *
 */
public class Ch6_6_1 {
	static int [] target = new int[1000];
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (int i = 1; i <=n; i++) {
			target[i]=scanner.nextInt();
		}
		int a=1,b=1;//a标记入栈的车，按照1-n的顺序入栈，b代表target的下标，若匹配了，再匹配下一个
		boolean flag=true;
		while(b<=n){
			if(a==target[b]){
				a++;b++;
			}else if(!stack.isEmpty()&&stack.peek()==target[b]) {
				b++;stack.pop();
			}else if(a<=n){
				stack.push(a);
				a++;
			}else {
				flag =false;break;//都入栈了，但是还不符合前两种情况（b还没到结束），说明存在不匹配，结束
			}
		}
		System.out.println(flag?"yes":"no");
		
	}

}
