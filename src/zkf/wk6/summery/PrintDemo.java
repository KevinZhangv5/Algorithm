package zkf.wk6.summery;

public class PrintDemo {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.printf("%2f%n",1200.328902759d);
        // %d��ʾ��������ʽ��Ϊ10��������
		System.out.printf("%2$s,%1$s", "1","2");
		System.out.printf("%o%n",9);
		System.out.printf("%x%n",17);
		System.out.printf("%#x%n",17);
		System.out.printf("%.2f",190.345);
		String s = "���ӣ�";
		int i = 1234;
		System.out.printf("�ַ�����%2$s��%1$d��ʮ���M�Ɣ���%1$#x",i,s);
		System.out.println();
		System.out.printf("%2$s,%1$s", "1","2");
	}

}
