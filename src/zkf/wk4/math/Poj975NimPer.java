package zkf.wk4.math;

import java.util.Scanner;
/**
 * 求可以获胜的移动方案数
 * */
public class Poj975NimPer {
	private static int count = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a[] =new int[1020];
		int xor=0;
		int d = scanner.nextInt();
		for (int i = 0; i <d; i++) {
			a[i]=scanner.nextInt();
			xor^=a[i];
		}
		for (int i = 0; i < d; i++) {
			if(a[i]>(xor^a[i])) count++;
			
		}
		System.out.println(count);
	}

}
