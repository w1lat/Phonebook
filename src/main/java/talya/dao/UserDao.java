package talya.dao;


import talya.model.User;

public interface UserDao {

    User addUser(User user);
    User findByLogin(String login);
}
