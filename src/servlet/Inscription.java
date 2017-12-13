package servlet;

import tools.RegisterForm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/inscription")
public class Inscription extends HttpServlet {
    private static final long serialVersionUID = 7867730079496955609L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RegisterForm form = new RegisterForm(request);
        request.setAttribute("form_inscription", form);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
