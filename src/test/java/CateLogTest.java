import com.tact.movies.dao.CateLogDao;
import com.tact.movies.dao.impl.CateLogDaoImpl;
import com.tact.movies.dao.impl.LocDaoImpl;
import com.tact.movies.dao.impl.SubclassDaoImpl;
import com.tact.movies.entity.CateLog;
import com.tact.movies.entity.Loc;
import com.tact.movies.entity.Subclass;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.List;

/**
 * @author LIN
 * @since JDK 1.8
 */
public class CateLogTest {
    public static void main(String[] args) {
        CateLogDao cateLogDao = new CateLogDaoImpl();
        List<CateLog> list = cateLogDao.selectCateLogList();
        System.out.println(list);
        SubclassDaoImpl subclassDao = new SubclassDaoImpl();
        List<Subclass> list1 = subclassDao.selectSubClassList();
        System.out.println(list1);
        LocDaoImpl locDao = new LocDaoImpl();
        List<Loc> locs = locDao.selectLocList();
        System.out.println(locs);
    }
}
