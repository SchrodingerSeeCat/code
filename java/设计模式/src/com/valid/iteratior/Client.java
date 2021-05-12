package com.valid.iteratior;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class Client {
    @Test
    @DisplayName("迭代器模式")
    public void test() {
        // 创建学院
        List<College<Department>> list = new LinkedList<>();

        // 创建系
        ComputerCollege computerCollege = new ComputerCollege();
        InfoCollege infoCollege = new InfoCollege();
        list.add(computerCollege);
        list.add(infoCollege);

        // 打印
        OutPutImpl outPut = new OutPutImpl(list);
        outPut.printCollege();

    }
}
