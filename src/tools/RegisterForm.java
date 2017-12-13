package tools;

import pojo.User;
import services.UserService;
import services.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static tools.Fields.*;
import static tools.Validator.*;
public class RegisterForm {

   private UserService userService;
   private Map<String, String> errors = new HashMap<>();
   private String login;
   private String pseudo;
   private String password;
   private String passwordConfirm;
   private User user;
    public RegisterForm(HttpServletRequest request) {
        userService = new UserServiceImpl();

         login = request.getParameter(LOGIN);
         pseudo = request.getParameter(PSEUDO);
         password = request.getParameter(PASSWORD);
         passwordConfirm = request.getParameter(PASSWORD_CONFIRM);

         createUser();
    }

    public User createUser(){
        verifyPseudo(pseudo);
        verifyLogin(login);
        verifyPasswords(password, passwordConfirm);

        if(errors.isEmpty())
            this.user =  userService.createClient(login, pseudo, password);

       return this.user;
    }
    private void verifyPasswords(String p1, String p2) {
        if(!p1.equals(p2))
            errors.put(PASSWORD_CONFIRM, "les deux mots de passes ne sont pas identiques");
        else if(!verifyPassword(p1))
            errors.put(PASSWORD, "la longueur de mot de passe doit etre comprise entre "+passwordSizeMin +" et "+passwordSizeMax);
    }

    private void verifyLogin(String login) {
        if(userService.getUserByLogin(login) != null)
            errors.put(LOGIN, "cet email est deja utilisé comme login pour notre site.");
        else if(!isEmail(login))
            errors.put(LOGIN, "le format de l'email n'est pas valide");
    }

    private void verifyPseudo(String pseudo){
        if(!(isAlphaNumeric(pseudo) && hasLengthBetween(pseudo, 6,20)))
            errors.put(PSEUDO, "le format du pseudo n'est pas correct.");
        else if(userService.getUserByPseudo(pseudo) != null)
            errors.put(LOGIN, "Ce pseudo est déjà pris.");

    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
