package zkf.ture;


public class Y15_T2_A_HuanFang {
	static int[][] a =new int[4][4];
	static int  num;
	static boolean visit[] = new boolean[17];
	public static void main(String[] args) {
		a[0][0]=1;
		visit[1]=true;
		dfs(0,0);
		System.out.println(num);
	}
	public static void dfs(int i,int j) {
		if(i==1&&j==0){
			if(!checkLine(0)) return ;
		}
		if(i==2&&j==0){
			if(!checkLine(1)) return ;
		}
		if(i==3&&j==0){
			if(!checkLine(2)) return ;
		}
		if(i==3&&j==1){
			if(!checkS(1)) return ;
		}
		if(i==3&&j==2){
			if(!checkS(2)) return ;
		}
		if(i==3&&j==3){
			if(!checkLine(3)) return ;
			if(!checkS(3)) return ;
			if(!checkLeft()) return ;
			num++;
			
		}
		int ni=i;
		int nj=j+1;
		if(nj>3){
			ni=i+1;
			nj=0;
		}
		for (int n = 1; n < 17; n++) {
			if(visit[n]) continue;
			visit[n]=true;
			a[ni][nj]=n;
			dfs(ni,nj);
			a[ni][nj]=0;
			visit[n]=false;
		}
	}
	private static boolean checkLeft() {
		int t=0;
		int sum=0;
		for (int i = 0; i <4; i++) {
			t+=a[i][i];
			sum+=a[i][3-i];
		}
		
		return t==34&&sum==34;
	}
	private static boolean checkS(int i) {
		for (int m = 0; m <=i; m++) {
			int t=0;
			for (int n = 0; n < 4; n++) {
				t+=a[n][m];
			}
			if(t!=34) return false;
		}
		return true;
		
	}
	private static boolean  checkLine(int index) {
		
		for (int i = 0; i <=index; i++) {
			int s= 0;
			for (int j = 0; j < 4; j++) {
				s+=a[i][j];
				
			}
			if(s!=34) return false;
		}
		return true;
	}
}
