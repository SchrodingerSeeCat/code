import javax.servlet.*;
import java.io.IOException;

public class FilterTest implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        System.out.println("请求执行前");
        // 放行请求
        filterChain.doFilter(request, response);
        System.out.println("请求执行后");
    }

    @Override
    public void destroy() {
        System.out.println("销毁");
    }
}
