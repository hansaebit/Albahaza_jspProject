package action.member;

import action.ActionFactory;
import action.ActionForward;
import action.Category;
import data.dao.MemberDao;
import data.dto.MemberDto;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.jupiter.api.Assertions.*;

class MemberLikeActionTest {
    @Test
    void execute() {
        //ActionForward forward = new ActionForward();
        //String loginId = request.getParameter("loginId");
        MemberDao dao = new MemberDao();
        MemberDto dto = new MemberDto(
                "10",
                "yang",
                "1234",
                "yang",
                String.valueOf((int) Math.random() * 100 + 1),
                "male",
                null,//String.format("010-1234-%04d", i),  //공백 채우기.
                null,//"asdf@gmail.com" + i,
                "true",
                String.valueOf((int) Math.random() * 10000),
                "2020-11-28", //Timestamp.valueOf("2020-11-28"),
                "0"
        );

        dao.updateLikes(dto.getId());
        System.out.println("MemberLikeActionId : " + dto.getId());
        //forward.setPrintData(loginId);
        //forward.setChangePage(false);

       // return forward;
    }
}