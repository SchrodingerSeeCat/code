import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MapTest {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        // 读入顶点数和边数
        int size = reader.nextInt();
        int arcNum = reader.nextInt();

        Map<String> map = new Map<>(size, arcNum);

        // 读入顶点
        for(int i = 0; i < size; i++) {
            map.addPoint(reader.next());
        }

        // 读入边
        for(int i = 0; i < arcNum; i++) {
            map.addVex(reader.next(), reader.next());
        }
        // 深度优先搜索
        map.depthFirstSearch();

        System.out.println();

        // 广度优先搜索
        map.breadthFirstSearch();
    }
}

class Map<T>{
    // 顶点表
    private T[] vex;

    // 邻接矩阵
    private int[][] arcs;

    // 点数
    private int size;
    // 容量
    private int capacity;

    // 边数
    private int arcNum;

    public Map(int capacity, int arcNum) {
        this.capacity = capacity;
        this.vex = (T [])(new Object[capacity]);
        this.arcs = new int[capacity][capacity];
        this.arcNum = arcNum;
    }

    // 深度优先搜索
    public void depthFirstSearch() {
        boolean[] visited = new boolean[size];
        depthFirstSearch(0, visited);
    }
    private void depthFirstSearch(int v, boolean[] visited) {
        System.out.print(vex[v] + " ");
        visited[v] = true;
        for(int w = firstAdjVex(v, visited); w >= 0; w = firstAdjVex(v, visited)) {
            depthFirstSearch(w, visited);
        }
    }
    private int firstAdjVex(int v, boolean[] visited) {
        for(int i = 0; i < size; i++) {
            if(arcs[v][i] == 1 && !visited[i]) return i;
        }
        return -1;
    }

    // 广度优先搜索
    public void breadthFirstSearch() {
        boolean[] visited = new boolean[size];
        breadthFirstSearch(0, visited);
    }
    private void breadthFirstSearch(int v, boolean[] visited) {
        System.out.print(vex[v] + " ");
        visited[v] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        while(!queue.isEmpty()) {
            int u = queue.poll();
            for(int w = firstAdjVex(u, visited); w >= 0; w = firstAdjVex(w, visited)) {
                System.out.print(vex[w] + " ");
                visited[w] = true;
                queue.add(w);
            }
        }
    }
    // 添加点
    public void addPoint(T v) {
        if(size >= capacity) {
            throw new RuntimeException("超出最大容量");
        }
        vex[size] = v;
        size++;
    }

    // 添加边
    public void addVex(T v1, T v2) {
        int i = location(v1);
        int j = location(v2);

        arcs[i][j] = 1;
        arcs[j][i] = 1;
    }

    // 查找顶点的位置
    private int location(T v) {
        for(int i = 0; i < size; i++) {
            if(v.equals(vex[i])) return i;
        }
        throw new RuntimeException("输入的顶点不存在");
    }
}
