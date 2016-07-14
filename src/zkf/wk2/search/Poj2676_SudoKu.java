package zkf.wk2.search;

import java.io.IOException;
import java.util.Scanner;

public class Poj2676_SudoKu{
	static int[][] a = new int[9][9];
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int times = scanner.nextInt();
		scanner.nextLine();
		for(int t =0;t<times;t++){
			a=new int[9][9];
			for(int i=0;i<9;i++){
				char[] arr = scanner.nextLine().toCharArray();
				for(int j=0;j<9;j++){
					a[i][j]=arr[j]-'0';
				}
			}
			if(dfs(80))
				printArr(a);
		}

	}
	
	private static void printArr(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(a[i][j]);
				
			}
			System.out.println();
			
		}
	}

	public static boolean dfs(int pos) {
		if(pos<0)
			return true;
		int y = pos/9;
		int x = pos%9;
		if(a[x][y]!=0)
			return dfs(pos-1);
		for(int d=1;d<10;d++){
			a[x][y]=d;
			if(checkGird(x,y)&&checkXY(x,y)){
//				return dfs(pos-1);
				if(dfs(pos-1))
					return true;
			}
			a[x][y]=0;
		}
		return false;
		
	}
	private static boolean checkXY(int x, int y) {
		int cur=a[x][y];
		for(int i=0;i<9;i++){
			if(i==x) 
				continue;
			if(a[i][y]==cur) return false;
		}
		for(int j=0;j<9;j++){
			if(j==y) 
				continue;
			if(a[x][j]==cur) return false;
		}
		return true;
	}
	private static boolean checkGird(int x, int y) {
		int strx=(x/3)*3;
		int stry=(y/3)*3;
		int cur=a[x][y];
		for (int i = strx; i < strx + 3; i++) {
			for (int j = stry; j < stry + 3; j++) {
				if (i == x && j == y)
					continue;
				if (a[i][j] == cur) {
					return false;
				}
			}
		}
		return true;
	}
	

	}
