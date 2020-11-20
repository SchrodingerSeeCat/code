import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class CookieTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("content-type", "text/html;charset=utf-8");

        PrintWriter out = resp.getWriter();

        // Cookie可以存在多个
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for(int i = 0; i < cookies.length; i++) {
                if(cookies[i].getName().equals("name")) {
                    out.write(URLDecoder.decode(cookies[i].getValue(), "UTF-8"));
                }
            }
        } else {
            out.write("第一次访问网站");
            // 给服务器响应一个cookie
            Cookie nameCookie = new Cookie("name", URLEncoder.encode("哔哩哔哩", "UTF-8"));
            Cookie lastLoginTime = new Cookie("LastLoginTime", System.currentTimeMillis() + "");
            // 设置cookie的有效期为一天
            nameCookie.setMaxAge(24 * 60 * 60);
            lastLoginTime.setMaxAge(24 * 60 * 60);
            resp.addCookie(nameCookie);
            resp.addCookie(lastLoginTime);

        }
        out.close();
    }
}
