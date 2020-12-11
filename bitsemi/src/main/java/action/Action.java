package action;

import data.dto.Dto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface Action {

//    /**
//     * 리턴될 ActionForward.
//     */
//    public ActionForward forward = new ActionForward();


    /**
     * execute 함수 종료 시, ActionForward 를 작성하여 return 해줘야 합니다.
     * @param request
     * @param response
     * @return If ActionForward were null, throw IllegalArgumentExceiption.
     */
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException;


//    public void insertData(Dto dto);
//    public List getAllData();
//    public void updateData(Dto dto);
//    public void deleteData(String attribute);
//
//    //name 은 각 속성별 이름 입니다. id 가 될수도 있고, name, num 등등..
//    public Dto findByName(String param);
//    public Dto findByName(String attribute, String param);
//
//    public boolean isExist(String param);
//    public boolean isExist(String attribute, String param);



}
