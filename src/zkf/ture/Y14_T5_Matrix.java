package zkf.ture;

import java.util.Scanner;

public class Y14_T5_Matrix {
	static int [] h;
	static int [] l;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		h=new int[n+1];
		l=new int[n+1];
		for (int i = 0; i < n; i++) {
				int hin=scanner.nextInt();
				int lin=scanner.nextInt();
				h[hin]=lin;
				l[lin]=hin;
		}
		if(isTrue()){
			System.out.println(1);
		}
		for (int k = 2; k < 1000; k++) {
			
		}
		
	}
	public static boolean isTrue() {
		
		return false;
	}

}
