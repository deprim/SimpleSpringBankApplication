
import org.springframework.context.annotation.*;

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


}
