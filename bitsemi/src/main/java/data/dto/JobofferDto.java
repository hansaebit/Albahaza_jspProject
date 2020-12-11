package data.dto;

import java.sql.Timestamp;

public class JobofferDto implements Dto {
    private String num;
    private String id;
    private String companyname;        //추가
    private String phonenum;            //추가
    private String location;

    private String jobtype;
    private String abletime;
    private String introduce;
    private String pay;
    private String writeday;

    private String needpeople;  //프론트에서 이것도 받아야함. 몇명필요?

    //구직자가 지원하면 일단 넣었다가, 뽑히면 뽑힌사람만 업데이트되도록. List<String> 을 toString() 한 값.
    private String applicant;

    private String xpoint;      //추가
    private String ypoint;      //추가
    private String term;

    public JobofferDto() {
    }

    public JobofferDto(String num, String id, String companyname, String phonenum, String location, String jobtype, String abletime, String introduce, String pay, String writeday, String needpeople, String applicant, String xpoint, String ypoint, String term) {
        this.num = num;
        this.id = id;
        this.companyname = companyname;
        this.phonenum = phonenum;
        this.location = location;
        this.jobtype = jobtype;
        this.abletime = abletime;
        this.introduce = introduce;
        this.pay = pay;
        this.writeday = writeday;
        this.needpeople = needpeople;
        this.applicant = applicant;
        this.xpoint = xpoint;
        this.ypoint = ypoint;
        this.term = term;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getXpoint() {
        return xpoint;
    }

    public void setXpoint(String xpoint) {
        this.xpoint = xpoint;
    }

    public String getYpoint() {
        return ypoint;
    }

    public void setYpoint(String ypoint) {
        this.ypoint = ypoint;
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

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getWriteday() {
        return writeday;
    }

    public void setWriteday(String writeday) {
        this.writeday = writeday;
    }

    public String getNeedpeople() {
        return needpeople;
    }

    public void setNeedpeople(String needpeople) {
        this.needpeople = needpeople;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }
}
