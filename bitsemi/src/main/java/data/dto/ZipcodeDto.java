package data.dto;

public class ZipcodeDto implements Dto
{
    private String num;
    private String gu;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getGu() {
        return gu;
    }

    public void setGu(String gu) {
        this.gu = gu;
    }
}
