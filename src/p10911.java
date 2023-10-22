import java.util.*;

public class p10911 {
    static boolean don[];
    static double dis[][];
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while ((n = (sc.nextInt())*2)!=0) {
            int[] x = new int[n], y = new int[n];
            double res = 100000000.0;
            dis= new double[n][n];
            for (int i = 0; i < n; i++) {
                sc.next();
                x[i] = sc.nextInt();
                y[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++)
                for (int j = i + 1; j < n; j++)
                    dis[i][j] = Math.sqrt((x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]));

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    don = new boolean[n];
                    double temp =0;
                    if (j != i && !don[i] && !don[j]) {
                        temp += dis[i][j];
                        don[i] = true;
                        don[j] = true;
                    }
                    for (int k = 0; k < n; k++) {
                        for (int l = 0; l < n; l++) {
                            if (k != l && !don[k] && !don[l]) {
                                temp += dis[k][l];
                                don[k] = true;
                                don[l] = true;
                                break;
                            }
                            if(don[k])break;
                        }
                    }
                    if(temp<res)res = temp;
                }
            }
            System.out.println(res);
        }
    }

}