package servlet;

import tools.ConnectionForm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Connexion")
public class Login extends HttpServlet {
    private static final long serialVersionUID = -1020692297665849372L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConnectionForm form = new ConnectionForm(request);
        request.setAttribute("form_connexion", form);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
