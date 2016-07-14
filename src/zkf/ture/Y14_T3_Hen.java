package zkf.ture;

import java.util.Arrays;
import java.util.Scanner;

public class Y14_T3_Hen {
	static char[] arr;
	static String str;
	static int num=-1;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		str = scanner.nextLine();
		arr = str.toCharArray();
		Arrays.sort(arr);
		pai(arr,0,arr.length);
	}

	private static void pai(char[] arr, int start, int end) {
		if(start==end){
			num++;
			if(str.equals(new String(arr))){
				System.out.println(num);
				return ;
			}
		}
		for (int i = start; i < end; i++) {
			Arrays.sort(arr,start,end);
			exch(arr,start,i);
			pai(arr,start+1,end);
			
		}
		
	}

	private static void exch(char[] arr, int start, int i) {
		char t =arr[start];arr[start]=arr[i];arr[i]=t;
	}
}
