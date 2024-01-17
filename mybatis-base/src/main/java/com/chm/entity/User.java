package com.chm.entity;

public class User {
    private Integer id;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", garden='" + garden + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    private String name;

    public User() {
    }

    private Integer age;

    public User(Integer id, String name, Integer age, String garden, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.garden = garden;
        this.email = email;
    }

    private String garden;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGarden() {
        return garden;
    }

    public void setGarden(String garden) {
        this.garden = garden;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;
}
