package action.joboffer;

import action.Action;
import action.ActionFactory;
import action.ActionForward;
import action.Category;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xpath.internal.operations.Bool;
import config.ServerConfig;
import data.dao.JobofferDao;
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

public class JobofferGetAllAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ActionForward forward = new ActionForward();
        JobofferDto dto = (JobofferDto) ActionFactory.getDto(Category.Joboffer, request);
        JobofferDao jobofferDao = new JobofferDao();
        ZipcodeDao zipcodeDao = new ZipcodeDao();
        ObjectMapper mapper = new ObjectMapper();   //object -> json
        String json = "";
        boolean isfilter = Boolean.valueOf(request.getParameter("isfilter"));
        System.out.println("isfilter:" + isfilter);
        int totalCount = 0;
        PagingCalculaor pagingCalculaor = null;
        List<JobofferDto> list = null;
        String jobtype = "none";
        String term = "none";
        String abletime = "none";

        if (isfilter) {
            jobtype = request.getParameter("jobtype");
            term = request.getParameter("term");
            abletime = request.getParameter("abletime");

            request.getSession().setAttribute("jobtype", jobtype);
            request.getSession().setAttribute("term", term);
            request.getSession().setAttribute("abletime", abletime);

            jobtype = (jobtype.equals("none") ? null : jobtype);
            term = (term.equals("none") ? null : term);
            abletime = (abletime.equals("none") ? null : abletime);

            totalCount = jobofferDao.getTotalCount(jobtype, term, abletime);
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

            list = jobofferDao.getAllJoboffer(
                    pagingCalculaor.getStart()
                    , pagingCalculaor.getPerPage()
                    , jobtype, term, abletime
            );

            request.getSession().setAttribute("paging", pagingCalculaor);
            request.getSession().setAttribute("jobofferlist", list);
            json = mapper.writeValueAsString(list);

        } else {
            //필터없이 전체 검색.
            request.getSession().setAttribute("jobtype", jobtype);
            request.getSession().setAttribute("term", term);
            request.getSession().setAttribute("abletime", abletime);

            totalCount = jobofferDao.getTotalCount();

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

            list = jobofferDao.getAllJoboffer(
                    pagingCalculaor.getStart()
                    , pagingCalculaor.getPerPage()
            );

            request.getSession().setAttribute("paging", pagingCalculaor);
            request.getSession().setAttribute("jobofferlist", list);
            json = mapper.writeValueAsString(list);
        }

        System.out.println(json);
        forward.setPrintData(json);
        forward.setChangePage(false);
        return forward;
    }
}
