package zkf.ture;

import java.util.Arrays;
import java.util.Random;

public class Y13_T2_A_ShaiZi {
	static int m[] =new int[6];
	static int r1[] =new int[]{0,0,0,8,8,8};
	static int r2[] =new int[]{1,1,4,5,6,7};
	static int res[] = new int[6];
	static double per;
	static Random ran = new Random();
	public static void main(String[] args) {
		for (int i1 = 0; i1 < 9; i1++) {
			for (int i2 = 0; i2 < 9; i2++) {
				for (int i3 = 0; i3 < 9; i3++) {
					for (int i4 = 0; i4 < 9; i4++) {
						for (int i5 = 0; i5 < 9; i5++) {
							int i6=24-i1-i2-i3-i4-i5;
							if(i6>8||i6<0) continue;
							m[0]=i1;m[1]=i2;m[2]=i3;m[3]=i4;
							m[4]=i5;m[5]=i6;
							game();
						}
						
					}
				}
			}
		}
		Arrays.sort(res);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i]+"  ");
			
		}
	}

	private static void game() {
		int sum = 0;
		for(int i=0;i<7000;i++){
			int r1n=ran.nextInt(6);
			int r2n=ran.nextInt(6);
			int myn=ran.nextInt(6);
			if(m[myn]==r1[r1n]||m[myn]==r2[r2n]||r1[r1n]==r2[r2n]) continue;
			if(m[myn]>r1[r1n]&&(m[myn]>r2[r2n])){
				sum++;
			}
		}
		if(per<sum/7000.0){
			copy(res,m);
			per=sum/7000.0;
		}
	}

	private static void copy(int[] res, int[] m) {
		for (int i = 0; i < m.length; i++) {
			res[i]=m[i];
		}
	}

}
