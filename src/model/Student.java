package model;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
    private String id;
    private String name;
    private Date birthDay;
    private String sex;
    private String village;
    private String phoneNumber;

    public Student() {
    }

    public Student(String id, String name, Date birthDay, String sex, String village, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.sex = sex;
        this.village = village;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthDay=" + birthDay +
                ", sex='" + sex + '\'' +
                ", village='" + village + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
