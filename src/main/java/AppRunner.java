import controller.Menu;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppRunner {

    public static void main(String[] args) {


        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        Menu menu =  context.getBean("menu", Menu.class);
        menu.start();


    }

}
