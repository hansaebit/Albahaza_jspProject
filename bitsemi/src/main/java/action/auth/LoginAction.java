package action.auth;

import action.Action;
import action.ActionForward;
import data.dao.MemberDao;
import data.dto.MemberDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ActionForward forward = new ActionForward();
        response.setContentType("text/html; charset=UTF-8");
        String loginid = request.getParameter("loginId");
        String password = request.getParameter("password");
        MemberDao dao = new MemberDao();
        MemberDto memberDto = null;
        int n = dao.loginProcess(loginid, password);

        if (n == 1) {
            //아이디가 없는 경우
            forward.setPrintData("NOID");
            forward.setChangePage(false);

        } else if (n == 2) {
            //비밀번호가 틀린 경우
            forward.setPrintData("NOPASS");
            forward.setChangePage(false);

        } else {
            //아이디와 비밀번호가 맞는 경우
            memberDto = dao.getData(loginid);
            request.getSession().setAttribute("member", memberDto);
            request.getSession().setAttribute("loginid", loginid);
            request.getSession().setAttribute("loginok", "success");

            forward.setPrintData(loginid);
            forward.setChangePage(false);

        }

        return forward;
    }
}
