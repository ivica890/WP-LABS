package mk.finki.ukim.mk.lab1203196.web;

import mk.finki.ukim.mk.lab1203196.service.BalloonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "balloon-list-servlet",urlPatterns = "/servlet")
public class BalloonListServlet extends HttpServlet {

    @Autowired
    private SpringTemplateEngine springTemplateEngine;
    @Autowired
    private BalloonService balloonService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        WebContext context = new WebContext(req,resp,req.getServletContext());
        context.setVariable("balloons", balloonService.listAll());
        springTemplateEngine.process("listBalloons",
                context,resp.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value = req.getParameter("color");
        req.getSession().setAttribute("color",value);
        resp.sendRedirect("/selectBalloon");

    }
}
