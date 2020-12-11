package action.member;

import action.ActionForward;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.dao.JobofferDao;
import data.dao.MemberDao;
import data.dao.ResumeDao;
import data.dto.JobofferDto;
import data.dto.MemberDto;
import data.dto.ResumeDto;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpSession;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberMypageActionTest {

    @Test
    void execute() throws JsonProcessingException {
//        ActionForward forward = new ActionForward();
        MemberDao memberDao = new MemberDao();
        ResumeDao resumeDao = new ResumeDao();
        JobofferDao jobofferDao = new JobofferDao();
//        HttpSession session = request.getSession();
        String loginid = "didrnrgus1";//(String)session.getAttribute("loginid");
        String json = "";

        MemberDto memberDto = memberDao.getData(loginid);
        List<ResumeDto> resumeList = resumeDao.getAllResume(loginid);
        List<JobofferDto> jobofferList = jobofferDao.getAllJoboffer(loginid);

        ObjectMapper mapper = new ObjectMapper();
        json = mapper.writeValueAsString(memberDto);
        System.out.println("memberDto : " + json);
        json = mapper.writeValueAsString(resumeList);
        System.out.println("resumeList : " + json);
        json = mapper.writeValueAsString(jobofferList);
        System.out.println("jobofferList : " + json);

//        session.setAttribute("member", memberDto);
//        session.setAttribute("resumelist", resumeList);
//        session.setAttribute("jobofferlist", jobofferList);
//
//        forward.setChangePage(false);
//        forward.setPrintData("MemberMypageAction success.");
    }
}