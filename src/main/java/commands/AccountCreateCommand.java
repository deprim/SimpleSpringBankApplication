package commands;


import org.springframework.stereotype.Component;
import service.UserInputReader;
import service.UserService;

@Component
public class AccountCreateCommand {

    private final UserService userService;
    private final UserInputReader userInputReader;

    public AccountCreateCommand(UserService userService, UserInputReader userInputReader) {
        this.userService = userService;
        this.userInputReader = userInputReader;
    }



}
