package com.example.ss8.model;

import java.time.LocalDate;

public class Person {
    private int id;
    private String name;
    private Gender gender;
    private int age;
    private LocalDate birthday;

    public Person() {
    }

    public Person(int id, String name, Gender gender, int age, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.birthday = birthday;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }


}
