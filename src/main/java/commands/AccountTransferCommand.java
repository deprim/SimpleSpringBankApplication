package commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.AccountService;

@Component
public class AccountTransferCommand implements MenuCommand {

    private final AccountService accountService;

    @Autowired
    public AccountTransferCommand(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute() {

        accountService.accountTransfer();

    }

    @Override
    public String getCommandName() {
        return "ACCOUNT_TRANSFER";
    }
}
