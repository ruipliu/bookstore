package main.controller.manager;

import main.entity.Category;
import main.service.MainService;
import main.service.impl.MainServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookServlet", urlPatterns = "/BookServlet")
public class BookServlet extends HttpServlet {

    MainService service = new MainServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        MainServiceImpl service = new MainServiceImpl();

        if (method.equals("addUI")) {
            List<Category> list = service.getAllCategory();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/background/addBook.jsp").forward(request, response);
        }
    }


}
