package action.resume;

import data.dao.ResumeDao;
import data.dto.ResumeDto;
import org.junit.jupiter.api.Test;

class ResumeGetAllActionTest {

    @Test
    void execute() {
        ResumeDto dto = new ResumeDto();
        ResumeDao dao = new ResumeDao();
        dao.getAllResume(1, 10);
    }
}