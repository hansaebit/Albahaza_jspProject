package action.member;

import action.Action;
import action.ActionForward;
import data.dao.FavoritesDao;
import data.dao.JobofferDao;
import data.dao.MemberDao;
import data.dao.ResumeDao;
import data.dto.FavoritesDto;
import data.dto.JobofferDto;
import data.dto.MemberDto;
import data.dto.ResumeDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

public class MemberMypageAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ActionForward forward = new ActionForward();
        MemberDao memberDao = new MemberDao();
        ResumeDao resumeDao = new ResumeDao();
        FavoritesDao favoritesDao = new FavoritesDao();
        JobofferDao jobofferDao = new JobofferDao();
        HttpSession session = request.getSession();
        String loginid = (String) session.getAttribute("loginid");

        MemberDto memberDto = memberDao.getData(loginid);
        List<ResumeDto> resumeList = resumeDao.getAllResume(loginid);
        List<JobofferDto> jobofferList = jobofferDao.getAllJoboffer(loginid);
        List<FavoritesDto> favoritesList
                = favoritesDao.getAllFavorites("employeeid", loginid);
        List<FavoritesDto> favoritesList2
                = favoritesDao.getAllFavorites("employerid", loginid);

        //applyList 를 참고해서 applyJobofferList 를 구해야 한다.
        List<JobofferDto> applyJobofferList = new ArrayList<>();
        for (FavoritesDto f : favoritesList) {
            applyJobofferList.add(jobofferDao.getData(f.getEmployernum()));
        }

        //applyList 를 참고해서 applyResumeList 를 구해야 한다.
        List<ResumeDto> applyResumeList = new ArrayList<>();
        for (FavoritesDto f : favoritesList2) {
            applyResumeList.add(resumeDao.getResumeData(f.getEmployeenum()));
        }


        //key : "joboffer.num,joboffer.companyname"
        //value : "ResumeDto.num,ResumeDto.name,favorites.createday"
        Map<String, List<String>> mapApply = new HashMap<>();
        for (JobofferDto j : jobofferList) {
            System.out.println("j.getApplicant():" + j.getApplicant());
            String tempApplicantId = j.getApplicant();

            List<String> listTempApplicantId = null;
            List<String> listTempInfo = null;

            if (tempApplicantId != null && tempApplicantId.length() > 0) {
                tempApplicantId = tempApplicantId.substring(1, tempApplicantId.length() - 1);
                tempApplicantId.replace(" ", "");
                System.out.println("tempApplicantId:" + tempApplicantId);
                listTempApplicantId = new ArrayList<>(Arrays.asList(tempApplicantId.split(",")));

            }else{
                listTempApplicantId = new ArrayList<>();
            }

            listTempInfo = new ArrayList<>();
            for (String applyId : listTempApplicantId) {
                System.out.println("applyId:" + applyId);
                ResumeDto tempResumeDto = resumeDao.getResumeDataById(applyId);
                FavoritesDto tempFavoritesDto = favoritesDao.getData(j.getNum(), tempResumeDto.getNum());
                listTempInfo.add(tempResumeDto.getNum() + ","
                        + tempResumeDto.getName() + ","
                        + tempFavoritesDto.getCreateday() + ","
                        + tempFavoritesDto.getMatchday());
            }
            mapApply.put(j.getNum() + "," + j.getCompanyname(), listTempInfo);
        }
        System.out.println("mapApply : " + mapApply.toString());

        session.setAttribute("member", memberDto);
        session.setAttribute("resumelist", resumeList);
        session.setAttribute("jobofferlist", jobofferList);
        session.setAttribute("applyjobofferlist", applyJobofferList);
        session.setAttribute("applyresumelist", applyResumeList);
        session.setAttribute("favoriteslist", favoritesList);
        session.setAttribute("favoriteslist2", favoritesList2);
        session.setAttribute("mapapply", mapApply);

        // favorites 에서 내가 지원한 회사, 내 공고에 지원한 사람들 정보를 조회 해야 함.

        forward.setChangePage(false);
        forward.setPrintData("MemberMypageAction success.");

        return forward;
    }
}
