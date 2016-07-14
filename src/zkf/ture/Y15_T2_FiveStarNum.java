package zkf.ture;

public class Y15_T2_FiveStarNum {
	static int sum;
	static int a[] ={1,2,3,4,5,6,8,9,10,12};//10个数
	static boolean v[] = new boolean[10];//v[i]下标为i是否访问
	static int s[] = new int[11];
	public static void main(String[] args) {
		int line1=0;
		int line2=0;
		int line3=0;
		int line4=0;
		int line5=0;
		for (int i0 = 0; i0 < 10; i0++) {//i0代表第0个数的下标
			if(v[i0]) continue;
			v[i0]=true;
			for (int i1 = 0; i1 < 10; i1++) {//0
				if(v[i1]) continue;
				v[i1]=true;
				for (int i2 = 0; i2 < 10; i2++) {//0
					if(v[i2]) continue;
					v[i2]=true;
					for (int i3 = 0; i3 < 10; i3++) {//0
						if(v[i3]) continue;
						v[i3]=true;
						line1=a[i0]+a[i1]+a[i2]+a[i3];
						for(int i4=0;i4<10;i4++){
							if(v[i4]) continue;
							v[i4]=true;
							for(int i5=0;i5<10;i5++){
								if(v[i5]) continue;
								v[i5]=true;
								for(int i6=0;i6<10;i6++){
									if(v[i6]) continue;
									v[i6]=true;
									line2=a[i0]+a[i4]+a[i5]+a[i6];
									if(line1!=line2){v[i6]=false; continue;}
									for(int i7=0;i7<10;i7++){
										if(v[i7]) continue;
										v[i7]=true;
										for(int i8=0;i8<10;i8++){
											if(v[i8]) continue;
											v[i8]=true;
											line3=a[i7]+a[i1]+a[i4]+a[i8];
											if(line1!=line3) {v[i8]=false; continue;}
											for(int i9=0;i9<10;i9++){
												if(v[i9]) continue;
												v[i9]=true;
												line4=a[i7]+a[i2]+a[i9]+a[i6];
												if(line1!=line4) {v[i9]=false; continue;}
												line5=a[i8]+a[i5]+a[i9]+a[i3];
												if(line1!=line5) {v[i9]=false; continue;}
												
												System.out
														.println(+a[i0]+"  "+a[i1]+"  "+a[i2]+"  "+a[i3]+"  "+a[i4]+"  "
																+a[i5]+"  "+a[i6]+"  "+a[i7]+"  "+a[i8]+"  "+a[i9]+"  ");
												System.out
														.println("-------------");
												sum++;
												v[i9]=false;
											}
											v[i8]=false;
										}
										v[i7]=false;
									}
									v[i6]=false;
								}
								v[i5]=false;
							}
							v[i4]=false;
						}
						v[i3]=false;
					}
					v[i2]=false;
				}
				
				v[i1]=false;
			}
			v[i0]=false;
		}
		
		System.out.println(sum);
		System.out.println(sum/5.0);
		
	}

}
