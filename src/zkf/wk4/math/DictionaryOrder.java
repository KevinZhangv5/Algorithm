package zkf.wk4.math;

import java.util.Arrays;
import java.util.Scanner;

import zkf.util.InputUtil;

public class DictionaryOrder extends InputUtil {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] arr = scanner.nextLine().toCharArray();
		Arrays.sort(arr);
		a(arr,0,arr.length);
	}

	private static void a(char[] arr,int from,int to) {
		if(from+1==to){
			for (char c : arr) {
				System.out.print(c);
			}
			System.out.println();
		}
		for(int i=from;i<to;i++){
			Arrays.sort(arr,from,to);
			swap(arr,i,from);
			a(arr,from+1,to);
			swap(arr, i, from);
		}
		
	}
	public static void swap(char[] arr, int i,int j){
		char t=arr[i]; arr[i]=arr[j];arr[j]= t;
	}

}
