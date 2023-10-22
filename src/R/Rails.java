package R;

import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Stream;

public class Rails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            sc.nextLine();
            if (n == 0) {
                break;
            }
            while (true) {
                int x = n;
                int[] coaches = Stream.of(sc.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
                if (coaches[0] == 0) break;
                Stack<Integer> st = new Stack<>();
                for (int i = x - 1; i >= 0; i--) {
                    st.push(coaches[i]);
                    while (st.size()!=0 && st.peek()==x){
                        st.pop();
                        x--;
                    }
                }
                if (st.isEmpty()) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
            System.out.println();
        }
    }
}
