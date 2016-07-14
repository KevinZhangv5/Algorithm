package zkf.util;

import java.util.Scanner;

public class InputUtil {
	protected static Scanner scanner;
	static {
		scanner = new Scanner(System.in);
	}

	public static void printArr(int[][] a, int startHang, int startLie) {
		for (int i = startHang; i < a.length; i++) {
			for (int j = startLie; j < a[i].length; j++) {
				System.out.print(a[i][j] + "   ");
			}
			System.out.println();
		}
	}

	public static void printArr(int[] a, int startHang) {
		for (int i = startHang; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

}
