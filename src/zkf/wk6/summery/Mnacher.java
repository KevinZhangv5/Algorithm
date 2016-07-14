package zkf.wk6.summery;

import java.util.HashSet;

public class Mnacher {
	static int[] p =new int[1024];
	static StringBuffer buf = new StringBuffer();
	public static void  h(String s){
		
		buf.append("$#");
		for (int i = 0; i < s.length(); i++) {
			buf.append(s.charAt(i)).append("#");
		}
		int length =buf.length();
		System.out.println(buf);
		int id=0;int mx=0;
		for (int i = 1; i < buf.length(); i++) {
			p[i]=mx>i?min(p[2*id-i],mx-i):1;
			while((i+p[i])<length&&buf.charAt(i-p[i])==buf.charAt(i+p[i])) 
				p[i]++;
			if(mx<i+p[i]){
				id=i;
				mx=i+p[i];
			}
		}
		int max=-1;
		int flag=0;
		for(int j=0;j<length;j++){
			if(max<p[j]) {max=p[j];flag=j;}
		}
		max--;
		for(int i=flag-max;i<=flag+max;i++){
			if(buf.charAt(i)=='#') continue;
			System.out.print(buf.charAt(i));
		}
		
		
	}
	public static void printAll(){
		HashSet<String> set = new HashSet<String>();
		for(int i=0;i<buf.length();i++){
			if(p[i]>2){
				int t=p[i];
				while(t>2){
					int d=t-1;
					StringBuffer b = new StringBuffer();
					for(int j=i-d;j<=i+d;j++){
						if(buf.charAt(j)!='#') b.append(buf.charAt(j));
					}
					set.add(b.toString());
					t-=2;
				}
			}
		}
		System.out.println(set);
	}
	private static int min(int i, int j) {
		return i>j?j:i;
	}
	public static void main(String[] args) {
		Mnacher.h("abaaba");
		Mnacher.printAll();
		
	}

}
