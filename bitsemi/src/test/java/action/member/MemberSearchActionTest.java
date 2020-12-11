package action.member;

import data.dao.MemberDao;
import data.dto.MemberDto;
import org.junit.jupiter.api.Test;

class MemberSearchActionTest {

    @Test
    void execute() {
        MemberDto dto = new MemberDto();
        MemberDao dao = new MemberDao();
        dao.getSearchMember("yang");
    }
}