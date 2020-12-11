package data.dto;

public class ResumeDto implements Dto {
    private String num;
    private String id;
    private String name;
    private String phonenum;
    private String location;

    private String jobtype;
    private String abletime;
    private String introduce;
    private String career;
    private String isclose;

    private String term;
    private String writeday;

    public ResumeDto() {
    }

    public ResumeDto(String num, String id, String name, String phonenum, String location, String jobtype, String abletime, String introduce, String career, String isclose, String term, String writeday) {
        this.num = num;
        this.id = id;
        this.name = name;
        this.phonenum = phonenum;
        this.location = location;
        this.jobtype = jobtype;
        this.abletime = abletime;
        this.introduce = introduce;
        this.career = career;
        this.isclose = isclose;
        this.term = term;
        this.writeday = writeday;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJobtype() {
        return jobtype;
    }

    public void setJobtype(String jobtype) {
        this.jobtype = jobtype;
    }

    public String getAbletime() {
        return abletime;
    }

    public void setAbletime(String abletime) {
        this.abletime = abletime;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getIsclose() {
        return isclose;
    }

    public void setIsclose(String isclose) {
        this.isclose = isclose;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getWriteday() {
        return writeday;
    }

    public void setWriteday(String writeday) {
        this.writeday = writeday;
    }
}
