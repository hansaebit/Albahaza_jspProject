package action.resume;

import action.Action;
import action.ActionFactory;
import action.ActionForward;
import action.Category;
import data.dao.ResumeDao;
import data.dto.ResumeDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResumeAddAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ActionForward forward = new ActionForward();
        ResumeDto dto = (ResumeDto) ActionFactory.getDto(Category.Resume, request);
        ResumeDao dao = new ResumeDao();

        dao.insertResume(dto);
        forward.setPrintData("yes");
        forward.setChangePage(false);

        return forward;
    }
}
