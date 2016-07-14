package zkf.ture;

import java.util.LinkedList;
import java.util.Scanner;

class Point{
	int x,y,step;
	int[][] map;
	public Point(int x, int y, int step,int[][] c) {
		super();
		this.x = x;
		this.y = y;
		this.step = step;
		this.map=c;
	}
	
}
public class Y13_T4HuaRongDaoBFS {
	static int[][] a=new int[3][3];
	static int[][] b=new int[3][3];
	static int starti,startj,res;
	static int targeti,targetj;
	static int dx[]={0,0,-1,1};
	static int dy[]={-1,1,0,0};
	static boolean visit[] = new boolean[362880+10];
	static int[] fac={1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] arr1 = scanner.nextLine().toCharArray();
		char[] arr2 = scanner.nextLine().toCharArray();
		for (int i = 0; i < arr1.length; i++) {
			int x=i/3;
			int y=i%3;
			if(arr1[i]=='.'){
				starti=x;startj=y;
			}else {
				a[x][y]=arr1[i]-'0';
			}
			
			if(arr2[i]=='.'){
				targeti=x;targetj=y;
			}else {
				b[x][y]=arr2[i]-'0';
			}
		}
		
		bfs(new Point(starti,startj,0,a));
	}
	
	public static void bfs(Point p) {
		LinkedList<Point> queue = new LinkedList<Point>();
		queue.add(p);
		visit[cantorNum(p.map)]=true;
		Point cp;
		while(!queue.isEmpty()){
			cp=queue.pop();
			//满足条件
			if(cp.x==targeti&&cp.y==targetj&&ju(cp.map)){
				System.out.println(cp.step);
				return ;
			}
			//对状态进行扩展
			for (int i = 0; i < 4; i++) {
				int ni=cp.x+dx[i];
				int nj=cp.y+dy[i];
				if(0<=ni&&ni<3&&0<=nj&&nj<3){
					int [][] cmap = new int[3][3];
					for (int j = 0; j < cmap.length; j++) {
						for (int j2 = 0; j2 < cmap[j].length; j2++) {
							cmap[j][j2]=cp.map[j][j2];//应该重新拷贝一个数组，而不是简单的赋值
						}
					}
					exch(cmap,cp.x,cp.y,ni,nj);
					int id= cantorNum(cmap);
					if(!visit[id]){
						Point next =new Point(ni, nj, cp.step+1,cmap);
						queue.add(next);
						visit[id]=true;
						
					}
				}
			}
		}
		res=-1;
		
	}

	

	private static boolean ju(int[][] map) {
		
		return cantorNum(map)==cantorNum(b);
	}

	private static int cantorNum(int[][] map) {
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			int num = 0;
			for (int j = i+1; j < 9; j++) {
				if(map[i/3][i%3]>map[j/3][j%3]){
					num++;
				}
			}
			sum+=fac[9-i-1]*num;
		}
		return sum;
	}

	private static void exch(int[][] a, int i, int j, int ni, int nj) {
		int t=a[i][j];a[i][j]=a[ni][nj];a[ni][nj]=t;
	}
	
}
/***
 * 
 * 标题：九宫重排

    如图1的九宫格中，放着 1~8 的数字卡片，还有一个格子空着。与空格子相邻的格子中的卡片可以移动到空格中。经过若干次移动，可以形成图2所示的局面。

    我们把图1的局面记为：12345678.
    把图2的局面记为：123.46758

    显然是按从上到下，从左到右的顺序记录数字，空格记为句点。

    本题目的任务是已知九宫的初态和终态，求最少经过多少步的移动可以到达。如果无论多少步都无法到达，则输出-1。

例如：
输入数据为：
12345678.
123.46758
则,程序应该输出：
3

再如：
输入：
13524678.
46758123.
则，程序输出：
22


资源约定：
峰值内存消耗（含虚拟机） < 64M
CPU消耗  < 2000ms

 *
 */