package cc.xizhan.basic.web.app1;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;

public class ServletEncoding extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("hello");
        final String zh = "爱我中华 " + new Date().getTime();
        this.log(zh);
        System.out.println(zh);
        Logger logger = Logger.getLogger(this.getClass().getName());
        logger.info(zh);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
