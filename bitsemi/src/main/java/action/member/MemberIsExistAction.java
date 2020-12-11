package action.member;

import action.Action;
import action.ActionFactory;
import action.ActionForward;
import action.Category;
import data.dao.MemberDao;
import data.dto.MemberDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MemberIsExistAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
        ActionForward forward = new ActionForward();
        MemberDto dto = (MemberDto) ActionFactory.getDto(Category.Member, request);
        MemberDao dao = new MemberDao();
        boolean isCheckResult = false;

        if (dto.getId() != null) {
            isCheckResult = dao.isIdCheck(dto.getId());

            if (isCheckResult) {
                forward.setChangePage(false);
                forward.setPrintData("true");
            } else {
                forward.setChangePage(false);
                forward.setPrintData("false");
            }
        } else {
            forward.setChangePage(false);
            forward.setPrintData("false");
        }

        return forward;
    }

}
