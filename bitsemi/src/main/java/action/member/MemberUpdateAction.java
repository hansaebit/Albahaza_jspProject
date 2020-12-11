package action.member;

import action.Action;
import action.ActionFactory;
import action.ActionForward;
import action.Category;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.dao.MemberDao;
import data.dto.MemberDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberUpdateAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
            throws JsonProcessingException {
        ActionForward forward = new ActionForward();
        MemberDto dto = (MemberDto) ActionFactory.getDto(Category.Member, request);
        MemberDao dao = new MemberDao();
        ObjectMapper mapper = new ObjectMapper();
        String json = "";

        if (dao.updateMember((MemberDto) dto)) {
            System.out.println(String.format("update success \nid : %s \nnum : %s"
                    , dto.getId(), dto.getNum()));
            json = mapper.writeValueAsString(dto);
            request.getSession().setAttribute("member", dto);
            forward.setPrintData(json);
            forward.setChangePage(false);
        } else {
            json = "update fail.";
            forward.setPrintData(json);
            forward.setChangePage(false);
        }

        return forward;
    }
}
