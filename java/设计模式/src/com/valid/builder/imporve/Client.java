package com.valid.builder.imporve;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Client {

    @DisplayName("测试建造者模式")
    @Test
    public void testHouse() {
        // 房子
        CommonHouse commonHouse = new CommonHouse();

        // 指挥者
        HouseDirector houseDirector = new HouseDirector(commonHouse);

        // 建造房子
        House house = houseDirector.constructHouse();
    }
}
