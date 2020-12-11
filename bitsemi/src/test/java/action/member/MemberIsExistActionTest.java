package action.member;

import data.dao.MemberDao;
import data.dto.MemberDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberIsExistActionTest {

    @Test
    void execute() {
        MemberDto dto = new MemberDto(
                "",
                "yang",
                "1234",
                "yang",
                String.valueOf((int) Math.random() * 100 + 1),
                "male",
                null,//String.format("010-1234-%04d", i),  //공백 채우기.
                null,//"asdf@gmail.com" + i,
                "true",
                String.valueOf((int) Math.random() * 10000),
                "2020-11-28", //Timestamp.valueOf("2020-11-28"),
                "0"
        );
        MemberDao dao = new MemberDao();
        boolean isCheckResult = false;

        if (dto.getId() != null) {
            isCheckResult = dao.isIdCheck(dto.getId());

            if (isCheckResult) {
                System.out.println("succes " + dto.getId());
//                forward.setChangePage(false);
//                forward.setPrintData("true");
            } else {
                System.out.println("fail " + dto.getId());
//                forward.setChangePage(false);
//                forward.setPrintData("false");
            }
        } else {
//            forward.setChangePage(false);
//            forward.setPrintData("false");
        }
    }
}