package data.dto;

/**
 * create table favorites
 * (
 * employeeid  varchar(50) not null,
 * employerid  varchar(50) not null,
 * employeenum int         not null,
 * employernum int         not null,
 * matchday    datetime    ,
 * createday   datetime    not null
 * );
 */
public class FavoritesDto implements Dto {
    private String num;
    private String employeeid;  //구직자 아이디. 멤버.
    private String employerid;  //고용주 아이디. 멤버.
    private String employeenum; //구직자 이력서 넘버.
    private String employernum; //고용주 잡오퍼 넘버.

    private String matchday;
    private String createday;

    public FavoritesDto() {
    }

    public FavoritesDto(String num, String employeeid, String employerid, String employeenum, String employernum, String matchday, String createday) {
        this.num = num;
        this.employeeid = employeeid;
        this.employerid = employerid;
        this.employeenum = employeenum;
        this.employernum = employernum;
        this.matchday = matchday;
        this.createday = createday;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public String getEmployerid() {
        return employerid;
    }

    public void setEmployerid(String employerid) {
        this.employerid = employerid;
    }

    public String getEmployeenum() {
        return employeenum;
    }

    public void setEmployeenum(String employeenum) {
        this.employeenum = employeenum;
    }

    public String getEmployernum() {
        return employernum;
    }

    public void setEmployernum(String employernum) {
        this.employernum = employernum;
    }

    public String getMatchday() {
        return matchday;
    }

    public void setMatchday(String matchday) {
        this.matchday = matchday;
    }

    public String getCreateday() {
        return createday;
    }

    public void setCreateday(String createday) {
        this.createday = createday;
    }
}
