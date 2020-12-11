package action.resume;

import action.Action;
import action.ActionFactory;
import action.ActionForward;
import action.Category;
import com.fasterxml.jackson.databind.ObjectMapper;
import config.ServerConfig;
import data.dao.ResumeDao;
import data.dao.ZipcodeDao;
import data.dto.JobofferDto;
import data.dto.ResumeDto;
import data.dto.ZipcodeDto;
import util.PagingCalculaor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ResumeGetAllAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        ActionForward forward = new ActionForward();
        ResumeDto dto = (ResumeDto) ActionFactory.getDto(Category.Resume, request);
        ResumeDao resumeDao = new ResumeDao();
        ZipcodeDao zipcodeDao = new ZipcodeDao();
        ObjectMapper mapper = new ObjectMapper();   //object -> json
        String json = "";

        boolean isfilter = Boolean.valueOf(request.getParameter("isfilter"));
        System.out.println("isfilter:" + isfilter);
        int totalCount = 0;
        PagingCalculaor pagingCalculaor = null;
        List<ResumeDto> list = null;
        String jobtype = "none";
        String term = "none";
        String abletime = "none";
        String location = "none";

        if (isfilter) {
            jobtype = request.getParameter("jobtype");
            term = request.getParameter("term");
            abletime = request.getParameter("abletime");
            location = request.getParameter("location");

            request.getSession().setAttribute("jobtype", jobtype);
            request.getSession().setAttribute("term", term);
            request.getSession().setAttribute("abletime", abletime);
            request.getSession().setAttribute("location", location);

            jobtype = (jobtype.equals("none") ? null : jobtype);
            term = (term.equals("none") ? null : term);
            abletime = (abletime.equals("none") ? null : abletime);
            location = (location.equals("none") ? null : location);

            totalCount = resumeDao.getTotalCount(jobtype, term, abletime, location);

            if (request.getSession().getAttribute("zipcodelist") == null) {
                List<ZipcodeDto> zipcodeList = zipcodeDao.getAllZipcode();
                request.getSession().setAttribute("zipcodelist", zipcodeList);
            }

            //현재페이지 번호 구하기
            String pageNum = request.getParameter("pageNum");
            System.out.println("pageNum : " + pageNum);
            String afterLink = request.getParameter("afterLink");
            System.out.println("afterLink : " + afterLink);

            if (pageNum == null || pageNum.length() == 0) {
                pagingCalculaor = new PagingCalculaor(totalCount, 3, 3, 1);
                System.out.println("1111 pageNum : ");
            } else {
                pagingCalculaor = new PagingCalculaor(totalCount, 3, 3, Integer.parseInt(pageNum));
                System.out.println("2222 pageNum : ");
            }

            list = resumeDao.getAllResume(
                    pagingCalculaor.getStart()
                    , pagingCalculaor.getPerPage()
                    , jobtype, term, abletime, location
            );

            request.getSession().setAttribute("paging", pagingCalculaor);
            request.getSession().setAttribute("resumelist", list);
            json = mapper.writeValueAsString(list);
        } else {
            //필터없이 전체 검색.
            request.getSession().setAttribute("jobtype", jobtype);
            request.getSession().setAttribute("term", term);
            request.getSession().setAttribute("abletime", abletime);
            request.getSession().setAttribute("location", location);

            totalCount = resumeDao.getTotalCount();

            if (request.getSession().getAttribute("zipcodelist") == null) {
                List<ZipcodeDto> zipcodeList = zipcodeDao.getAllZipcode();
                request.getSession().setAttribute("zipcodelist", zipcodeList);
            }

            //현재페이지 번호 구하기
            String pageNum = request.getParameter("pageNum");
            System.out.println("pageNum : " + pageNum);
            String afterLink = request.getParameter("afterLink");
            System.out.println("afterLink : " + afterLink);

            if (pageNum == null || pageNum.length() == 0) {
                pagingCalculaor = new PagingCalculaor(totalCount, 5, 3, 1);
                System.out.println("1111 pageNum : ");
            } else {
                pagingCalculaor = new PagingCalculaor(totalCount, 5, 3, Integer.parseInt(pageNum));
                System.out.println("2222 pageNum : ");
            }

            list = resumeDao.getAllResume(
                    pagingCalculaor.getStart()
                    , pagingCalculaor.getPerPage()
            );

            request.getSession().setAttribute("paging", pagingCalculaor);
            request.getSession().setAttribute("resumelist", list);
            json = mapper.writeValueAsString(list);
        }

        System.out.println(json);
        forward.setPrintData(json);
        forward.setChangePage(false);
        return forward;
    }
}
