package bufferbuilder;

import org.junit.Test;

public class BufferBuilderMethod {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("Hello");

        // 追加
//        str.append("a");
//        str.append(1);

        // 删除
//        str.delete(4, 5);

        // 替换
//        str.replace(2, 4, "qwe");

        // 插入
//        str.insert(1, 123);

        // 反转字符序列
//        str.reverse();

        // 修改指定索引位置的字符
        str.setCharAt(2, 't');
        System.out.println(str);
    }
}
