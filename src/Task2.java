import java.util.ArrayList;
import java.util.Scanner;


public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] xy = new int[m][n];
        int regCount = 2;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                xy[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (xy[i][j] == 1) {
                    markNeighbour(xy, i, j, regCount);
                    regCount++;
                }
            }
        }
        regCount--;
        int maxS = 0;
        int profReg = 0;
        for (int k = 2; k <= regCount; k++) {
            int left = n;
            int up = m;
            int right = 0;
            int bottom = 0;
            int profCount = 0;
            int localS = 0;
            int localProfReg = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (xy[i][j] == k) {
                        left = Math.min(j, left);
                        up = Math.min(i, up);
                        right = Math.max(j, right);
                        bottom = Math.max(i, bottom);
                    }
                }
            }
            for (int i = up; i <= bottom; i++) {
                for (int j = left; j <= right; j++) {
                    if (xy[i][j] > 1) {
                        profCount++;
                    }
                }
            }
            right++;
            bottom++;
            if (profCount < 2) continue;
            localS = (right - left) * (bottom - up);
            localProfReg = (profCount * 100000) / localS;
            System.out.print(k + " " + localS + " " + localProfReg);
            System.out.println("");
            if (localProfReg > profReg) {
                profReg = localProfReg;
                maxS = localS;
            }
            if (localProfReg == profReg) {
                maxS = Math.max(maxS, localS);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(xy[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.println(maxS);
    }

    private static void markNeighbour(int[][] xy, int i, int j, int mark) {
        xy[i][j] = mark;
        ArrayList<Dot> dotsA = new ArrayList<>();
        ArrayList<Dot> dotsB = new ArrayList<>();
        dotsA.add(new Dot(i, j));

        while (!dotsA.isEmpty()) {
            for (Dot dot : dotsA) {
                if (dot.getJ() != 0 && xy[dot.getI()][dot.getJ() - 1] == 1) {
                    xy[dot.getI()][dot.getJ() - 1] = mark;
                    dotsB.add(new Dot(dot.getI(), dot.getJ() - 1));
                }
                if (dot.getI() != 0 && dot.getJ() != 0 && xy[dot.getI() - 1][dot.getJ() - 1] == 1) {
                    xy[dot.getI() - 1][dot.getJ() - 1] = mark;
                    dotsB.add(new Dot(dot.getI() - 1, dot.getJ() - 1));
                }
                if (dot.getI() != 0 && xy[dot.getI() - 1][dot.getJ()] == 1) {
                    xy[dot.getI() - 1][dot.getJ()] = mark;
                    dotsB.add(new Dot(dot.getI() - 1, dot.getJ()));
                }
                if (dot.getI() != 0 && dot.getJ() != xy[0].length - 1 && xy[dot.getI() - 1][dot.getJ() + 1] == 1) {
                    xy[dot.getI() - 1][dot.getJ() + 1] = mark;
                    dotsB.add(new Dot(dot.getI() - 1, dot.getJ() + 1));
                }

                if (dot.getJ() != xy[0].length - 1 && xy[dot.getI()][dot.getJ() + 1] == 1) {
                    xy[dot.getI()][dot.getJ() + 1] = mark;
                    dotsB.add(new Dot(dot.getI(), dot.getJ() + 1));
                }
                if (dot.getI() != xy.length - 1 && dot.getJ() != xy[0].length - 1 && xy[dot.getI() + 1][dot.getJ() + 1] == 1) {
                    xy[dot.getI() + 1][dot.getJ() + 1] = mark;
                    dotsB.add(new Dot(dot.getI() + 1, dot.getJ() + 1));
                }
                if (dot.getI() != xy.length - 1 && xy[dot.getI() + 1][dot.getJ()] == 1) {
                    xy[dot.getI() + 1][dot.getJ()] = mark;
                    dotsB.add(new Dot(dot.getI() + 1, dot.getJ()));
                }
                if (dot.getI() != xy.length - 1 && dot.getJ() != 0 && xy[dot.getI() + 1][dot.getJ() - 1] == 1) {
                    xy[dot.getI() + 1][dot.getJ() - 1] = mark;
                    dotsB.add(new Dot(dot.getI() + 1, dot.getJ() - 1));
                }
            }
            dotsA.clear();
            dotsA.addAll(dotsB);
            dotsB.clear();
        }
    }
}

class Dot {
    private int i;
    private int j;

    public Dot(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
}
