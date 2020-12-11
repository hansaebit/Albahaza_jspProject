package action.favorites;

import action.Action;
import action.ActionFactory;
import action.ActionForward;
import action.Category;
import data.dao.FavoritesDao;
import data.dto.FavoritesDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FavoriteDeleteAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ActionForward forward = new ActionForward();
        FavoritesDto dto = (FavoritesDto) ActionFactory.getDto(Category.Favorites, request);
        FavoritesDao dao = new FavoritesDao();

        dao.deleteFavorites(dto.getNum());
        forward.setPrintData("yes");
        forward.setChangePage(false);

        return forward;
    }
}
