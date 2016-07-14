package zkf.suanfarumen;

import zkf.util.InputUtil;

public class P36SnakeShape extends InputUtil{
	static int[][] a= new int[6][6];
	public static void main(String[] args) {
		int n=4;
		int i=0,j=0,num1 = 0;
		int num=1;
		a[i][j]=num++;
		/*while((num1!=num)){
			num1=num;
			while(j+1<n&&a[i][j+1]==0){
				a[i][j++]=num++;
			}
			while(i+1<n&&a[i+1][j]==0){
				a[++i][j]=num++;
			}
			while(j+1>0&&a[i][j-1]==0){
				a[i][--j]=num++;
			}
			while(i+1>0&&a[i][j]==0){
				a[i--][j]=num++;
			}
		}*/
		while((num<n*n)){
			while(j+1<n&&a[i][j+1]==0){
				a[i][++j]=num++;
			}
			while(i+1<n&&a[i+1][j]==0){
				a[++i][j]=num++;
			}
			while(j-1>=0&&a[i][j-1]==0){
				a[i][--j]=num++;
			}
			while(i-1>=0&&a[i-1][j]==0){
				a[--i][j]=num++;
			}
			
		}
		for (int k = 0; k < n; k++) {
			for (int l = 0; l < n; l++) {
				System.out.print(a[k][l]+"\t"); 
			}
			System.out.println();
			
		}
//		printArr(a, 0,0);
	}

}
