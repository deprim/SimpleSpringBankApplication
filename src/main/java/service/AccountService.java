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
    List<User> userList;
    UserInputReader userInputReader;

    @Autowired
    public AccountService(List<Account> accountList, UserInputReader userInputReader, List<User> userList) {
        this.accountList = accountList;
        this.userInputReader = userInputReader;
        this.userList = userList;
    }


//    public void createDefaultAccount(User user){
//
//        // Creating default account for him
//        Account account = new Account();
//        account.setId(accountList.size());
//        account.setMoneyAmmount(defaultMoneyAmount);
//        account.setUserId(user.getId());
//        user.setAccounts(account);
//        accountList.add(account);
//
//
//
//    }

    public void createAccount(Integer choosedUserId){

        User user = userList.stream()
                .filter(u -> u.getId().equals(choosedUserId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User with ID " + choosedUserId + " not found"));


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
        Account accountOfUser = accountList.get(accountId);
        User ownerOfAccount = userList.get(accountOfUser.getUserId());


        if(ownerOfAccount.getAccounts().size() > 1){

            // get count of user's accounts
            Integer countOfUserAccounts = ownerOfAccount.getAccounts().size();
            // take previous user's Account ID;
            Integer previousAccountId = ownerOfAccount.getAccounts().get(0).getId();
            // take money ammount from account that we will delete
//            Double accountMoneyAmmount = ownerOfAccount.getAccounts().get(previousAccountId).getMoneyAmmount();
            // delete account
            Account accountToDelete = ownerOfAccount.getAccounts()
                            .stream()
                            .filter(acc -> acc.getId()
                            .equals(accountId))
                            .findFirst().orElse(null);

//            ownerOfAccount.getAccounts().remove(ownerOfAccount.getAccounts().get(accountId));
            Double deletedAccountMoneyAmmount = accountToDelete.getMoneyAmmount();
            ownerOfAccount.getAccounts().remove(accountToDelete);
            // money from deleted account + previous account
            Double moneyFromBoth = ownerOfAccount.getAccounts().get(previousAccountId).getMoneyAmmount() + deletedAccountMoneyAmmount;
            //
            ownerOfAccount.getAccounts().get(previousAccountId).setMoneyAmmount(moneyFromBoth);

        } else {
            System.out.println("Account ID not found or it's your last account");
        }



    }

    public List<User> getUserList() {
        return userList;
    }

    public List<Account> getAccountList() {
        return accountList;
    }
}
