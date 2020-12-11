package action.member;

import action.Action;
import action.ActionFactory;
import action.ActionForward;
import action.Category;
import com.fasterxml.jackson.databind.ObjectMapper;
import config.ServerConfig;
import data.dao.MemberDao;
import data.dto.MemberDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MemberGetAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        System.out.println("Member Get Action!!");
        ActionForward forward = new ActionForward();
        MemberDto dto = (MemberDto) ActionFactory.getDto(Category.Member, request);
        System.out.println("==============member Get Action===============");
        MemberDao dao = new MemberDao();
        ObjectMapper mapper = new ObjectMapper();   //object -> json
        String json = "";

        if (ServerConfig.isTestMode()) {
//            System.out.println(dto.getId());
        }

        if (dto.getId() != null) {
            dto = dao.getData(dto.getId());
            request.getSession().setAttribute("member", dto);
            json = mapper.writeValueAsString(dto);
            forward.setPrintData(json);
            forward.setChangePage(false);
        } else {
            List<MemberDto> list = dao.getAllData();
            request.getSession().setAttribute("memberlist", list);
            json = mapper.writeValueAsString(list);
            forward.setPrintData(json);
            forward.setChangePage(false);
        }

        return forward;
    }

}
