import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int k = reader.nextInt();
        int m = reader.nextInt();
        Map map = new Map(n, k, m);

        for(int i = 0; i < k; i++) {
            map.setEdge(reader.nextInt() - 1, reader.nextInt() - 1);
        }

        map.toColor();
    }
}
class Map{
    // 顶点个数
    private int n;
    // 边的数目
    private int k;
    // 颜色的数量
    private int m;
    // 邻接矩阵存储边
    private boolean[][] matrix;

    public Map(int n, int k, int m) {
        this.n = n;
        this.k = k;
        this.m = m;
        this.matrix = new boolean[n][n];
    }

    // 设置边
    public void setEdge(int i, int j) {
        matrix[i][j] = true;
        matrix[j][i] = true;
    }

    // 着色
    public void toColor() {
        // 标识图的染色情况
        int[] color = new int[n];
        // 只遍历1/m的情况
        int sum = toColor(0, color, 0);
        System.out.println(sum * m);
    }
    private int toColor(int v, int[] color, int sum) {
        if(v >= n) return ++sum;

        for(int i = 1; i <=m; i++) {
            color[v] = i;
            if(color(v, color)) {
                sum = toColor(v+1, color, sum);
            } else {
                color[v] = 0;
            }
        }
        return sum;
    }

    // 检查顶点v的颜色可用
    private boolean color(int v, int[] color) {
        for(int i = 0; i < n; i++) {
            if(matrix[v][i] && color[i] == color[v]) return false;
        }
        return true;
    }
}