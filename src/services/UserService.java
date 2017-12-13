package services;

import pojo.Client;
import pojo.User;

public interface UserService {

    User getUserByLogin(String login);
    User getUserById(int id);

    User getUserByPseudo(String pseudo);
    User connectUser(String login, String password);

    Client createClient(String login, String pseudo, String password);
}
