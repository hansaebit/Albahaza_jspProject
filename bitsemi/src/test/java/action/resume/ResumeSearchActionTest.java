package action.resume;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.dao.ResumeDao;
import data.dto.ResumeDto;
import org.junit.jupiter.api.Test;

import java.util.List;

class ResumeSearchActionTest {

    @Test
    void execute() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        ResumeDao dao = new ResumeDao();
        List<ResumeDto> list = dao.getSearchResume("didrnrgus1");
                String json = mapper.writeValueAsString(list);
        System.out.println(json);
    }

    @Test
    void testExecute() {
    }
}