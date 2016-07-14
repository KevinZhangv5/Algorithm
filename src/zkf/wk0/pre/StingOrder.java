package zkf.wk0.pre;
import zkf.util.InputUtil;


public class StingOrder extends InputUtil {
	/**
	 * ���⣺������������̴��⣩ ����� a b c d �� 4 ����ĸ���һ�������� 4!=24 �֣�����������Ÿ���ÿ������ ��Ӧһ����ţ�
	 * abcd 0 abdc 1 acbd 2 acdb 3 adbc 4 adcb 5 bacd 6 badc 7 bcad 8 bcda 9
	 * bdac 10 bdca 11 cabd 12 cadb 13 cbad 14 cbda 15 cdab 16 cdba 17 ...
	 * �����в����� 10 ��������ͬ��Сд��ĸ������������ɵĴ�����������ô����� �������е������ �������ʽ�� һ�У�һ������ �������ʽ��
	 * һ�У�һ����������ʾ�ô�������ĸ�����������ɵĴ��е���š�ע�⣺��С������� 0�� ���磺 ���룺 bdca ����Ӧ������� 11 �����磺
	 * ���룺 cedab ����Ӧ������� 70 ��ԴԼ���� ��ֵ�ڴ����� < 256M CPU ���� < 1000ms
	 * 
	 * @param args
	 */
	// public static Set<String> treeSet = new TreeSet<>();
	public static void main(String[] args) {
		String string = scanner.nextLine();
		int sum = 0;
		char[] c = string.toCharArray();
		int len = c.length;
		for (int i = 0; i < len; i++) {
			int n = 0;
			for (int j = 1; j < len; j++) {
				if (c[i] > c[j])
					n++;
			}

			if (n >= 0)
				sum += n * jiec(len - i - 1);
		}
		System.out.println(sum);
		
	}

	private static int jiec(int i) {
		int num = i;
		for (int j = i - 1; j > 1; j--) {//++ ���� -- ��������
			num *= j;
		}
		return num;

	}

}
