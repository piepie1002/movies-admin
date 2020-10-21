import com.tact.movies.dao.ListDao;
import com.tact.movies.dao.impl.ListDaoImpl;
import com.tact.movies.entity.Film;

public class FilmTest {
    public static void main(String[] args) {
        ListDao listDao = new ListDaoImpl();
        Film film = listDao.selectFilmsList("自杀小队");
        System.out.println(film);
    }
}
