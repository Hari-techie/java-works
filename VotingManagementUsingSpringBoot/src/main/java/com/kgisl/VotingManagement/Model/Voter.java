package com.kgisl.VotingManagement.Model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "voter")
public class Voter {
    @Id
    @Column(name = "voter_id")
    protected String voter_id;

    @Column(name = "name")
    protected String name;

    @Column(name = "email")
    protected String email;

    @Column(name = "password")
    protected String password;

    @Column(name = "age")
    protected int age;

    @Column(name = "gender")
    protected String gender;

    @Column(name = "ward")
    protected String ward;

    public Voter() {
    }

    public Voter(String voter_id, String name, String email, String password, int age, String gender, String ward) {
        this.voter_id = voter_id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.ward = ward;
    }

    public Voter(String voter_id, String name, int age, String gender, String ward) {
        this.voter_id = voter_id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.ward = ward;
    }

    public Voter(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getvoter_id() {
        return voter_id;
    }

    public void setvoter_id(String voter_id) {
        this.voter_id = voter_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    @Override
    public String toString() {
        return "Voter [voter_id=" + voter_id + ", name=" + name + ", email=" + email + ", password=" + password
                + ", age=" + age + ", gender=" + gender + ", ward=" + ward + "]";
    }
}
