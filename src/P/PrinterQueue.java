package P;

import java.util.*;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt(), index = n - 1, counter = 0, loc = m;
            int[] pr = new int[n];
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                pr[i] = sc.nextInt();
                q.add(pr[i]);
            }
            Arrays.sort(pr);
            while (q.size() != 0) {
                if (index >= 0 && pr[index] == q.peek()) {
                    q.poll();
                    counter++;
                    index--;
                    if (loc == 0) break;
                    loc--;
                } else {
                    q.add(q.poll());
                    loc--;
                }
                if (loc == -1) loc = q.size()-1;
            }
            System.out.println(counter);
        }
    }
}