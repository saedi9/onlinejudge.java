package L;

import java.util.Scanner;

public class LoanSomeCarBuyer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int max_m = sc.nextInt();
            if (max_m < 0) {
                break;
            }
            double q = sc.nextDouble(), loan = sc.nextDouble();
            int n = sc.nextInt(), j = 1, m = 0;
            sc.nextLine();
            double dep = loan + q, monthly_pay = loan / max_m;
            double[][] month = new double[n][2];
            for (int i = 0; i < n; i++) {
                month[i][0] = sc.nextInt();
                String s = "0" + sc.next().trim();
                month[i][1] = Double.parseDouble(s);
                sc.nextLine();
            }
            dep -= (dep * month[0][1]);
            while (loan >= dep) {
                loan -= monthly_pay;
                if (j < n && (m+1) == month[j][0]) {
                    dep -= (dep * month[j][1]);
                    j++;
                    m++;
                } else {
                    dep -= (dep * month[j - 1][1]);
                    m++;
                }
            }
            if (m == 1) {
                System.out.println(m + " month");
            } else {
                System.out.println(m + " months");
            }
        }
    }
}
