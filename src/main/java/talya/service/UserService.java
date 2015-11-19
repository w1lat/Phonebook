package talya.service;


import talya.exception.LoginException;
import talya.exception.RegistrarException;
import talya.model.User;

public interface UserService {

    User registerUser(String login, String password, String fullName) throws RegistrarException;
    User login(String login, String password) throws LoginException;
}
