package bean;

// 员工类
public class Emp {
    private String empName;
    private String gender;
    // 员工的部门
    private Dept dept;

    public Dept getDept() {
        return dept;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empName='" + empName + '\'' +
                ", gender='" + gender + '\'' +
                ", dept=" + dept +
                '}';
    }
}
