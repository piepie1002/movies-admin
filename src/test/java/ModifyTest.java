import com.tact.movies.dao.ModifyDao;
import com.tact.movies.dao.impl.ModifyDaoImpl;
import com.tact.movies.entity.Film;

public class ModifyTest {
    public static void main(String[] args) {
        ModifyDao modifyDao = new ModifyDaoImpl();
        Film film = new Film("f39c979857a4c8c50157a9020fb8001d"," 蒂姆·罗宾斯 Tim Robbins   摩根·弗里曼 Morgan Freeman ","public/static/upload/filmPic/1475940124487.jpg","美国","肖生克的救赎","2018","20世纪40年代末，小有成就的青年银行家安迪（蒂姆·罗宾斯 Tim Robbins 饰）因涉嫌杀害妻子及她的情人而锒铛入狱。在这座名为肖申克的监狱内，希望似乎虚无缥缈，终身监禁的惩罚无疑注定了安迪接下来灰暗绝望的人生。未过多久，安迪尝试接近囚犯中颇有声望的瑞德（摩根·弗里曼 Morgan Freeman 饰），请求对方帮自己搞来小锤子。以此为契机，二人逐渐熟稔，安迪也仿佛在鱼龙混杂、罪恶横生、黑白混淆的牢狱中找到属于自己的求生之道。他利用自身的专业知识，帮助监狱管理层逃税、洗黑钱，同时凭借与瑞德的交往在犯人中间也渐渐受到礼遇。表面看来，他已如瑞德那样对那堵高墙从憎恨转变为处之泰然，但是",
                "1080","全集","犯罪片");
        int i = modifyDao.modifyData(film);
        System.out.println(i);
    }
}