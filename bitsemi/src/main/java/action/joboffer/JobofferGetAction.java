package action.joboffer;

import action.Action;
import action.ActionForward;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.dao.JobofferDao;
import data.dao.ResumeDao;
import data.dto.JobofferDto;
import data.dto.ResumeDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JobofferGetAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ActionForward forward = new ActionForward();
        String num = request.getParameter("num");
        JobofferDao dao = new JobofferDao();
        JobofferDto jobofferDto = dao.getData(num);

        ObjectMapper mapper = new ObjectMapper();
        String json = "";

        json = mapper.writeValueAsString(jobofferDto);
        System.out.println(json);

        request.getSession().setAttribute("joboffer", jobofferDto);
        forward.setChangePage(false);
        forward.setPrintData(json);

        return forward;
    }
}
