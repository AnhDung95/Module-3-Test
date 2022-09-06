package com.example.module3test.model;

public class User {
    protected int id;
    protected String name;
    protected String birthDay;
    protected String address;
    protected String phone;
    protected String email;
    protected String Classroom;

    public User(String name, String birthDay, String address, String phone, String email, String Classroom) {
        this.name=name;
        this.birthDay = birthDay;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.Classroom=Classroom;
    }

    public User(int id, String name,String birthDay, String address, String phone, String email,String Classroom) {
//        super();
        this.id = id;
        this.name=name;
        this.birthDay = birthDay;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.Classroom=Classroom;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClassroom() {
        return Classroom;
    }

    public void setClassroom(String classroom) {
        Classroom = classroom;
    }
}
