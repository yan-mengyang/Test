package com.ymy.entity;

public class User {


    private   int id;
    private  String  username;
    private  int age;
    private  String sexid;
    private  int department;
    private  String birthday;
    private String  departmentname;

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSexid() {
        return sexid;
    }

    public void setSexid(String sexid) {
        this.sexid = sexid;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", sexid='" + sexid + '\'' +
                ", department=" + department +
                ", birthday='" + birthday + '\'' +
                ", departmentname='" + departmentname + '\'' +
                '}';
    }
}
