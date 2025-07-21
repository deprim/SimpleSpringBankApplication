package service;

import entity.Account;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    private final AccountService accountService;
    private final List<User>  userList;


    public UserService(AccountService accountService, List<User> userList) {
        this.accountService = accountService;
        this.userList = userList;
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
                userList.add(currentUser);

                // create defauult account for user
                currentUser.setAccounts(accountService.createDefaultAccount(currentUser));

                System.out.println(currentUser);




    }

    public void showAllUsers(){

        for (User user : userList) {

            System.out.println(user);

        }

    }


}
