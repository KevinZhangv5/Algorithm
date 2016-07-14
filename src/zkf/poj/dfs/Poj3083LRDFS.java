package zkf.poj.dfs;

import java.util.Scanner;


public class Poj3083LRDFS {
	static int sumi,sumj,starti,startj,endi,endj;
	static char [][] maps;
	static int[] dt={1,0,3,2};
	static int d1[][]={{-1,0},{0,-1},{1,0},{0,1}};
	static int count;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		sumj=scanner.nextInt();
		sumi=scanner.nextInt();
		maps=new char[sumi][sumj];
		scanner.nextLine();
		for (int i = 0; i < sumi; i++) {
			String s = scanner.nextLine();
			char[] arr=s.toCharArray();
			for(int j=0;j<sumj;j++){
				if(arr[j]=='S'){
					starti=i;startj=j;
				}
				if(arr[j]=='E'){
					endi=i;endj=j;
				}
				maps[i][j]=arr[j];
			}

		}
		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps[i].length; j++) {
				System.out.print((char)maps[i][j]);
				
			}
			System.out.println();
		}
		dfs1(starti,startj,0,0);
		System.out.println(count);
	}
	/*private static boolean dfs1(int i, int j,int d,int step) {
		if(i>sumi-1||j>sumj-1||i<0||j<0||maps[i][j]=='#') return false;
		if(maps[i][j]=='E'||(i==endi&&j==endj)){ 
			count=step;
			return true;
		}
//		int index=find(d);
		for (int k = 0; k <=3; k++) {
			d=(d+1)%4;
			int nx=i+d1[dt[d]][0];
			int ny=j+d1[dt[d]][1];
			if(dfs1(nx,ny,d,step+1)){
				return true;
			}
		}
		return false;
		
	}*/
	
	private static boolean dfs1(int i, int j,int d,int step) {
		if(i>sumi-1||j>sumj-1||i<0||j<0||maps[i][j]=='#') return false;
		if(maps[i][j]=='E'||(i==endi&&j==endj)){ 
			count=step;
			return true;
		}
		int index=find(d+1);
		for (int k = 0; k <=3; k++) {
			int nx=i+d1[dt[index]][0];
			int ny=j+d1[dt[index]][1];
			if(dfs1(nx,ny,dt[index],step+1)){
				return true;
			}
			index=(index+1)%4;
		}
		return false;
	}

	private static int find(int d) {
		for(int i=0;i<4;i++){
			if(dt[i]==d)
				return i;
		}
		return -1;
	}
}
