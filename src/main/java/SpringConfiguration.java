
import entity.Account;
import entity.User;
import org.springframework.context.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Configuration
@ComponentScan("controller")
@ComponentScan("service")
@ComponentScan("entity")
@ComponentScan("commands")
@PropertySource("classpath:application.properties")
public class SpringConfiguration {

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }

    @Bean
    public List<User> userList() {
        return new ArrayList<>();
    }

    @Bean
    public List<Account> accountList() {
        return new ArrayList<>();
    }

}
