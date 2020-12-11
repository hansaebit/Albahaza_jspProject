package action.joboffer;

import action.Action;
import action.ActionFactory;
import action.ActionForward;
import action.Category;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.dao.JobofferDao;
import data.dto.JobofferDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JobofferUpdateAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ActionForward forward = new ActionForward();
        JobofferDao jobofferDao = new JobofferDao();
        JobofferDto jobofferDto = (JobofferDto) ActionFactory.getDto(Category.Joboffer, request);
        String json = "";
        ObjectMapper mapper = new ObjectMapper();

        json = mapper.writeValueAsString(jobofferDto);
        System.out.println("jobofferDto 1111 : " + json);
        jobofferDao.updateJoboffer(jobofferDto);

        request.getSession().setAttribute("joboffer", jobofferDto);

        forward.setChangePage(false);
        forward.setPrintData(json);
        return forward;
    }
}
