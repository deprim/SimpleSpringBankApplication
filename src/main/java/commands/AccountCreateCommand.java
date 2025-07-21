package commands;


import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.AccountService;
import service.UserInputReader;
import service.UserService;


import java.util.List;

@Component
public class AccountCreateCommand implements MenuCommand {

    private final AccountService accountService;
    private final UserInputReader userInputReader;

    @Autowired
    public AccountCreateCommand(AccountService accountService, UserInputReader userInputReader) {
        this.accountService = accountService;
        this.userInputReader = userInputReader;
    }

    public void createAccount(){




    }

    @Override
    public void execute() {

    }

    @Override
    public String getCommandName() {
        return "ACCOUNT_CREATE";
    }
}
