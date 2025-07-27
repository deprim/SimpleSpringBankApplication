package commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.AccountService;
@Component
public class AccountWithdrawCommand implements MenuCommand {




    private final AccountService accountService;


    @Autowired
    public AccountWithdrawCommand(AccountService accountService) {
        this.accountService = accountService;
    }


    @Override
    public void execute() {

        accountService.accountWithdraw();

    }

    @Override
    public String getCommandName() {
        return "ACCOUNT_WITHDRAW";
    }
}
