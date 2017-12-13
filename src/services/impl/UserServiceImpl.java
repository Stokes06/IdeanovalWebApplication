package services.impl;

import dao.UserDao;
import pojo.Client;
import pojo.User;
import services.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao;

    public UserServiceImpl() {
        this.userDao = new UserDao();
    }

    @Override
    public User getUserByLogin(String login) {
        return userDao.getUserByLogin(login);
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public User getUserByPseudo(String pseudo) {
        return userDao.getUserByPseudo(pseudo);
    }

    @Override
    public User connectUser(String login, String password) {
        return userDao.connectUser(login, password);
    }

    @Override
    public Client createClient(String login, String pseudo, String password) {
        pseudo = String.valueOf(pseudo.charAt(0)).toUpperCase().concat(pseudo.substring(1));
        Client client = new Client(login, password, pseudo);
        client.setValidated(false);
        client.setDeleted(false);
        return userDao.createClient(client);
    }


}
