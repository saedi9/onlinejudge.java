package C;

import java.util.*;

public class Containers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String l;
        int x = 1;
        while (!(l = sc.nextLine()).equals("end")) {
            int counter = 1;
            Stack[] list = new Stack[26];
            for (int i = 0; i < 26; i++) {
                list[i] = new Stack();
            }
            list[0].push((int) l.charAt(0));
            for (int i = 1; i < l.length(); i++) {
                boolean flag = true;
                for (int j = 0; j < counter; j++) {
                    if (!list[j].isEmpty() && (int) list[j].peek() >= l.charAt(i)) {
                        list[j].push((int) l.charAt(i));
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    list[counter].push((int) l.charAt(i));
                    counter++;
                }
            }
            System.out.println("Case " + x + ": " + counter);
            x++;
        }
    }
}
