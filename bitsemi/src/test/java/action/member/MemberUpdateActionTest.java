package action.member;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.dao.MemberDao;
import data.dto.MemberDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberUpdateActionTest {

    @Test
    void execute() throws JsonProcessingException {
        MemberDto dto = new MemberDto(
                "65",
                "yang",
                "1234",
                "yang",
                "123",//String.valueOf((int) Math.random() * 100 + 1),
                "male",
                null,//String.format("010-1234-%04d", i),  //공백 채우기.
                null,//"asdf@gmail.com" + i,
                "true",
                String.valueOf((int) Math.random() * 10000),
                "2020-11-28", //Timestamp.valueOf("2020-11-28"),
                "0"
        );
        MemberDao dao = new MemberDao();
        ObjectMapper mapper = new ObjectMapper();
        String json = "";

        if (dao.updateMember((MemberDto) dto)) {
            System.out.println(String.format("update success \nid : %s \nnum : %s"
                    , dto.getId(), dto.getNum()));
            json = mapper.writeValueAsString(dto);
            System.out.println(json);
//            forward.setPrintData(json);
//            forward.setChangePage(false);
        } else {
            json = "update fail.";
            System.out.println(json);
//            forward.setPrintData(json);
//            forward.setChangePage(false);
        }
    }
}