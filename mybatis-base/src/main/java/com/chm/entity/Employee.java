package com.chm.entity;

public class Employee {
    private Integer empId;

    private String empName;

    private Integer empAge;

    private String empEmail;

    private Dept dept;

    public Employee(Integer empId, String empName, Integer empAge, String empEmail, Dept dept) {
        this.empId = empId;
        this.empName = empName;
        this.empAge = empAge;
        this.empEmail = empEmail;
        this.dept = dept;
    }

    public Employee() {
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getEmpAge() {
        return empAge;
    }

    public void setEmpAge(Integer empAge) {
        this.empAge = empAge;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empAge=" + empAge +
                ", empEmail='" + empEmail + '\'' +
                ", dept=" + dept +
                '}';
    }
}
