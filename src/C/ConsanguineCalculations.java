package C;

import java.util.*;

public class ConsanguineCalculations {
    static HashMap<String, String> com;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        com = new HashMap<>();
        com.put("A", "AO");com.put("AB", "AB");com.put("B", "BO");com.put("O", "OO");com.put("AA", "A");
        com.put("AO", "A");com.put("BB", "B");com.put("BO", "B");com.put("OO", "O");com.put("+", "+-");
        com.put("-", "--");com.put("++", "+");com.put("+-", "+");com.put("--", "-");
        String[] pa = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};

        String a,b,c;
        int ca = 1;
        while (true) {
            a=sc.next();b=sc.next();c=sc.next();
            if(a.equals("E"))break;
            Set<String> re;
            System.out.print("Case " + ca + ": ");
            String res;
            if (c.equals("?")) {
                System.out.print(a + " " + b + " ");
                re = com_gen(a, b);
                System.out.print(toStr(re));
            } else {
                Set<String> p = new HashSet<>();
                if (b.equals("?")) {
                    for (int i = 0; i < 8; i++) {
                        Set<String> tem = com_gen(a, pa[i]);
                        for (String x : tem) {
                            if (x.equals(c)) p.add(pa[i]);
                        }
                    }
                    System.out.print(a + " " + toStr(p) + " " + c);
                } else {
                    for (int i = 0; i < 8; i++) {
                        Set<String> tem = com_gen(b, pa[i]);
                        for (String x : tem) {
                            if (x.equals(c)) p.add(pa[i]);
                        }
                    }
                    System.out.print(toStr(p) + " " + b + " " + c);
                }
            }
            System.out.println();
            ca++;
        }
    }

    static Set<String> com_gen(String a, String b) {
        StringBuilder d = new StringBuilder("  "), e = new StringBuilder(" "), f = new StringBuilder(" ");
        e.setCharAt(0, a.charAt(a.length() - 1));
        f.setCharAt(0, b.charAt(b.length() - 1));
        a = com.get(a.substring(0, a.length() - 1));
        b = com.get(b.substring(0, b.length() - 1));
        Set<String> S = new HashSet<>(), s = new HashSet<>(), res = new HashSet<>();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                d.setCharAt(0, min(a.charAt(i), b.charAt(j)));
                d.setCharAt(1, max(a.charAt(i), b.charAt(j)));
                S.add(com.get(String.valueOf(d)));
            }
        }
        a = com.get(String.valueOf(e));
        b = com.get(String.valueOf(f));
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                d.setCharAt(0, min(a.charAt(i), b.charAt(j)));
                d.setCharAt(1, max(a.charAt(i), b.charAt(j)));
                s.add(com.get(String.valueOf(d)));
            }
        }
        for (String t : S)
            for (String rh : s)
                res.add((t + rh));
        return res;

    }

    static char max(char a, char b) {
        if (a > b) {
            return a;
        } else return b;
    }

    static char min(char a, char b) {
        if (a < b) return a;
        else return b;
    }

    static String toStr(Set<String> S) {
        int k = 0;
        StringBuilder sb = new StringBuilder();
        if (S.isEmpty()) {
            sb.append("IMPOSSIBLE");
            return sb.toString();
        }
        if (S.size() > 1) sb.append("{");
        k = 0;
        for (String b : S) {
            if (++k > 1) sb.append(", ");
            sb.append(b);
        }
        if (S.size() > 1) sb.append("}");
        return sb.toString();
    }
}
