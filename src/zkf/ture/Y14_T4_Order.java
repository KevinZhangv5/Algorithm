package zkf.ture;
public class Y14_T4_Order
{
	static int max = 0;//���¶��ټ���
	static int T = 0;//�����ְڷ�
	static final int N = 6;
		
	// ֻ����(r,c) �Լ� ���ң����·��� 
	static void f(int[][] da, int r, int c)
	{	
		if(r>=N){
			int n = count(da);
			if(n>max) {
				max = n;
				T = 0;
			}
			if(n==max) T++;
			return;
		}
		
		//����һ�²�����
		int r_next = r;
		int c_next = c + 1;
		if(c_next>=N){
			c_next = 0;
			r_next++;
		}
		
		if(spy(da,r,c)<2){  // ���λ��
			da[r][c] = 1;
			f(da, r_next, c_next); 
		}
		
		da[r][c] = 0;
		f(da, r_next, c_next);
	}
	
	static int count(int[][] da)
	{
		int n = 0;
		
		for(int i=0; i<da.length; i++)
		for(int j=0; j<da[i].length; j++) 
			if(da[i][j]==1) n++;
			
		return n;
	}
	
	static int spy(int[][] da, int r, int c)
	{
		int m=0;
		
		// ����
		int n=0;
		for(int i=0; i<N; i++) if(da[r][i]==1) n++;
		if(n>m) m = n;

		//����
		n=0;
		for(int i=0; i<N; i++) if(da[i][c]==1) n++;
		if(n>m) m = n;
		
		//��б��
		n=0;
		for(int i=0; i<N; i++){ 
			if(r-i<0 || c-i<0) break; 
			if(da[r-i][c-i]==1) n++;
		}
		for(int i=1; i<N; i++){ 
			if(r+i>=N || c+i>=N) break; 
			if(da[r+i][c+i]==1) n++;
		}
		if(n>m) m = n;
		
		//��б��
		n=0;
		for(int i=0; i<N; i++){ 
			if(r-i<0 || c+i>=N) break; 
			if(da[r-i][c+i]==1) n++;
		}
		for(int i=1; i<N; i++){ 
			if(r+i>=N || c-i<0) break; 
			if(da[r+i][c-i]==1) n++;
		}
		if(n > m) m = n;
		
		return m;
	}
	
	public static void main(String[] args)
	{
		int[][] da = new int[N][N];
		
		f(da, 0, 0);
		
		System.out.println(max);
		System.out.println(T);
	}
}

