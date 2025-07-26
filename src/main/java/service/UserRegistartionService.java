package service;


import entity.Account;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRegistartionService {

    @Value("${account.default-ammount}")
    Double defaultMoneyAmount;
    private final AccountService accountService;
    private final UserService userService;
    private final List<User> userList;
    private final List<Account> accountList;


    @Autowired
    public UserRegistartionService(AccountService accountService, UserService userService, List<User> userList, List<Account> accountList) {
        this.accountService = accountService;
        this.userService = userService;
        this.userList = userList;
        this.accountList = accountList;
    }



    public void createDefaultAccount(User user){

        // Creating default account for him
        Account account = new Account();
        account.setId(accountList.size());
        account.setMoneyAmmount(defaultMoneyAmount);
        account.setUserId(user.getId());
        user.setAccounts(account);
        // accountList.add(account);
        accountService.getAccountList().add(account);

    }

    public void createUser(String login){

        boolean userExists = userList.stream()
                .anyMatch(user -> user.getLogin().equals(login));

        if (userExists) {
            System.out.println("User already exists");
            return;
        }

        // Creating User
        User currentUser = new User();
        currentUser.setId(userList.size());
        currentUser.setLogin(login);
        userService.getUserList().add(currentUser);

        // create defauult account for user
        createDefaultAccount(currentUser);

        System.out.println(currentUser);

    }

    public AccountService getAccountService() {
        return accountService;
    }

    public UserService getUserService() {
        return userService;
    }

    public List<User> getUserList() {
        return userList;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

}
