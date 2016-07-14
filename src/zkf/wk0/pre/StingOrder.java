package zkf.wk0.pre;
import zkf.util.InputUtil;


public class StingOrder extends InputUtil {
	/**
	 * 标题：排列序数（编程大题） 如果用 a b c d 这 4 个字母组成一个串，有 4!=24 种，如果把它们排个序，每个串都 对应一个序号：
	 * abcd 0 abdc 1 acbd 2 acdb 3 adbc 4 adcb 5 bacd 6 badc 7 bcad 8 bcda 9
	 * bdac 10 bdca 11 cabd 12 cadb 13 cbad 14 cbda 15 cdab 16 cdba 17 ...
	 * 现在有不多于 10 个两两不同的小写字母，给出它们组成的串，你能求出该串在所 有排列中的序号吗？ 【输入格式】 一行，一个串。 【输出格式】
	 * 一行，一个整数，表示该串在其字母所有排列生成的串中的序号。注意：最小的序号是 0。 例如： 输入： bdca 程序应该输出： 11 再例如：
	 * 输入： cedab 程序应该输出： 70 资源约定： 峰值内存消耗 < 256M CPU 消耗 < 1000ms
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
		for (int j = i - 1; j > 1; j--) {//++ 还是 -- ？？？？
			num *= j;
		}
		return num;

	}

}
