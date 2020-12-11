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

public class JobofferSearchAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ActionForward forward = new ActionForward();
        JobofferDto dto = (JobofferDto) ActionFactory.getDto(Category.Joboffer, request);
        JobofferDao dao = new JobofferDao();
        ObjectMapper mapper = new ObjectMapper();

        String attribute = null;//검색 옵션
        String param = null; //검색 값
        dao.getSearchJoboffer(param);
        String json = mapper.writeValueAsString(dto);

        forward.setPrintData("search-ok");
        forward.setChangePage(false);

        return forward;
    }
}
