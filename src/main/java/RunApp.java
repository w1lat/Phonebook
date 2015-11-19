import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import talya.view.ConsoleView;

public class RunApp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:app-context.xml");

        ConsoleView view = applicationContext.getBean(ConsoleView.class);
        view.start();
    }
}
