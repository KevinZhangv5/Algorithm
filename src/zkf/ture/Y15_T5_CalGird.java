package zkf.ture;

import java.util.Scanner;

class Exp{
	String op;
	boolean v;
	int curx,cury;
	int frx,fry;
	int tx,ty;
	@Override
	public String toString() {
		return "Exp [op=" + op + ", v=" + v + ", curx=" + curx + ", cury="
				+ cury + ", frx=" + frx + ", fry=" + fry + ", tx=" + tx
				+ ", ty=" + ty + "]";
	}
	
}
public class Y15_T5_CalGird{
	static int m,n;
	static double[][] a;
	static Exp[] exps =new Exp[2500] ;
	static int expn;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		a=new double[n][m];
		fill(a);
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String[] split = sc.nextLine().split(" ");
			assert split.length==m;
			for (int j = 0; j < split.length; j++) {
				if(split[j].length()<8){
					double num = Double.parseDouble(split[j]);
					a[i][j]=num;
				}else {
					Exp c = c(split[j]);
					c.curx=i;c.cury=j;
//					System.out.println(c);
					exps[expn++]=c;
				}
			}
		}
		//开始处理
		int leftop=expn;
		int index=0;
		while(leftop>0){
			index=index%expn;
			Exp e= exps[index];
			if(e.v) {index++;continue;};
			if(canCal(e)){
				cal(e);
				leftop--;
			}
			index++;
			
		}
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if(j==a[i].length-1){
					System.out.printf("%.2f",a[i][j]);
				}else {
					System.out.printf("%.2f ",a[i][j]);
				}
			}
			System.out.println();
			
		}
	}
	private static void cal(Exp e) {

		if(e.op.equals("SUM")){
			e.v=true;
			a[e.curx][e.cury]=sum(e);
		}else if (e.op.equals("AVG")){
			e.v=true;
			a[e.curx][e.cury]=avg(e);
		}else if(e.op.equals("STD")){
			e.v=true;
			a[e.curx][e.cury]=std(e);
			
		}else{
			System.out.println("无效zif");
		}
	}
	private static double std(Exp e) {
		double h=0;
		double avg=avg(e);
		int numbs=0;
		for(int i=e.frx;i<=e.tx;i++){
			for(int j=e.fry;j<=e.ty;j++){
				numbs++;
				h+=(a[i][j]-avg)*(a[i][j]-avg);
			}
		}
		return Math.sqrt(h/numbs);
	}
	private static double avg(Exp e) {
		double s=0;
		int numbs=0;
		for(int i=e.frx;i<=e.tx;i++){
			for(int j=e.fry;j<=e.ty;j++){
				s+=a[i][j];numbs++;
			}
		}
		return s/numbs;
	}
	private static double sum(Exp e) {
		double s=0;
		for(int i=e.frx;i<=e.tx;i++){
			for(int j=e.fry;j<=e.ty;j++){
				s+=a[i][j];
			}
		}
		return s;
	}
	private static boolean canCal(Exp e) {
		for(int i=e.frx;i<=e.tx;i++){
			for(int j=e.fry;j<=e.ty;j++){
				if(a[i][j]==Double.POSITIVE_INFINITY){
					return false;
				}
			}
			
		}
		return true;
		
	}
	private static void fill(double[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j]=Double.POSITIVE_INFINITY;
			}
		}
	}
	private static Exp c(String string) {
		String exp =string.substring(0, 3);
//		System.out.println(exp);
		String[] group = string.substring(4, string.length() - 1).split(":");
		String[] frs = group[0].split(",");
		String[] tos = group[1].split(",");
		Exp e = new Exp();
		e.op=exp;
		e.frx=Integer.parseInt(frs[0])-1;
		e.fry=Integer.parseInt(frs[1])-1;
		e.tx=Integer.parseInt(tos[0])-1;
		e.ty=Integer.parseInt(tos[1])-1;
		return e;
		
	}
}