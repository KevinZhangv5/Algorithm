package zkf.ture;

public class Y15_T2_A_HuanFangM2 {
	static int[] a = new int[16];
	static int num;
	static boolean visit[] = new boolean[17];

	public static void main(String[] args) {
		int index = 1;
		for (int i = 0; i < a.length; i++) {
			a[i] = index++;
		}
		pai(1,a.length);
	}

	private static void pai(int from,int to) {
		for(int i=from;i<to;i++){
			for(int j=from;j<to;j++){
				exch(i,j);
				pai(from+1,to);
				exch(i,j);
			}
		}
	}

	private static void exch(int i, int j) {
		// TODO Auto-generated method stub
		
	}
}
