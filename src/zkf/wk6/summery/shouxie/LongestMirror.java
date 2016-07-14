package zkf.wk6.summery.shouxie;

import java.util.Scanner;

public class LongestMirror {
	private static final int MAXLENGTH = 100;
	static int [] p=new int [MAXLENGTH];
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		manacher(str);
		
	}

	private static void manacher(String str) {
		StringBuffer s= new StringBuffer();
		s.append("$#");
		for (int i = 0; i < str.length(); i++) {
			s.append(str.charAt(i));
			s.append("#");
		}
//		System.out.println(s);
		
		int id=0,max=0;
		char[] c = s.toString().toCharArray();
		for(int i=1;i<c.length;i++){
			int j=2*id-i;
			p[i]=i<max?min(max-i,p[j]):1;
			while(i+p[i]<c.length&&c[i+p[i]]==c[i-p[i]]) p[i]++;
			if(max<(i+p[i])){
				max=i+p[i];id=i;
			}
			
		}
		int m=0,mid=0;
		for (int i = 0; i <c.length ; i++) {
//			System.out.print(p[i]+"  ");
			if(p[i]>m) {
				mid=i;
				m=p[i];
			}
		}
		m--;
		for(int i=mid-m;i<=mid+m;i++){
			if(c[i]!='#'){
				System.out.print(c[i]);
			}
		}
	}

	private static int min(int i, int j) {
		return i<j?i:j;
	}

}
