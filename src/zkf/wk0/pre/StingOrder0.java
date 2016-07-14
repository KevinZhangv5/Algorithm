package zkf.wk0.pre;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class StingOrder0 {
	/**
	 * 标题：排列序数（编程大题）
		如果用 a b c d 这 4 个字母组成一个串，有 4!=24 种，如果把它们排个序，每个串都
		对应一个序号：
		abcd 0
		abdc 1
		acbd 2
		acdb 3
		adbc 4
		adcb 5
		bacd 6
		badc 7
		bcad 8
		bcda 9
		bdac 10
		bdca 11
		cabd 12
		cadb 13
		cbad 14
		cbda 15
		cdab 16
		cdba 17
		...
		现在有不多于 10 个两两不同的小写字母，给出它们组成的串，你能求出该串在所
		有排列中的序号吗？
		【输入格式】
		一行，一个串。
		【输出格式】
		一行，一个整数，表示该串在其字母所有排列生成的串中的序号。注意：最小的序号是
		0。
		例如：
		输入：
		bdca
		程序应该输出：
		11
		再例如：
		输入：
		cedab
		程序应该输出：
		70
		资源约定：
		峰值内存消耗 < 256M
		CPU 消耗 < 1000ms
	 * @param args
	 */
//	public static Set<String> treeSet = new TreeSet<>();
	public static List<String> list = new ArrayList<String>();
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String string = s.nextLine();
		f(string.toCharArray(), 0,string.length()-1);
		Collections.sort(list);
		System.out.println(list);
		System.out.println(list.indexOf(string));
		
		
	}

	private static void f(char[] charArray, int begin,int end) {
		if(begin==end){
			list.add(new String(charArray));
			for (char c : charArray) {
				System.out.print(c);
			}
			System.out.println();
		}
		for (int i = begin; i <=end; i++) {
			exch(charArray, begin, i);
			f(charArray, begin+1, end);
			exch(charArray, begin, i);
			
		}
	}

	/**
	 * 将第i 个与后面的交换
	 * @param s
	 * @param i
	 */
	

	private static void exch(char[] s, int i, int j) {
		char t = s[i];
		s[i]=s[j];
		s[j]=t;
	}

}
