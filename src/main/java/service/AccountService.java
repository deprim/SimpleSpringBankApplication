package service;

import entity.Account;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {


    @Value("${account.default-ammount}")
    Double defaultMoneyAmount;
    List<Account> accountList;

    @Autowired
    public AccountService(List<Account> accountList) {
        this.accountList = accountList;
    }


    public Account createDefaultAccount(User user){

        // Creating default account for him
        Account account = new Account();
        account.setId(accountList.size());
        account.setMoneyAmmount(defaultMoneyAmount);
        account.setUserId(user.getId());
        accountList.add(account);
        return account;

    }
}
