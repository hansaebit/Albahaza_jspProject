package data.dto;

import java.sql.Timestamp;

public class MemberDto implements Dto {
    private String num;
    private String id;
    private String pass;
    private String name;
    private String age;

    private String gender;
    private String phonenum;
    private String email;
    private String ishire;
    private String likes;

    private String createday;
    private String matchpoint;

    public MemberDto() {
    }

    public MemberDto(String num, String id, String pass, String name, String age, String gender, String phonenum, String email, String ishire, String likes, String createday, String matchpoint) {
        this.num = num;
        this.id = id;
        this.pass = pass;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phonenum = phonenum;
        this.email = email;
        this.ishire = ishire;
        this.likes = likes;
        this.createday = createday;
        this.matchpoint = matchpoint;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIshire() {
        return ishire;
    }

    public void setIshire(String ishire) {
        this.ishire = ishire;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getCreateday() {
        return createday;
    }

    public void setCreateday(String createday) {
        this.createday = createday;
    }

    public String getMatchpoint() {
        return matchpoint;
    }

    public void setMatchpoint(String matchpoint) {
        this.matchpoint = matchpoint;
    }
}
