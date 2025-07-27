package commands;

import entity.Account;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.AccountService;

import java.util.List;

@Component
public class AccountDepositCommand implements MenuCommand {

    private final AccountService accountService;

    public AccountDepositCommand(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute() {

        accountService.depositAccount();

    }

    @Override
    public String getCommandName() {
        return "ACCOUNT_DEPOSIT";
    }
}
