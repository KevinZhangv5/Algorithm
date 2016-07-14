package zkf.ture;


public class Y13_T3_A_AiJi {
	static int a=2,b=45;
	public static void main(String[] args) {
		int sum=0;
		int times=30000;
		for (int i = 1; i < times; i++) {
			for (int j = i+1; j < times; j++) {
				if(j(i,j)){
					sum++;
				}
			}
		}
		System.out.println(sum);
	}

	private static boolean j(int i, int j) {
		
		return a*i*j==b*(i+j);
	}
}
