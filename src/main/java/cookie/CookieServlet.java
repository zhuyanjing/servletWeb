package cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf8");

        String lastVisitTime = null;
        String cookieq=req.getHeader("cookie");
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("visitTime")){
                lastVisitTime = cookie.getValue();
                break;
            }
        }

        if(lastVisitTime == null || lastVisitTime.equals("")){
            resp.getWriter().write("你是首次访问本页面");
        }else{
            resp.getWriter().write("你上次访问的时间是："+lastVisitTime);
        }

        SimpleDateFormat  dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Cookie newCookie  = new Cookie("visitTime",dateFormat.format(new Date()));
        newCookie.setMaxAge(60*60*24);

        resp.addCookie(newCookie);
    }
}
