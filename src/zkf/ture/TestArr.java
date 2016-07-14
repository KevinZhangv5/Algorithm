package zkf.ture;

public class TestArr {
	public static void main(String[] args) {
		int [] a =new int[]{1,2,4};
		int[] b=a;
		b[0]=10000;
		System.out.println(a[0]);
	}

}
