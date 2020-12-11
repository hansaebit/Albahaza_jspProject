package action.joboffer;

import data.dao.JobofferDao;
import data.dto.JobofferDto;
import org.junit.jupiter.api.Test;

class JobofferSearchActionTest {

    @Test
    void execute() {
        JobofferDto dto = new JobofferDto();
        JobofferDao dao = new JobofferDao();
        dao.getSearchJoboffer("yang");
    }
}