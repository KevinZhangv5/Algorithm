package zkf.ture;

import java.util.LinkedList;
import java.util.Scanner;

class Node{
	int i,j;
	int step;
	boolean[][] visit;
	public Node(){}
	public Node(int i, int j, int step, boolean[][] visit) {
		super();
		this.i = i;
		this.j = j;
		this.step = step;
		this.visit = visit;
	}
}
public class Y15_T4_CrossMine {
	
	static int[][] map;
	static int starti,startj,endi,endj;
	static int n;
	static int dx[]={0,0,-1,1};
	static int dy[]={-1,1,0,0};
	public static void main(String[] args) {
		//Input
		
		Scanner scanner = new Scanner(System.in);
		n=scanner.nextInt();
		map=new int[n][n];
		scanner.nextLine();
		for (int i = 0; i < n; i++) {
			char[] arr = scanner.nextLine().toCharArray();
			int index=0;
			for (int j = 0; j < arr.length;j++) {
				if(arr[j]==' '){continue;}
				if(arr[j]=='+'){
					map[i][index]=1;
				}else if(arr[j]=='-'){
					map[i][index]=0;
				}else if (arr[j]=='A') {
					starti=i;startj=j;
					map[i][index]=-2;
				}else {
					endi=i;endj=j;
					map[i][index]=-1;
				}
				index++;
			}
			
		}
		/*for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]+"  ");
			}
			System.out.println();
		}*/
		System.out.println(bfs());
		
	}
	private static int bfs() {
		// Èë¶Ó
		LinkedList<Node> q = new LinkedList<Node>();
		for (int i = 0; i < 4; i++) {
			int ni = starti + dx[i];
			int nj = startj + dy[i];
			if (0 <= ni && ni < n && 0 <= nj && nj < n) {
				boolean[][] visit = new boolean[n][n];
				visit[starti][startj] = true;
				visit[ni][nj] = true;
				q.add(new Node(ni, nj, 1, visit));
			}
		}
		// while
		while (!q.isEmpty()) {
			Node cn = q.pop();
			if (cn.i == endi && cn.j == endj) {
				return cn.step;
			}
			for (int i = 0; i < 4; i++) {
				int ni =cn.i + dx[i];
				int nj = cn.j + dy[i];
				if (0 <= ni && ni < n && 0 <= nj && nj < n && !cn.visit[ni][nj]) {
					if (map[ni][nj] != map[cn.i][cn.j]) {
						Node next = new Node();
						next.i = ni;
						next.j = nj;
						next.step = cn.step + 1;
						boolean[][] v2 = new boolean[n][n];
						for (int m = 0; m < cn.visit.length; m++) {
							for (int n = 0; n < cn.visit[m].length; n++) {
								v2[m][n] = cn.visit[m][n];
							}
						}
						v2[ni][nj]=true;
						next.visit = v2;
						q.add(next);
					}
				}
			}

		}
		return -1;

	}

}
