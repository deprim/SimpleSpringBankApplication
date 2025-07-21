package service;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {


    List<User> userList;


    public UserService(List<User> userList) {
        this.userList = userList;
    }

    public void createUser(String login){

        for (User user : userList) {

            if (user.getLogin().equals(login)) {
                System.out.println("User already exist");
            }

        }

        User user = new User();
        user.setId(userList.size());
        user.setLogin(login);
        userList.add(user);

    }

    public void showAllUsers(){

        for (User user : userList) {

            System.out.println(user);

        }

    }





}
