package zkf.ture;


public class Y13_T3_QuickSort {
	public static void main(String[] args) {
		int a[]={3,1,4,2,5,7,9,0};
		f(a,0,a.length-1);
		for (int i = 0; i < a.length; i++) {
			System.out.print(i);
		}
		System.out.println();
	}
	static void f(int[] x, int left, int right)
	{
		if(left >= right) return;
		
		int key = x[(left+right)/2];
		
		int li = left;
		int ri = right;
		while(li<=ri){
			while(x[ri]>key) ri--;
			while(x[li]<key) li++;
			
			if(li<=ri){    //Ìî¿ÕÎ»ÖÃ
				int t = x[li];
				x[li] = x[ri];
				x[ri] = t;
				li++;
				ri--;
			}	
		}
		
		if(li < right) f(x, li, right);
		if(ri > left) f(x, left, ri);
	}
}
