package action.resume;

import action.Action;
import action.ActionFactory;
import action.ActionForward;
import action.Category;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.dao.ResumeDao;
import data.dto.ResumeDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResumeUpdateAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ActionForward forward = new ActionForward();
        ResumeDao resumeDao = new ResumeDao();
        ResumeDto resumeDto = (ResumeDto) ActionFactory.getDto(Category.Resume, request);
        String json = "";
        ObjectMapper mapper = new ObjectMapper();

        json = mapper.writeValueAsString(resumeDto);
        System.out.println("resumeDto 1111 : " + json);
        resumeDao.updateResume(resumeDto);

        request.getSession().setAttribute("resume", resumeDto);

        forward.setChangePage(false);
        forward.setPrintData(json);
        return forward;
    }
}
