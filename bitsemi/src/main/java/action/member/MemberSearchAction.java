package action.member;

import action.Action;
import action.ActionFactory;
import action.ActionForward;
import action.Category;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.dao.MemberDao;
import data.dto.MemberDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSearchAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ActionForward forward = new ActionForward();
        MemberDto dto = (MemberDto) ActionFactory.getDto(Category.Member, request);
        MemberDao dao = new MemberDao();
        ObjectMapper mapper = new ObjectMapper();

        String attribute = null;//검색 옵션
        String param = null; //검색 값
        dao.getSearchMember(param);
        String json = mapper.writeValueAsString(dto);

        forward.setPrintData("search-ok");
        forward.setChangePage(false);

        return forward;
    }
}
