
package main2;

import java.util.Arrays;
import java.util.PriorityQueue;
//定义节点中的参数以及优先级设置的对象
class Node implements Comparable<Node>{
    int weight;//该节点目前背包中的重量
    double value;//该节点目前背包中的总价值
    double upprofit;//该节点能够达到的价值上界
    int Left; 	//该节点是否属于左节点（用于最终构造最优解）
    int level;  //该节点是第几个物品的选择
    Node father; //该节点的父节点

    public int compareTo(Node node){
        if(this.upprofit<node.upprofit)
            return 1;
        else if(this.upprofit == node.upprofit)
            return 0;
        else
            return -1;
    }
}
public class Main {
    int n = 5;
    int capacity = 10;
    int[] weight = {2,6,4,1,5};
    double[] value = {6,9,6,1,4};
    int maxValue = 0;
    int[] bestWay = new int[n];
    public void getMaxValue(){
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        //构造一个初始化节点，属于-1层
        Node node = new Node();
        node.level = -1;
        node.upprofit = 26;
        pq.add(node);
        while(!pq.isEmpty()){
            Node fatherNode = pq.poll();
            //当已经搜索到叶子节点时
            if(fatherNode.level == n-1){
                if(fatherNode.value > maxValue){
                    maxValue = (int)fatherNode.value;
                    for(int i=n-1;i>=0;i--){
                        bestWay[i] = fatherNode.Left;
                        fatherNode = fatherNode.father;
                    }
                }
            }
            else{
                //先统计其左节点信息，判断是否加入队列。
                if(weight[fatherNode.level+1]+fatherNode.weight <= capacity){
                    Node newNode = new Node();
                    newNode.level = fatherNode.level+1;
                    newNode.value = fatherNode.value + value[fatherNode.level+1];
                    newNode.weight = weight[fatherNode.level+1]+fatherNode.weight;
                    newNode.upprofit = Bound(newNode);
                    newNode.father = fatherNode;
                    newNode.Left = 1;
                    if(newNode.upprofit > maxValue)
                        pq.add(newNode);
                }
                //向右节点搜索，其能够取到的价值上界通过父亲节点的上界减去本层物品的价值。
                if((fatherNode.upprofit - value[fatherNode.level+1])> maxValue){
                    Node newNode2 = new Node();
                    newNode2.level = fatherNode.level+1;
                    newNode2.value = fatherNode.value;
                    newNode2.weight = fatherNode.weight;
                    newNode2.father = fatherNode;
                    newNode2.upprofit = fatherNode.upprofit - value[fatherNode.level+1];
                    newNode2.Left = 0;
                    pq.add(newNode2);
                }

            }
        }
    }
    //用于计算该节点的最高价值上界
    public double Bound(Node no){
        double maxLeft = no.value;
        int leftWeight = capacity - no.weight;
        int templevel = no.level;
        //尽力依照单位重量价值次序装剩余的物品
        while(templevel <= n-1 && leftWeight > weight[templevel] ){
            leftWeight -= weight[templevel];
            maxLeft += value[templevel];
            templevel++;
        }
        //不能装时，用下一个物品的单位重量价值折算到剩余空间。
        if( templevel <= n-1){
            maxLeft += value[templevel]/weight[templevel]*leftWeight;
        }
        return maxLeft;
    }
    public static void main(String[] args){
        Main b = new Main();
        b.getMaxValue();
        System.out.println("该背包能够取到的最大价值为:"+b.maxValue);
        System.out.println(Arrays.toString(b.bestWay));
        for(int i : b.bestWay)
            System.out.print(i+"  ");
    }
}