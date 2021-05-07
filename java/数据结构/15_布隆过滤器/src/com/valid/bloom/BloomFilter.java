package com.valid.bloom;

public class BloomFilter<T> {

    private int bitSize; // 二进制向量的长度

    // 二进制向量
    private long[] bits;
    private int hashSize; // 哈希函数的个数
    // n数据规模
    // 误判率
    public BloomFilter(int n, double p) {
        if (n <= 0 || p <= 0 || p>= 1) {
            throw new IllegalArgumentException("参数错误");
        }

        double ln2 = Math.log(2);
        bitSize = (int)(-(n * Math.log(p)) / (ln2 * ln2));      // 求解二进制向量的长度
        hashSize = (int) (bitSize * ln2 / n);                   // 哈希函数的个数
        bits = new long[(bitSize + Long.SIZE - 1) / Long.SIZE]; // 计算bits数组的长度
    }

    // 添加元素
    public void put(T value) {
        nullCheck(value);

        // 利用value生成两个整数
        int hash1 = value.hashCode(); // 获取value的hashcode
        int hash2 = hash1 >>> 16; // 获取value的hashcode
        for (int i = 1; i <= hashSize; i++) {
            int combinedHash = hash1 + (i * hash2);
            if (combinedHash < 0) {
                combinedHash = ~combinedHash;
            }
            int index = combinedHash % bitSize; // 求取索引
            System.out.println("put: " + index);
            // 设置index位置为1
            set(index);
        }
    }

    // 判断一个元素是否存在
    public boolean contains(T value) {
        nullCheck(value);

        // 利用value生成两个整数
        int hash1 = value.hashCode(); // 获取value的hashcode
        int hash2 = hash1 >>> 16; // 获取value的hashcode
        for (int i = 1; i <= hashSize; i++) {
            int combinedHash = hash1 + (i * hash2);
            if (combinedHash < 0) {
                combinedHash = ~combinedHash;
            }
            int index = combinedHash % bitSize; // 求取索引
            System.out.println("con: " + index);
            // 查看index位置的二进制位是否为0
            if (!get(index)) return false;
        }

        return true;
    }

    // 设置index位置的二进制位为1
    private void set(int index) {
        bits[index / Long.SIZE] = bits[index / Long.SIZE] | (1 << (index % Long.SIZE));
    }

    // 获取index位置的二进制位是否为0
    // true代表1，false代表0
    private boolean get(int index) {
        return (bits[index / Long.SIZE] & (1 << (index % Long.SIZE))) != 0;
    }

    private void nullCheck(T value) {
        if (value == null) {
            throw new IllegalArgumentException("元素不能为空");
        }
    }
}
