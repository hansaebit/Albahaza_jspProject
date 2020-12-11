package action.others;

import action.Action;
import action.ActionForward;
import data.dao.JobofferDao;
import data.dao.MemberDao;
import data.dao.ResumeDao;
import data.dto.JobofferDto;
import data.dto.MemberDto;
import data.dto.ResumeDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class AllSearchAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ActionForward forward = new ActionForward();
        /**
         * member dao,dto
         * resume dao,dto
         * joboffer dao,dto 전부 로드
         */
        MemberDao memberDao = new MemberDao();
        ResumeDao resumeDao = new ResumeDao();
        JobofferDao jobofferDao = new JobofferDao();
        HttpSession session = request.getSession();

        String param = request.getParameter("param"); //검색 값
        System.out.println(param + "param값 가져오는지 확인");
        List<MemberDto> memberlist = memberDao.getSearchMember(param);
        List<ResumeDto> resumelist = resumeDao.getSearchResume(param);
        List<JobofferDto> jobofferlist = jobofferDao.getSearchJoboffer(param);

//        System.out.println("memberlist:" + memberlist);
//        System.out.println("resumelist:" + resumelist);
//        System.out.println("jobofferlist:" + jobofferlist);

        session.setAttribute("memberlist", memberlist);
        session.setAttribute("resumelist", resumelist);
        session.setAttribute("jobofferlist", jobofferlist);

        forward.setPrintData("search-ok");
        forward.setChangePage(false);
        return forward;
    }
}
