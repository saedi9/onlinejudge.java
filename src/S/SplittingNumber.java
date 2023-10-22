package S;

import java.util.Scanner;

public class SplittingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            int n =sc.nextInt();
            if(n==0){break;}
            int index = 1;
            String sample = "000000000000000000000000000000000000";
            String bin = Integer.toBinaryString(n);
            StringBuilder a = new StringBuilder(sample.substring(0, bin.length()));
            StringBuilder b = new StringBuilder(sample.substring(0, bin.length()));
            for (int i = bin.length() - 1; i >= 0; i--) {
                if (bin.charAt(i) == '1') {
                    if (index % 2 != 0) {
                        a.setCharAt(i, '1');
                        index++;
                    } else {
                        b.setCharAt(i, '1');
                        index++;
                    }
                }
            }
            System.out.println(Integer.parseInt(String.valueOf(a),2)+" " +Integer.parseInt(String.valueOf(b),2));
        }
    }
}
