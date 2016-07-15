package zkf.wk6.summery.test;

public class Fact {
	public static void main(String[] args) {
		for (int i =0; i < 10; i++) {
			int res=1;
			for (int j =2; j <=i; j++) {
				res*=j;
			}
			
			System.out.print(res+",");
		}
	}

}
