package commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.UserInputReader;
import service.UserRegistartionService;
import service.UserService;


@Component
public class UserCreateCommand implements MenuCommand {



    private final UserInputReader userInputReader;
    private final UserRegistartionService userRegistartionService;


    @Autowired
    public UserCreateCommand(UserInputReader userInputReader, UserRegistartionService userRegistartionService) {
        this.userInputReader = userInputReader;
        this.userRegistartionService = userRegistartionService;
    }

    @Override
    public void execute() {

        String login;
        System.out.println("Enter login for new user: ");
        login = userInputReader.readString();
        userRegistartionService.createUser(login);

    }

    @Override
    public String getCommandName() {
        return "USER_CREATE";
    }


    }

