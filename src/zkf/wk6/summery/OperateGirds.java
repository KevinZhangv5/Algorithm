package zkf.wk6.summery;

import java.util.Scanner;

class Node{
	int l,r;//该节点表示[l,r]的范围
	int max,sum;
}
public class OperateGirds {
	static Node[] t ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		t=new Node[1000];
		build(1,1,n);
		for (int i = 1; i <=n; i++) {
			update(1,i,sc.nextInt());
		}
		for (int i = 0; i < m; i++) {
			switch (sc.nextInt()) {
			case 1:
				int x=sc.nextInt();
				int y= sc.nextInt();
				change(1,x,y);
				break;
			case 2:
				int x2=sc.nextInt();
				int y2= sc.nextInt();
				int qSum = qSum(1,x2,y2);
				System.out.println(qSum);
				break;
			case 3:
				int x3=sc.nextInt();
				int y3= sc.nextInt();
				int m1 = qMax(1,x3,y3);
				System.out.println(m1);
				break;
			default:
				break;
			}
		}
		
	}
	private static void build(int from, int l, int r) {
		t[from]=new Node();
		t[from].l=l;
		t[from].r=r;
		if(l==r) return;
		int mid = (r+l)/2;
		build(2*from,l,mid);
		build(2*from+1,mid+1,r);
		
	}
	private static int qMax(int from, int x, int y) {
		Node c= t[from];
		if(c.l==x&&c.r==y) return c.max;
		int mid =  (c.l+c.r)/2;
		if(y<=mid){
			return qMax(2*from,x,y);
		}else if(x>mid){
			return qMax(2*from+1, x, y);
		}else{
			return max(qMax(2*from, x, mid),qMax(2*from+1, mid+1, y));
		}
	}
	private static int max(int a, int b) {
		return a>b?a:b;
		
	}
	private static int qSum(int from, int x, int y) {
		Node c= t[from];
		if(c.l==x&&c.r==y) return c.sum;
		int mid =  (c.l+c.r)/2;
		if(y<=mid){
			return qSum(2*from,x,y);
		}else if(x>mid){
			return qSum(2*from+1, x, y);
		}else{
			return qSum(2*from, x, mid)+qSum(2*from+1, mid+1, y);
		}
	}
	private static void change(int f, int v, int value) {
		Node c = t[f];
		if(c.l==c.r){
			c.sum=value;
			c.max=value;
			return ;
		}
		if(v<=(c.l+c.r)/2){
			change(2*f,v,value);
		}else{
			change(2*f+1,v,value);
		}
		c.sum=t[2*f].sum+t[2*f+1].sum;
		c.max=t[2*f].max>t[2*f+1].max?t[2*f].max:t[2*f+1].max;
		
	}
	//以f为根节点，将v的值更新为value
	public static void update(int f, int v, int value) {
		t[f].sum+=value;
//		t[from].max>value?t[from].max=value:t[from].max=value;
		if(t[f].max<value){
			t[f].max=value;
		}
		if(t[f].l==t[f].r){
			return ;
		}
		if(v<=(t[f].l+t[f].r)/2){
			update(2*f, v, value);
		}else {
			update(2*f+1, v, value);
		}
	}

}
