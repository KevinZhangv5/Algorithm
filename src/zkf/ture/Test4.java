package zkf.ture;

import java.util.Arrays;

public class Test4 {
    public static void main(String[] args){
       int[][] a={{1,2},{2,2,2,3},{3}};
       Object[] arg = new Object[]{"Hello","world"};
       Object[] c = new Object[]{3,2,1};
       int[] d={1,1,1};
       // System.out.printf("%d %d %d\n",(Object)d);
       System.out.printf("{%s %s %s}\n",1,2,3);
       System.out.printf("%d %d %d\n",c);
       System.out.printf("%s\n", "Hello","world");
       System.out.printf("%s %s\n", arg);
       System.out.printf("%s\n",new Object[]{arg});
       System.out.printf("%s\n",(Object)arg);
       assert false:1;
       Arrays.sort(a);
       
    }
}