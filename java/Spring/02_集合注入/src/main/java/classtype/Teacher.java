package classtype;


import java.util.List;

public class Teacher {
    private List<Course> courses;

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "courses=" + courses +
                '}';
    }
}
