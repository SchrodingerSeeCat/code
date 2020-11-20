import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class SessionTest1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("content-type", "text/html;charset=utf-8");

        PrintWriter out = resp.getWriter();
        // 获取session对象
        HttpSession session = req.getSession();

        // 在session中存入东西
        session.setAttribute("name", "哔哩哔哩");

        // 获取sessionID
        String id = session.getId();

        // 判断session是不是新创建的
        if (session.isNew()) {
            out.write("sessionID: " + id);
        } else {
            out.write("session存在: " + id);
        }

        out.close();
    }
}
