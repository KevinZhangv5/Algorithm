package zkf.wk6.summery.test;

public class UnionFind {
	static int[] a=new int[10000];
	static int[] sz=new int[10000];
	public static void main(String[] args) {
		for (int i = 0; i < a.length; i++) {
			a[i]=i;
		}
		union(1,2);
		union(4,6);
		union(7,6);
		System.out.println(find(4));
	}

	public static int find(int i) {
		int r=i;
		while(a[r]!=r){
			r=a[r];
		}
		while(a[i]!=i){
			int t=a[i];
			a[i]=r;
			i=t;
		}
		return r;
		
	}

	private static void union(int i, int j) {
		int r1 = find(i);
		int r2 = find(j);
		if(r1!=r2){
			if(sz[r1]>=sz[r2]){
				a[r1]=r2;
			}else{
				a[r2]=r1;
			}
		}
	}

}
