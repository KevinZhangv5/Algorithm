package zkf.ture;

public class Y14_T2_LiuJiaoHuanFang {
	static int [][] a =new int[6][6];
	static boolean [] visit =new boolean[20];
	public static void main(String[] args) {
		a[0][0]=15;a[0][1]=13;visit[15]=true;visit[13]=true;
		a[0][3]=a[1][4]=a[2][5]=a[3][4]=a[4][3]=-1;
		dfs(0,1,1);
		/*if(dfs(0,1,1)){
//			System.out.println(a);
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					System.out.print(a[i][j]+"  ");
				}
				System.out.println();
			}
		}*/
	}

	private static void  dfs(int i, int j, int num) {
		
		if(i==2&&j==4){
			if(a[0][0]+a[1][0]+a[2][0]!=a[0][2]+a[1][3]+a[2][4]) return ;
		}
		if(i==3&&j==0){
			if(a[0][0]+a[1][0]+a[2][0]!=a[0][1]+a[1][1]+a[2][1]+a[3][0]) return ;
		}
		if(i==3&&j==3){
			if(a[0][1]+a[1][2]+a[2][3]+a[3][3]!=a[0][2]+a[1][3]+a[3][4]) return ;
		}
		if(i==4&&j==0){
			int sum =a[0][0]+a[1][0]+a[2][0];
			if(sum!=checkLine(a, 3)) return ;
			if(sum!=a[0][1]+a[1][1]+a[2][1]+a[3][0]||sum!=a[0][2]+a[1][2]+a[2][2]+a[3][1]+a[4][0]) return ;
//			System.out.println("daoshudier--end");
		}
		if(i==4&&j==2){
//			System.out.println("zuihou!!");
			int sum =a[0][0]+a[1][0]+a[2][0];
			if(sum!=a[1][3]+a[2][3]+a[3][2]+a[4][1]||sum!=a[2][4]+a[3][3]+a[4][2]) return ;
			if(checkLine(a, 4)!=sum)
				return ;
			for (int i1 = 0; i1 < a.length; i1++) {
				for (int j1 = 0; j1 < a[i1].length; j1++) {
					System.out.print(a[i1][j1]+"  ");
				}
				System.out.println();
			}

		}
		/*if(i==2&&j>0){
			int sum=-1;
			for (int y = 0; y <=j; y++) {
				int t=0;
				for (int x= 0; x < 3; x++) {
					t+=a[x][y];
				}
				if(sum==-1) sum=t;
				else if(sum!=t) return false;
			}
		}*/
		int ni=i;
		int nj=j+1;
		if(a[ni][nj]==-1){
			ni=i+1;nj=0;
			if(checkLine(a,i)==-1)
				return ;
		}
		for (int nextn =1; nextn <= 19; nextn++) {
			if(!visit[nextn]){
				visit[nextn]=true;
				a[ni][nj]=nextn;
				dfs(ni,nj,nextn);
				a[ni][nj]=0;
				visit[nextn]=false;
				/*visit[num]=true;
				return dfs(ni,nj,num+1);*/
			}
		}
	}


	private static int checkLine(int[][] a, int i) {
		if(i==0) return 28+a[0][2];
		int sum=-1;
		for(int x=0;x<=i;x++){
			int t=0;
			for (int y = 0; y < a[x].length&&a[x][y]!=-1; y++) {
				t+=a[x][y];
			}
			if(sum==-1) sum=t;
			else if(t!=sum) return -1;
		}
		return sum;
	}

}
