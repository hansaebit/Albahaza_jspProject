package action.resume;

import data.dao.ResumeDao;
import data.dto.ResumeDto;
import org.junit.jupiter.api.Test;

class ResumeAddActionTest {

    @Test
    void execute() {
        for (int i = 0; i < 20; i++) {
            ResumeDto dto = new ResumeDto();
            dto.setId("testid" + i);
            dto.setName("testname" + i);
            dto.setPhonenum(String.format("010-1234-%4d", i));

            ResumeDao dao = new ResumeDao();
            dao.insertResume(dto);
        }
    }

}