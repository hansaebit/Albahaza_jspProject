package action.others;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.dao.JobofferDao;
import data.dao.MemberDao;
import data.dao.ResumeDao;
import data.dto.JobofferDto;
import data.dto.MemberDto;
import data.dto.ResumeDto;
import org.junit.jupiter.api.Test;

import java.util.List;

class AllSearchActionTest {

    @Test
    void execute() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        MemberDao mdao = new MemberDao();
        List<MemberDto> mlist = mdao.getSearchMember("yang");
        String json = mapper.writeValueAsString(mlist);
        System.out.println(json);

//        new JobofferDto();
        JobofferDao jdao = new JobofferDao();
        List<JobofferDto> jlist = jdao.getSearchJoboffer("didrnrgus1");
        json = mapper.writeValueAsString(jlist);
        System.out.println(json);

//         new ResumeDto();
        ResumeDao rdao = new ResumeDao();
        List<ResumeDto> rlist = rdao.getSearchResume("didrnrgus1");
        json = mapper.writeValueAsString(rlist);
        System.out.println(json);
    }
}