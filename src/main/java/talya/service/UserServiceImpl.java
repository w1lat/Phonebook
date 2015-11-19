package talya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import talya.dao.UserDao;
import talya.exception.LoginException;
import talya.exception.RegistrarException;
import talya.model.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public UserServiceImpl() {
    }

    public User registerUser(String login, String password, String fullName) throws RegistrarException {
        if (userDao.findByLogin(login) != null) {
            throw new RegistrarException("user with this login is already exist");
        }
        User user = new User(login, password, fullName);
        return userDao.addUser(user);
    }

    public User login(String login, String password) throws LoginException {
        User found = userDao.findByLogin(login);
        if (found == null) {
            throw new LoginException("wrong login");
        } else if (!found.getPassword().equals(password)) {
            throw new LoginException("wrong password");
        }
        return found;
    }


}
