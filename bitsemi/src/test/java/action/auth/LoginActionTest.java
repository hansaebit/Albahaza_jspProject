package action.auth;

import data.dao.MemberDao;
import data.dto.MemberDto;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.*;

class LoginActionTest {

    @Test
    void execute() {
        MemberDto dto = new MemberDto(
                "",
                "yang12",
                "1234",
                "yang",
                null,//String.valueOf((int) Math.random() * 100 + 1),
                "male",
                null,//String.format("010-1234-%04d", i),  //공백 채우기.
                "asdf@gmail.com",
                "true",
                null,//String.valueOf((int) Math.random() * 10000),
                "2020-11-28", //Timestamp.valueOf("2020-11-28"),
                "0"

        );

        MemberDao dao = new MemberDao();
        int n = dao.loginProcess(dto.getId(), dto.getPass());

        if(n==1){
            //아이디가 없는 경우
//            response.setContentType("text/html; charset=UTF-8");
//            PrintWriter out = response.getWriter();
            System.out.println("<script>alert('아이디가 존재하지 않습니다'); history.go(-1)</script>");
        }else if(n==2){
            //비밀번호가 틀린 경우
//            response.setContentType("text/html; charset=UTF-8");
//            PrintWriter out = response.getWriter();
            System.out.println("<script>alert('비밀번호가 일치하지 않습니다'); history.go(-1)</script>");

        }else{
            //아이디와 비밀번호가 맞는 경우
//           response.setContentType("text/html; charset=UTF-8");
//            PrintWriter out = response.getWriter();
            System.out.println("로그인성공");
//            HttpSession session = request.getSession();
//            session.setAttribute("loginok","success");
//            session.setAttribute("loginId",loginid);
//            session.setAttribute("password",password);

        }
    }
}