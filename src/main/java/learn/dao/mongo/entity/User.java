package learn.dao.mongo.entity;

import lombok.Data;

@Data
public class User {

    private String username;

    private String password;

    private String registerTime;

    private String phone;

    private String name;

    private String sex;

    private String age;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", registerTime='" + registerTime + '\'' +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}