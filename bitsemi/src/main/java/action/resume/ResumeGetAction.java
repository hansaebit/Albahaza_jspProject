package action.resume;

import action.Action;
import action.ActionForward;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.dao.ResumeDao;
import data.dto.ResumeDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResumeGetAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ActionForward forward = new ActionForward();
        String num = request.getParameter("num");
        String jobofferNum = request.getParameter("joboffernum");

        ResumeDao dao = new ResumeDao();
        ResumeDto resumeDto = dao.getResumeData(num);

        ObjectMapper mapper = new ObjectMapper();
        String json = "";

        json = mapper.writeValueAsString(resumeDto);
        System.out.println(json);

        request.getSession().setAttribute("resume", resumeDto);
        request.getSession().setAttribute("joboffernum", jobofferNum);
        forward.setChangePage(false);
        forward.setPrintData(json);

        return forward;
    }
}
