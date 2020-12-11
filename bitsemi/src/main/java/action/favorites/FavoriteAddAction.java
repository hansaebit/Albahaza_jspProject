package action.favorites;

import action.Action;
import action.ActionFactory;
import action.ActionForward;
import action.Category;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.dao.FavoritesDao;
import data.dao.JobofferDao;
import data.dto.FavoritesDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FavoriteAddAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ActionForward forward = new ActionForward();

        FavoritesDto favoritesDto = (FavoritesDto) ActionFactory.getDto(Category.Favorites, request);
        FavoritesDao favoritesDao = new FavoritesDao();
        JobofferDao jobofferDao = new JobofferDao();
        String json = "";
        ObjectMapper mapper = new ObjectMapper();

        //favorit add 하고, 잡오퍼의 applicant 목록에 아이디 리스트를 추가해 넣어준다.

        //joboffer num 를 갖고 해당 공고의 지원자들을 가져옴.
        // -> jobofferDao 안에서 applicant(String) 을 Set<String>으로 변환해서 줌.
        List<String> applicantList = jobofferDao.getApplicantList(favoritesDto.getEmployernum());

        if (applicantList == null) {
            applicantList = new ArrayList<>();
        }

        //하나의 공고에 중복된 지원자가 있을지 검사하여 무시 또는 추가함.
        if (applicantList.contains(favoritesDto.getEmployeeid())) {
            json = "already exist.";
        } else {
            // list에 지원자 아이디 추가.
            applicantList.add(favoritesDto.getEmployeeid());

            // joboffer 의 applicant (list -> string) 를 업데이트.
//            String strApplicantList = applicantList.toString().replace(" ", "");
//            strApplicantList = strApplicantList.substring(1, strApplicantList.length() - 1);
            jobofferDao.setApplicantList(favoritesDto.getEmployernum(), applicantList.toString());

            //favorites 추가.
            favoritesDto = favoritesDao.insertFavorites(favoritesDto);
            json = mapper.writeValueAsString(favoritesDto);
            System.out.println("FavoritesDto : " + json);
        }


        forward.setPrintData(json);
        forward.setChangePage(false);

        return forward;
    }
}
