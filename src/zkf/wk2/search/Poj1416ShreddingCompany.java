package zkf.wk2.search;



import java.util.Scanner;
public class Poj1416ShreddingCompany {
	static int target;
	static boolean rej;
	static int max=-1;
	static String finalres;
	public static void main(String[] args) {
//		Collections.sort(list);
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		while((target = scanner.nextInt())!=0){
			max=-1;
			rej=false;
			finalres=null;
			int paper = scanner.nextInt();
			String str = String.valueOf(paper);
			cut(str,0,"");
			if(max==-1)
				System.out.println("error");
			else if(rej)
				System.out.println("rejected");
			else {
				System.out.print(max);
				System.out.println(finalres);
			}
		}
		
	}
	public static void cut(String str, int sum,String res) {
		if (sum > target)
			return;
		if (str == null || "".equals(str)){
			if(sum>max){
				rej=false;
				max=sum;
				finalres=res;
			}else if(sum==max){
				rej=true;
			}
		}
		for (int i = 1; i <= str.length(); i++) {
			int newnum = sum + Integer.parseInt(str.substring(0, i));
			cut(str.substring(i), newnum,res+" "+str.substring(0, i));

		}
	}
}
