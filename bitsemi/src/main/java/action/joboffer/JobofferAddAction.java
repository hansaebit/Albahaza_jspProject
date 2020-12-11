package action.joboffer;

import action.Action;
import action.ActionFactory;
import action.ActionForward;
import action.Category;
import data.dao.JobofferDao;
import data.dto.JobofferDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JobofferAddAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ActionForward forward = new ActionForward();
        JobofferDto dto = (JobofferDto) ActionFactory.getDto(Category.Joboffer, request);
        JobofferDao dao = new JobofferDao();

        dao.insertJoboffer(dto);
        forward.setPrintData("insert-ok");
        forward.setChangePage(false);

        return forward;
    }
}
