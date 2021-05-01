package cc.xizhan.basic.web.app1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.logging.Logger;

@WebServlet(name = "HelloService", value = "/hello-service")
public class HelloService extends HttpServlet {
    Logger log = Logger.getLogger(this.getClass().getName());
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("abc" + req.getPathInfo());
        log.info("remote:" + req.getRemoteAddr());
        log.info("local:" + req.getLocalAddr());
        resp.getOutputStream().print("This is the service");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
