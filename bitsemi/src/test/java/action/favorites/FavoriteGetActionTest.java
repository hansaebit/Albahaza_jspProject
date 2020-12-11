package action.favorites;

import data.dao.FavoritesDao;
import data.dto.FavoritesDto;
import org.junit.jupiter.api.Test;

class FavoriteGetActionTest {

    @Test
    void execute() {
        FavoritesDto dto = new FavoritesDto();
        FavoritesDao dao = new FavoritesDao();
        dao.getAllFavorites();
    }
}