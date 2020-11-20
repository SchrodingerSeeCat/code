import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class SessionTest3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("content-type", "text/html;charset=utf-8");

        PrintWriter out = resp.getWriter();

        // 获取session对象
        HttpSession session = req.getSession();

        // 手动注销session
        session.removeAttribute("name");
        session.invalidate();

        out.write("注销成功");
        out.close();
    }
}
