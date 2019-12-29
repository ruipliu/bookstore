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
import java.util.UUID;

@WebServlet(name = "CategoryServlet", urlPatterns = "/CategoryServlet")
public class CategoryServlet extends HttpServlet {

    MainService service = new MainServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String method = request.getParameter("method");

        MainService service = new MainServiceImpl();

        if (method.equals("add")) {
            String name = new String(request.getParameter("name").getBytes("8859_1"), "utf-8") ;
            String description = new String(request.getParameter("description").getBytes("8859_1"), "utf-8");
            String id = UUID.randomUUID().toString();
            Category category = new Category(id, name, description);
            service.addCategory(category);
            request.setAttribute("message", "Successful add class");
        } else if (method.equals("look")) {
            List<Category> list = service.getAllCategory();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/background/lookCategory.jsp").forward(request, response);
        } else if (method.equals("delete")) {
            String id = request.getParameter("id");
            service.deleteCategory(id);
        } else if (method.equals("update")) {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            service.updateCategory(id, name, description);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
