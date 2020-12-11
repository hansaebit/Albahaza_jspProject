package action.joboffer;

import action.Action;
import action.ActionForward;
import data.dao.FavoritesDao;
import data.dao.JobofferDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JobofferPickAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        ActionForward forward = new ActionForward();
        JobofferDao jobofferDao = new JobofferDao();
        FavoritesDao favoritesDao = new FavoritesDao();

        String joboffernum = request.getParameter("joboffernum");
        String resumenum = request.getParameter("resumenum");
        System.out.println("joboffernum:" + joboffernum);
        System.out.println("resumenum:" + resumenum);

        favoritesDao.updateMatchday(joboffernum, resumenum);

        forward.setChangePage(false);
        forward.setPrintData("JobofferPickAction success");
        return forward;
    }
}
