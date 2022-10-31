package mk.finki.ukim.mk.lab1203196.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "balloon-order-servlet", urlPatterns = "/BalloonOrder.do")
public class BalloonOrderServlet extends HttpServlet {

    @Autowired
    private SpringTemplateEngine springTemplateEngine;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req,resp,req.getServletContext());
        springTemplateEngine.process("deliveryInfo.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("clientName");
        String address = req.getParameter("clientAddress");
        req.getSession().setAttribute("clientName",name);
        req.getSession().setAttribute("clientAddress",address);
        resp.sendRedirect("/ConfirmationInfo");

    }
}
