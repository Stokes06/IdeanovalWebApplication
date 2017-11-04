import db.Database;
import tools.Functions;
import tools.Validator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/inscription")
public class Inscription extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection db = Database.getInstance();
        PrintWriter out = response.getWriter();
        String pseudo = request.getParameter("pseudo");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String password_confirm = request.getParameter("password_confirm");
        Map<String, String> errors = new HashMap<>();
        if(!Validator.isEmail(email))
            errors.put("email_ins", "L'adresse email n'est pas valide.");

        if(pseudo.length()<4 || !Validator.isAlphaNumeric(pseudo))
            errors.put("pseudo_ins","Le pseudo n'est pas valide. taille mini , 4 alphanumerique");
        try{

          PreparedStatement st = db.prepareStatement("select * from allpseudo where pseudo=?");
          st.setString(1,pseudo);
          ResultSet rs = st.executeQuery();
          if(rs.next())
              errors.put("pseudo_ins", "Le pseudo est deja pris.");
      }catch(SQLException e){}

        if(!password.equals(password_confirm))
            errors.put("password_confirm","vous n'avez pas entré deux fois le même mot de passe.");
        if(password.length()<4 || !Validator.isAlphaNumeric(password))
            errors.put("password_ins","Le mot de passe n'est pas valide. taille mini , 4 alphanumerique");


       if(!errors.isEmpty())
       {
           for (String key : errors.keySet()) {
               out.print(key + "||" + errors.get(key)+"||");
           }
       }else{
           System.out.println("pas d'erreurs");
           int userId;
           java.sql.Date today = new java.sql.Date(new java.util.Date().getTime());
          try{

               PreparedStatement ps = db.prepareStatement("insert into user(email,pseudo,password,registerDate)" +
                      "values(?,?,?,?)");
               ps.setString(1,email);
               ps.setString(2,pseudo);
               ps.setString(3,password);
               ps.setDate(4,today);
               ps.execute();
                userId = Database.getLastInsertId();
              ps = db.prepareStatement("insert into client(id_user,isValidated,isDeleted) values(?,0,0)");
              ps.setInt(1,userId);
              ps.execute();


              System.out.println("last id insert :"+userId);
              out.print(userId); //renvoie l'id de l'utilisateur pour le connecter
           }catch (SQLException e){e.printStackTrace();}

       }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
