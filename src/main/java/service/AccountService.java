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
    UserInputReader userInputReader;

    @Autowired
    public AccountService(List<Account> accountList, UserInputReader userInputReader) {
        this.accountList = accountList;
        this.userInputReader = userInputReader;
    }


    public void createDefaultAccount(User user){

        // Creating default account for him
        Account account = new Account();
        account.setId(accountList.size());
        account.setMoneyAmmount(defaultMoneyAmount);
        account.setUserId(user.getId());
        user.setAccounts(account);
        accountList.add(account);



    }

    public void createAccount(User user){
        Account account = new Account();
        account.setId(accountList.size());
        account.setMoneyAmmount(defaultMoneyAmount);
        account.setUserId(user.getId());
        user.setAccounts(account);
        accountList.add(account);
        System.out.println("New account created with id: " + account.getId() + " for user: " + user.getLogin());

    }

    public void closeAccount(){

        System.out.println("Enter account ID to close:" );
        Integer accountId = userInputReader.readInt();
        User user =

        if(user.getAccounts().size() > 1){

            // take previous user's Account ID;
            Integer firstAccontId = user.getAccounts().getFirst().getId();
            // take money ammount from account that we will delete
            Double accountMoneyAmmount = user.getAccounts().get(accountId).getMoneyAmmount();
            // delete account
            user.getAccounts().remove(user.getAccounts().get(accountId));
            // money from deleted account + first account
            Double moneyFromBoth = user.getAccounts().get(firstAccontId).getMoneyAmmount() + accountMoneyAmmount;
            //
            user.getAccounts().get(firstAccontId).setMoneyAmmount(moneyFromBoth);

        } else {
            System.out.println("Account ID not found or it's your last account");
        }



    }
}
