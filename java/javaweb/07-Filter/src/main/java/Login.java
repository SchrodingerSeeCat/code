import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取参数
        String name = req.getParameter("username");
        if ("admin".equals(name)) {
            req.getSession().setAttribute("USER_SESSION", req.getSession().getId());
            resp.sendRedirect(req.getContextPath() + "/success.jsp");
        } else {
            resp.sendRedirect(req.getContextPath() + "/error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
