package zkf.ture;

public class Y13_T2JiShu {
	public static void main(String[] args) {
		int n=111;
		int n3=n*n*n;
		int i;
		long m = System.currentTimeMillis();
		label:
		for(i=1;i<=n3;i+=2){
			int sum=i;
			for (int j = i+2; j <=n3; j+=2) {
				if(sum<n3){
					sum+=j;
				}else if(sum==n3){
					System.out.println(i);
//					System.out.println("to:"+(j-2));
					break label;
				}else {
					continue;
				}
			}
		}
		System.out.println(System.currentTimeMillis()-m+"ms");
	}

}
