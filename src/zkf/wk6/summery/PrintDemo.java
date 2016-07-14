package zkf.wk6.summery;

public class PrintDemo {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.printf("%2f%n",1200.328902759d);
        // %d表示将整数格式化为10进制整数
		System.out.printf("%2$s,%1$s", "1","2");
		System.out.printf("%o%n",9);
		System.out.printf("%x%n",17);
		System.out.printf("%#x%n",17);
		System.out.printf("%.2f",190.345);
		String s = "哈囉！";
		int i = 1234;
		System.out.printf("字符串：%2$s，%1$d的十六進制數：%1$#x",i,s);
		System.out.println();
		System.out.printf("%2$s,%1$s", "1","2");
	}

}
