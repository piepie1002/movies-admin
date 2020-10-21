import com.tact.movies.dao.ListDao;
import com.tact.movies.dao.impl.ListDaoImpl;
import com.tact.movies.entity.Film;

import java.util.List;

public class TestList {
    public static void main(String[] args) {
        ListDao listDao = new ListDaoImpl();
        List<Film> films = listDao.selectAllFilmsList();
        System.out.println(films);
    }
}
