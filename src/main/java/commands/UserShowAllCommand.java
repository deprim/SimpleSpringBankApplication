package commands;

import org.springframework.stereotype.Component;
import service.UserInputReader;
import service.UserService;


@Component
public class UserShowAllCommand implements MenuCommand {

    private UserService userService;
    private UserInputReader userInputReader;

    public UserShowAllCommand(UserService userService, UserInputReader userInputReader) {
        this.userService = userService;
        this.userInputReader = userInputReader;
    }

    @Override
    public void execute() {

        userService.showAllUsers();

    }

    @Override
    public String getCommandName() {
        return "SHOW_ALL_USERS";
    }
}
