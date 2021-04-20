package cc.xizhan.basic.web.app1;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class ServletForm extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        final String name = request.getParameter("name");
        final String password = request.getParameter("password");
        final PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Servlet Form Demo</title></head>");
        out.println("<body><p>名字:" + name + "</p>");
        out.println("<p>password:" + password + "</p>");
        out.println("</body></html>");
        out.flush();
        out.close();
        final String s2 = "hello, 中文 " + new Date();
        System.out.println(s2);
    }
}
