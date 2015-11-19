package talya.view;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import talya.exception.LoginException;
import talya.exception.RegistrarException;
import talya.service.UserService;

import java.util.Scanner;

@Component
public class ConsoleView {

    @Autowired
    private UserService userService;

    public void ConsoleView(UserService userService) {
        this.userService = userService;
    }

    public ConsoleView() {

    }

    private static final Logger LOGGER = Logger.getLogger(ConsoleView.class);

    private static Scanner scanner = new Scanner(System.in);

    public void start(){
        while (true){
            showMainMenu();
            mainMenuChoice();
        }
    }

    private void mainMenuChoice() {
        switch (scanner.nextInt()){
            case 1 : {
                showLoginMenu();
                break;
            }
            case 2 : {
                showRegisterMenu();
                break;
            }
            default:
                System.out.println("Press 1 or 2");
        }
    }

    private void showRegisterMenu() {
        System.out.println("Enter your login");
        String login = scanner.next();
        System.out.println("Enter password");
        String password = scanner.next();
        System.out.println("Enter your full name");
        String fullName = scanner.next();
        try {
            userService.registerUser(login.trim(), password.trim(), fullName.trim());
        } catch (RegistrarException e) {
            LOGGER.error(e);
        }
    }

    private void showLoginMenu() {
        System.out.println("Enter login");
        String login = scanner.next();
        System.out.println("Enter password");
        String password = scanner.next();
        try{
            userService.login(login.trim(), password.trim());
        } catch (LoginException e) {
            LOGGER.error(e);
        }
    }

    private void showMainMenu() {
        System.out.println("Press 1 to login");
        System.out.println("Press 2 to register");
    }




}
