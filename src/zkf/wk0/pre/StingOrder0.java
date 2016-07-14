package zkf.wk0.pre;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class StingOrder0 {
	/**
	 * ���⣺������������̴��⣩
		����� a b c d �� 4 ����ĸ���һ�������� 4!=24 �֣�����������Ÿ���ÿ������
		��Ӧһ����ţ�
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
		�����в����� 10 ��������ͬ��Сд��ĸ������������ɵĴ�����������ô�����
		�������е������
		�������ʽ��
		һ�У�һ������
		�������ʽ��
		һ�У�һ����������ʾ�ô�������ĸ�����������ɵĴ��е���š�ע�⣺��С�������
		0��
		���磺
		���룺
		bdca
		����Ӧ�������
		11
		�����磺
		���룺
		cedab
		����Ӧ�������
		70
		��ԴԼ����
		��ֵ�ڴ����� < 256M
		CPU ���� < 1000ms
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
	 * ����i �������Ľ���
	 * @param s
	 * @param i
	 */
	

	private static void exch(char[] s, int i, int j) {
		char t = s[i];
		s[i]=s[j];
		s[j]=t;
	}

}
