package zkf.wk6.summery.shouxie;
 /* ��̬�滮
 * �������������
 * @ author by gsm
 * @ 2015.4.1
 */
public class LCS {

    public static int[][] lengthofLCS(char[] X, char[] Y){
        /* �����ά����c[][]��¼X[i]��Y[j]��LCS���� (i,j)��ǰ׺
         * c[i][j]=0; �� i = j = 0;
         * c[i][j]=c[i-1][j-1]+1; �� i = j > 0; Xi == Y[i]
         * c[i][j]=max(c[i-1][j],c[i][j-1]); �� i = j > 0; Xi != Y[i]
         * ��Ҫ���� m*n ��������ĳ��� �� ����c[i][j]�ĳ���
         * -- ������
         */
        int[][]c = new int[X.length+1][Y.length+1];

        // ��̬�滮��������������
        for(int i=1;i<=X.length;i++){
            for (int j=1;j<=Y.length;j++){
                if(X[i-1]==Y[j-1]){
                    c[i][j] = c[i-1][j-1]+1;
                }
                else if(c[i-1][j] >= c[i][j-1]){
                    c[i][j] = c[i-1][j];
                }
                else{
                    c[i][j] = c[i][j-1];
                }
            }
        }

        // ��ӡC����
        for(int i=0;i<=X.length;i++){
            for (int j=0;j<=Y.length;j++){
                System.out.print(c[i][j]+" ");
            }
            System.out.println();
        }
        return c;
    }
    // ���LCS����
    public static void print(int[][] arr, char[] X, char[] Y, int i, int j) {
        if(i == 0 || j == 0)
            return;
        if(X[i-1] == Y[j-1]) {
            System.out.print("element " + X[i-1] + " ");
            // Ѱ�ҵ�
            print(arr, X, Y, i-1, j-1);
        }else if(arr[i-1][j] >= arr[i][j-1]) {
            print(arr, X, Y, i-1, j);
        }else{
            print(arr, X, Y, i, j-1);
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        char[] x ={'A','B','C','B','D','A','B'}; 
        char[] y ={'B','D','C','A','B','A'}; 
        int[][] c = lengthofLCS(x,y);
        print(c, x, y, x.length, y.length);
    }
}
