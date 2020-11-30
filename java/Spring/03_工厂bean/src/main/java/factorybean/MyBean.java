package factorybean;

import org.springframework.beans.factory.FactoryBean;

public class MyBean implements FactoryBean<Course> {

    @Override
    public Course getObject() throws Exception {
        // 定义返回bean
        Course course = new Course();
        course.setName("敢问上天是否有仙");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
