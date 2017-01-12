package com.ann.sql;

import com.ann.sql.interfaces.Column;
import com.ann.sql.interfaces.Table;

/**
 * Created by Administrator on 2017/1/11 0011.
 */
@Table("userinfo")
public class Filter {
    @Column("id")
    private int id;
    @Column("userName")
    private String userName;
    @Column("email")
    private String email;
    @Column("city")
    private String city;
    @Column("age")
    private int age;
    @Column("mobile")
    private String mobile;
    @Column("nickName")
    private String nickName;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
