package interfaceexercise;
/*
* 定义一个ComparableCircle类，继承Circle类并实现CompareObject接口
* 在ComparableCircle类中给出接口中方法compareTo的实现体，用来比较两个圆的半径大小
* */
public class ComparableCircle extends Circle implements CompareObject{

    @Override
    public int compareTo(Object o) {
        if(this == o) return 0;
        if(o instanceof  ComparableCircle) {
            ComparableCircle c = (ComparableCircle)o;

            // 第一种实现
//            if(this.getRadius() > c.getRadius()) {
//                return 1;
//            } else if(this.getRadius() < c.getRadius()) {
//                return -1;
//            }
//            return 0;

            // 第二种实现
            // 需要改成Double包装类
            return this.getRadius().compareTo(c.getRadius());
        }
        throw  new RuntimeException("类型不匹配");
    }

    public ComparableCircle(double radius) {
        super(radius);
    }
}
