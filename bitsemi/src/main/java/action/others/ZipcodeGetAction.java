package action.others;

import action.Action;
import action.ActionForward;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.dao.ZipcodeDao;
import data.dto.ZipcodeDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

public class ZipcodeGetAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ActionForward forward = new ActionForward();
        ZipcodeDao dao = new ZipcodeDao();
        String gu = request.getParameter("gu");
        List<ZipcodeDto> list = null;

        String json = "";
        ObjectMapper mapper = new ObjectMapper();

        if (gu != null) {
            list = dao.getSearchAddress(gu);
            json = mapper.writeValueAsString(list);
            forward.setChangePage(false);
            forward.setPrintData(json);
        } else {
            list = dao.getAllZipcode();
            json = mapper.writeValueAsString(list);
            forward.setChangePage(false);
            forward.setPrintData(json);
        }

        return forward;
    }
}
