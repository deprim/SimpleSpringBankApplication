package entity;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;



public class User {

    private Integer id = 0;
    private String login;
    private List<Account> accounts; // list of user accounts


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Account account) {

        if (accounts == null) {
            accounts = new ArrayList<>();
        }
        accounts.add(account);
    }





    @Override
    public String toString() {
        return "ID: " + getId() + " | Login: " + getLogin() + " | Accounts: " + getAccounts();
    }
}
