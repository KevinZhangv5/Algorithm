package zkf.suanfarumen;

import java.util.Scanner;
import java.util.Stack;

/**
 * ��ջ
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
		int a=1,b=1;//a�����ջ�ĳ�������1-n��˳����ջ��b����target���±꣬��ƥ���ˣ���ƥ����һ��
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
				flag =false;break;//����ջ�ˣ����ǻ�������ǰ���������b��û����������˵�����ڲ�ƥ�䣬����
			}
		}
		System.out.println(flag?"yes":"no");
		
	}

}
