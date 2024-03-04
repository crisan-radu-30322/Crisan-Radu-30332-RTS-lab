package LAB1;

public class ex2 {
    public static void main(String[] args) {
        int m1[][] = {{2, 3, 1}, {7, 1, 6}, {9, 2, 4}};
        int m2[][] = {{8, 5, 3}, {3, 9, 2}, {2, 7, 3}};
        int m3[][] = new int[3][3];
        System.out.println("The addition of m1 and m2:\n");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                m3[i][j] = m1[i][j] + m2[i][j];
                System.out.print(m3[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("The multiplication of m1 and m2:\n");
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                m3[i][j]=0;
                for(int k=0;k<3;k++)
                {
                    m3[i][j]+= m1[i][k] * m2[k][j];
                }
                System.out.print(m3[i][j]+" ");
            }
            System.out.println();
        }
    }
}
