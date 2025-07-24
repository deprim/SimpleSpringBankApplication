package commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.AccountService;
import service.UserInputReader;
import service.UserService;

@Component
public class AccountCloseCommand implements MenuCommand {

    private final AccountService accountService;
    private final UserInputReader userInputReader;
    private final UserService userService;

    @Autowired
    public AccountCloseCommand(AccountService accountService, UserInputReader userInputReader, UserService userService) {
        this.accountService = accountService;
        this.userInputReader = userInputReader;
        this.userService = userService;
    }

    @Override
    public void execute() {

       

    }

    @Override
    public String getCommandName() {
        return "ACCOUNT_CLOSE";
    }
}
