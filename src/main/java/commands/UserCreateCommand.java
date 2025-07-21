package commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.UserInputReader;
import service.UserService;


@Component
public class UserCreateCommand implements MenuCommand {


    private final UserService userService;
    private final UserInputReader userInputReader;


    @Autowired
    public UserCreateCommand(UserService userService, UserInputReader userInputReader) {
        this.userService = userService;
        this.userInputReader = userInputReader;
    }

    @Override
    public void execute() {

        String login;
        System.out.println("Enter login for new user: ");
        login = userInputReader.readString();
        userService.createUser(login);

    }

    @Override
    public String getCommandName() {
        return "USER_CREATE";
    }


    }

