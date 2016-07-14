package zkf.wk2.search;

import java.io.IOException;
import java.util.HashSet;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class TestIn {
	public static void main(String[] args) throws IOException {
		HashSet<Object> set = new HashSet<>();
		int [] a =new int[3];
		for (int i = 0; i < a.length; i++) {
			a[i]=System.in.read()-'0';
		}
		for (int i : a) {
			System.out.println(i);
		}
	}

}
