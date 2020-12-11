package action.member;

import action.Action;
import action.ActionFactory;
import action.ActionForward;
import action.Category;
import data.dao.MemberDao;
import data.dto.MemberDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberDeleteAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
        ActionForward forward = new ActionForward();
        String id = request.getParameter("id");
        MemberDao dao = new MemberDao();
        MemberDto dto = (MemberDto) ActionFactory.getDto(Category.Member, request);
        boolean idCheckResult = dao.isIdCheck(dto.getId());

        if(idCheckResult){
            dao.deleteMember(dto.getId());
            System.out.println("deleteData : " + dto.getId());
            forward.setPrintData("delete success");
            forward.setChangePage(false);
        } else{
            forward.setPrintData("not found id " + dto.getId());
            forward.setChangePage(false);
        }

        return forward;
    }
}
