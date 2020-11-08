package enumtest;

import annotationtest.MyAnnotation;

public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 spring = Season1.SPRING;
//        for(int i = 0; i < spring.values().length; i++){
//            System.out.printf("%s ", spring.values()[i]);
//        }
//        System.out.println(spring); // SPRING

//        System.out.println(spring.toString());

//        Season1 summer = Season1.valueOf("SUMMER");
//        System.out.println(summer);
        spring.show();
    }
}
interface Info{
    void show();
}

// jdk5.0之后自定义枚举类
@MyAnnotation("hello")
enum Season1 implements Info{

    SPRING("春天", "春暖花开"){
        @Override
        public void show() {
            System.out.println("我是春天");
        }
    },
    SUMMER("夏天", "夏日炎炎"){
        @Override
        public void show() {
            System.out.println("我是夏天");
        }
    },
    AUTUMN("秋天", "秋高气爽"){
        @Override
        public void show() {
            System.out.println("我是秋天");
        }
    },
    WINTER("冬天", "寒风刺骨"){
        @Override
        public void show() {
            System.out.println("我是冬天");
        }
    };

    private final String seasonName;
    private final String seasonDesc;

    private Season1(String seasonName, String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }
}
