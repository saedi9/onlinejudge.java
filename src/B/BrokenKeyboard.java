package B;

import java.util.LinkedList;
import java.util.Scanner;

public class BrokenKeyboard {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s=sc.nextLine();
            LinkedList<Character> list=new LinkedList<>();
            int index = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '[') {
                    index = 0;
                } else if (s.charAt(i) == ']') {
                    index = list.size();
                }
                else {
                    list.add(index,s.charAt(i));
                    index++;
                }
            }
            StringBuilder se=new StringBuilder();
            for (char x: list) { se.append(x);}
            System.out.println(se);
        }
    }
}
