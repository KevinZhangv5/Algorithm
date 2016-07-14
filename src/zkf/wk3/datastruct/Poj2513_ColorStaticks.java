package zkf.wk3.datastruct;

import java.util.Arrays;
import java.util.Scanner;
class Node{
	int id;
	Node[] next = new Node[26];
}
public class Poj2513_ColorStaticks {
	static int[] d=new int[250000 *2];
	static int[] u = new int[250000*2];
	static Node root  = new Node();
	static int[] sz;//存储每个树的节点个数，初始值为1.
	static int countId = 0;//用于id计数
	public Poj2513_ColorStaticks() {
		for (int i = 0; i < u.length; i++) {
			u[i]=i;
		}
		Arrays.fill(sz, 1);
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter("\n");
		String s;
		while((s=scanner.nextLine())!=null&&!"".equals(s)){
			String[] split = s.split(" ");
			int num1 = getNum(split[0]);
			int num2 = getNum(split[1]);
			d[num1]++;
			d[num2]++;
			int find1 = find(num1);
			int find2 = find(num2);
			
			if(find1!=find2){
				union(find1,find2);
		}
		}
		int count = 0;
		for (int i = 0; i < d.length; i++) {
			if(d[i]%2!=0){
				count++;
			}
			if(count>3)
				break;
		}
		if(count!=0&&count!=2){
			System.out.println("Impossible");
			System.exit(1);
		}
		int t = find(1);
		for(int i = 1;i<=countId;i++){
			if(find(i)!=t){
				System.out.println("Impossible");
				System.exit(1);
			}
		}
		System.out.println("Possible");
		
		
	}

	private static void union(int num1, int num2) {
		if(sz[num1]<sz[num2]){
			u[num1]=num2;//小树连大树
			sz[num1]+=sz[num2];
		}else{
			u[num2]=num1;
			sz[num2]+=sz[num1];
		}
		
	}

	private static int find(int num) {
		int k = num;
		if(u[num]==num){
			return num;
		}
		while(u[k]!=k){
			k=u[k];
		}
		int i = num;
		while(i>k){
			int j=u[i];
			u[i]=k;
			i=j;
		}
		
		return k;
	}

	private static int getNum(String string) {//字典树//p为指针，每次循环结束时指向字符所对应的节点
		char[] arr = string.toCharArray();
		Node p = root;
		for (int i = 0; i < arr.length; i++) {
			int index  = arr[i]-'a';
			if(p.next[index]==null){
				p.next[index]=new Node();
			}
			p=p.next[index];
		}
		if(p.id==0){
			countId++;
			p.id=countId;
		}
		return p.id;
		
	}

}
