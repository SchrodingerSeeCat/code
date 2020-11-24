import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Author implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();
        if (session == null || session.getAttribute("USER_SESSION") == null) {
            ((HttpServletResponse) servletResponse).sendRedirect(req.getContextPath() + "/error.jsp");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
