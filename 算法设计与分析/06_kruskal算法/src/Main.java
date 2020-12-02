import org.junit.Test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt(); // 道路条数
        int m = reader.nextInt();// 村庄数目
        int[][] edge = new int[m][m]; // 邻接矩阵

        // 读入节点
        for(int i = 0; i < n; i++) {
            edge[reader.nextInt() - 1][reader.nextInt() - 1] = reader.nextInt();
        }
        System.out.println(prim(edge));;
    }

    public static int prim(int[][] edge) {
        // 村庄的个数
        int m = edge.length;

        // 记录生成树的总权值
        int sum = 0;
        // 记录集合S(原始节点的集合)中各顶点到集合T(生成树节点集合)最小的边的权值
        int[] lowCost = new int[m];

        // 记录集合S中各顶点到集合T内哪个顶点最近 -1 表示顶点i属于T
        int[] nearVex = new int[m];
        for(int i = 0; i < m; i++) {
            lowCost[i] = edge[0][i];
        }

        // 在lowCost中找最小值
        for(int i = 0; i < m; i++) {
            int min = -1;
            int v = -1;

            for(int j = 0; j < m; j++) {
                if(nearVex[j] != -1 && (lowCost[j] < min || min == -1)) {
                    v = j;
                    min = lowCost[j];
                }
            }

            // 找到最小值得边
            if(v != -1) {
                nearVex[v] = -1;
                sum += lowCost[v];

                for(int j = 0; j < m; j++) {
                    if(nearVex[j] != -1 && edge[v][j] < lowCost[j]) {
                        lowCost[j] = edge[v][j];
                        nearVex[j] = v;
                    }
                }
            }
        }
        return sum;
    }
}

