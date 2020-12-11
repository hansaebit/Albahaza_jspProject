package action.member;

import action.Action;
import action.ActionFactory;
import action.ActionForward;
import action.Category;
import data.dao.MemberDao;
import data.dto.MemberDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberAddAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
        ActionForward forward = new ActionForward();
        MemberDto dto = (MemberDto) ActionFactory.getDto(Category.Member, request);
        MemberDao dao = new MemberDao();

        boolean idCheckResult = dao.isIdCheck(dto.getId());
        if (!idCheckResult) {
            dao.insertMember(dto);
            forward.setPrintData("yes");
            forward.setChangePage(false);
        } else {
            forward.setPrintData("no");
            forward.setChangePage(false);
        }

        return forward;
    }
}
