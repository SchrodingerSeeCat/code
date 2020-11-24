import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineCountListener implements HttpSessionListener {
    // session创建时触发
    @Override
    public void sessionCreated(HttpSessionEvent se) {
       method(se, 1);
    }


    // session销毁时触发
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        method(se, -1);
    }

    public void method(HttpSessionEvent se, Integer value) {
        ServletContext ctx = se.getSession().getServletContext();
        Integer count = (Integer)ctx.getAttribute("count");
        if (count == null) {
            count = Integer.valueOf(1);
        } else {
            count = Integer.valueOf(count + value);
        }
        ctx.setAttribute("count", count);
    }
}
