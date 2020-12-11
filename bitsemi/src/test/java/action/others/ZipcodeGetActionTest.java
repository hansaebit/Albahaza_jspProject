package action.others;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.dao.ZipcodeDao;
import data.dto.ZipcodeDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ZipcodeGetActionTest {

    @Test
    void execute() throws JsonProcessingException {
        ZipcodeDao dao = new ZipcodeDao();
        String gu = null;
//                = request.getParameter("gu");
        List<ZipcodeDto> list = null;

        String json = "";
        ObjectMapper mapper = new ObjectMapper();

        if (gu != null) {
            list = dao.getSearchAddress(gu);
            json = mapper.writeValueAsString(list);
            System.out.println(json);
//            forward.setChangePage(false);
//            forward.setPrintData(json);
        } else {
            list = dao.getAllZipcode();
            json = mapper.writeValueAsString(list);
            System.out.println(json);
//            forward.setChangePage(false);
//            forward.setPrintData(json);
        }
    }
}