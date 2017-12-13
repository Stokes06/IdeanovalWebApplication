package tools;

import db.DataConnect;
import pojo.User;
import services.UserService;
import services.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;

public class ConnectionForm {
    private Connection db;
    private int idUser;
    private UserService userService;
    private User user;
    public ConnectionForm(HttpServletRequest request) {
        this.db = DataConnect.getInstance();
        userService = new UserServiceImpl();
        connectUser(request);
    }
    private void connectUser(HttpServletRequest request){

        String login = request.getParameter(Fields.LOGIN);
        String password = request.getParameter(Fields.PASSWORD);
        user = userService.connectUser(login, password);

    }
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
