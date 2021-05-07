package com.valid.skip;

import org.w3c.dom.Node;

import java.util.Comparator;

public class SkipList<K, V>{
    private static final int MAX_LEVEL = 32; // 跳表的最大层级
    private static final double P = 0.25;    // 随机生成next数组长度的概率
    private int size;                        // 跳表的长队
    private final Comparator<K> comparator;  // 比较器
    private Node<K, V> first;                // 头节点
    private int level;                       // 有效层数

    // Key必须是可比较的
    public SkipList(Comparator<K> comparator) {
        this.comparator = comparator;
        first = new Node(null, null, MAX_LEVEL);
    }

    public SkipList() {
        this(null);
    }

    // 跳表的大小
    public int size() {
        return size;
    }

    // 跳表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 加入元素
    public V put(K key, V value) {
        keyCheck(key);

        Node<K, V> node = first;              // 头节点
        Node<K, V>[] pres = new Node[level]; // 保存前驱节点
        for(int i = level - 1; i >= 0; i--) {
            int cmp = -1;
            while(node.next[i] != null && (cmp = compare(key, node.next[i].key)) > 0) {
                node = node.next[i];        // 遍历某一个跳表
            }
            if (cmp == 0) { // 节点存在，覆盖
                V old = node.next[i].value;
                node.next[i].value = value;
                return old;
            }
            pres[i] = node;
        }

        // 添加新节点
        int newLevel = randomLevel();
        Node<K, V> newNode = new Node<>(key, value, newLevel);
        // 设置前驱和后继
        for (int i = 0; i < newLevel; i++) {
            if (i >= level) {
                first.next[i] = newNode;
            } else {
                newNode.next[i] = pres[i].next[i];
                pres[i].next[i] = newNode;
            }
        }
        // 计算跳表的最终层数
        size++;
        level = Math.max(level, newLevel);
        return null;
    }

    // 获取元素
    public V get(K key) {
        keyCheck(key);

        Node<K, V> node = first;
        for(int i = level - 1; i >= 0; i--) {
            int cmp = -1;
            while(node.next[i] != null && (cmp = compare(key, node.next[i].key)) > 0) {
                node = node.next[i];        // 遍历某一个跳表
            }
            if (cmp == 0) {
                return node.next[i].value;
            }
        }
        return null;
    }

    // 移除元素
    public V remove(K key) {
        keyCheck(key);

        Node<K, V> node = first;              // 头节点
        Node<K, V>[] pres = new Node[level]; // 保存前驱节点
        boolean exits = true;
        for(int i = level - 1; i >= 0; i--) {
            int cmp = -1;
            while(node.next[i] != null && (cmp = compare(key, node.next[i].key))> 0) {
                node = node.next[i];        // 遍历某一个跳表
            }
            if (cmp == 0) { // 判断待删除的元素是否存在
                exits = false;
            }
            pres[i] = node;
        }

        if (exits) return null;

        // 删除元素
        size--;
        Node<K, V> removeNode = node.next[0];

        // 设置后继
        for (int i = 0; i < removeNode.next.length; i++) {
            pres[i].next[i] = removeNode.next[i];
        }
        // 更新跳表的level
        int newLevel = level;
        while (--newLevel >= 0 && first.next[newLevel] == null) {
            level = newLevel;
        }

        return node.next[0].value;
    }

    // 随机生成next数组的层数
    private int randomLevel() {
        int level = 1;
        while (Math.random() < P && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }

    // 比较方法
    private int compare(K k1, K k2) {
        return comparator != null
                ? comparator.compare(k1, k2)
                : ((Comparable<K>)k1).compareTo(k2);
    }

    // 空值检测
    private void keyCheck(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key 不允许为空");
        }
    }

    private static class Node<K, V> {
        K key;             // 节点的键
        V value;           // 节点的值
        Node<K, V>[] next; // 节点的next

        public Node(K key, V value, int level) {
            this.key = key;
            this.value = value;
            next = new Node[level];
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = level - 1; i >= 0; i--) {
            Node<K, V> node = first;
            while (node.next[i] != null) {
                sb.append(node.next[i].key);
                sb.append(" ");
                node = node.next[i];
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
