package com.ymy.entity;

public class Department {

    private  int id;
    private  String  departmentname;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    @Override
    public String toString() {
        return "department{" +
                "id=" + id +
                ", departmentname='" + departmentname + '\'' +
                '}';
    }
}
