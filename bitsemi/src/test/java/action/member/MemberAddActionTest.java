package action.member;

import action.ActionFactory;
import action.Category;
import data.dao.MemberDao;
import data.dto.MemberDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberAddActionTest {

    @Test
    void execute() {
        MemberDao dao = new MemberDao();

        boolean idCheckResult = dao.isIdCheck("qweweasdfdsafasdfasdfs");
        if (!idCheckResult) {
            /*dao.insertMember("angel");*/
            /*forward.setPrintData("yes");
            forward.setChangePage(false);*/
            System.out.println("ok");
        } else {
           /* forward.setPrintData("no");
            forward.setChangePage(false);*/
            System.out.println("nono");
        }
        /*for (int i = 20; i < 40; i++) {
            MemberDto dto = new MemberDto(
                    "",
                    "idid" + i,
                    "1234",
                    "name" + i,
                    String.valueOf((int) Math.random() * 100 + 1),
                    (i % 2 == 0) ? "male" : "female",
                    null,//String.format("010-1234-%04d", i),  //공백 채우기.
                    null,//"asdf@gmail.com" + i,
                    (i % 3 == 0) ? "true" : "false",
                    String.valueOf((int) Math.random() * 10000),
                    "2020-11-28", //Timestamp.valueOf("2020-11-28"),
                    "0"
            );
            MemberDao dao = new MemberDao();
            boolean idCheckResult = dao.isIdCheck(dto.getId());
            if (!idCheckResult) {
                dao.insertMember(dto);
                System.out.println("insert success " + dto.getId());
//            forward.setPrintData("yes");
//            forward.setChangePage(false);
            } else {
//            forward.setPrintData("no");
//            forward.setChangePage(false);
                System.out.println("insert fail " + dto.getId());
            }
        }
*/
    }
}