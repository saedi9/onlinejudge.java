public class test {
    public static void main(String[] args) {
        double dis[][] = new double[4][4];
        int x[] ={1,8,6,1};
        int y[] ={1,6,8,3};
        for (int i = 0; i < 4; i++) {
            dis[i][i] = 0;
            for (int j = i + 1; j < 4; j++) {
                double r = dis(x[i], x[j], y[i], y[j]);
                dis[i][j] = r;
                dis[j][i] = r;
            }
        }
        System.out.println();
    }
    static double dis(int x1, int x2, int y1, int y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
}
