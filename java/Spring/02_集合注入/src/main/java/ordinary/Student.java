package ordinary;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {
    // 数组类型
    private String[] courses;

    // list集合类型
    private List<String> name;

    // Map类型
    private Map<String, String> map;

    // Set类型
    private Set<String> set;

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    @Override
    public String toString() {
        return "Student{" +
                "courses=" + Arrays.toString(courses) +
                ", name=" + name +
                ", map=" + map +
                ", set=" + set +
                '}';
    }
}
