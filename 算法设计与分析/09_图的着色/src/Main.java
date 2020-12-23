import java.util.Scanner;
import java.util.function.Consumer;

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

        map.depthFirstSearch();
    }
}
class Map{
    // 顶点个数
    private int n;
    // 边的数目
    private int k;
    // 颜色的数量
    private int m;
    // 临界矩阵存储边
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
    }


    public void toColor() {
        boolean[] visited = new boolean[n];

        int[] color = new int[n];

        toColor(0, visited, color);
    }
    private void toColor(int v, boolean[] visited, int[] color) {
        // 拿到某个节点，首先输出


        // 将其的标志位设置为true
        visited[v] = true;

        for(int i  = firstColor(v, visited, color); i >= 0; i = firstColor(v, visited, color)) {
            toColor(i, visited, color);
        }
    }
    private int firstColor(int v, boolean[] visited, int[] color) {
        for(int i = 0; i < n; i++) {
            // 找第一个未被访问过的节点
            if(matrix[v][i] && !visited[i]) return i;
        }
        return -1;
    }


    public void depthFirstSearch() {
        boolean[] visited = new boolean[n];
        depthFirstSearch(0, visited, e -> {
            System.out.print(e + 1 + " ");
        });
    }

    private void depthFirstSearch(int v, boolean[] visited, Consumer<Integer> con) {
        // 拿到某个节点，首先输出
        con.accept(v);
        // 将其的标志位设置为true
        visited[v] = true;

        for(int i  = first(v, visited); i >= 0; i = first(v, visited)) {
            depthFirstSearch(i, visited, con);
        }
    }

    private int first(int v, boolean[] visited) {
        for(int i = 0; i < n; i++) {
            // 找第一个未被访问过的节点
            if(matrix[v][i] && !visited[i]) return i;
        }
        return -1;
    }
}