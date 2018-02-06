package com.github.yt.example.member.domain;

import com.github.yt.mybatis.domain.BaseEntity;

import javax.persistence.Transient;

@javax.persistence.Table(name = "MemberT")
public class MemberT extends BaseEntity<MemberT> {

    @javax.persistence.Id
    private String memberId;

    private String userName;

    private Boolean sex;

    private Integer age;

    private String password;

    private String email;

    private String phone;

    @Transient
    private String cardName;

    public String getMemberId() {
        return memberId;
    }

    public MemberT setMemberId(String memberId) {
        this.memberId = memberId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public MemberT setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public Boolean getSex() {
        return sex;
    }

    public MemberT setSex(Boolean sex) {
        this.sex = sex;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public MemberT setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public MemberT setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public MemberT setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public MemberT setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
}
