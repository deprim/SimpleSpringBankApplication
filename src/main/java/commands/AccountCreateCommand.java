package commands;


import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.AccountService;
import service.UserInputReader;
import service.UserRegistartionService;
import service.UserService;


import java.util.List;

@Component
public class AccountCreateCommand implements MenuCommand {

    private final AccountService accountService;
    private final UserInputReader userInputReader;
    private final UserService userService;
    private final UserRegistartionService userRegistartionService;

    @Autowired
    public AccountCreateCommand(AccountService accountService, UserInputReader userInputReader, UserService userService, UserRegistartionService userRegistartionService) {
        this.accountService = accountService;
        this.userInputReader = userInputReader;
        this.userService = userService;
        this.userRegistartionService = userRegistartionService;
    }



    @Override
    public void execute() {

        System.out.println("Enter the user id for which to create an account:");
        Integer choosedUserId = userInputReader.readInt();
        accountService.createAccount(choosedUserId);


    }

    @Override
    public String getCommandName() {
        return "ACCOUNT_CREATE";
    }
}
