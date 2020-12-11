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

public class ResumeSearchAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ActionForward forward = new ActionForward();
        ResumeDto dto = (ResumeDto) ActionFactory.getDto(Category.Resume, request);
        ResumeDao dao = new ResumeDao();
        ObjectMapper mapper = new ObjectMapper();

        String attribute = null;//검색 옵션
        String param = null; //검색 값
        dao.getSearchResume(param);
        String json = mapper.writeValueAsString(dto);

        forward.setPrintData("search-ok");
        forward.setChangePage(false);

        return forward;
    }
}
