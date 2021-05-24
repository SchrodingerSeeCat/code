package com.valid.responsibilitychain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Client {
    @Test
    @DisplayName("责任链模式")
    public void test() {
        // 创建一个请求
        PurchaseRequest request = new PurchaseRequest(1, 31000, 1);

        // 创建相关的审批人
        DepartmentApprover department = new DepartmentApprover("张主任");
        CollegeApprover college = new CollegeApprover("李院长");
        ViceSchoolMasterApprover viceSchool = new ViceSchoolMasterApprover("王副校长");
        SchoolMasterApprover school = new SchoolMasterApprover("丁校长");

        // 设置下一个处理人(构成环形)
        department.setApprover(college);
        college.setApprover(viceSchool);
        college.setApprover(school);
        school.setApprover(department);

        department.processRequest(request);
    }
}
