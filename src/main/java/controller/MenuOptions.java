package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum MenuOptions {

    USER_CREATE,
    SHOW_ALL_USERS,
    ACCOUNT_CREATE,
    ACCOUNT_CLOSE,
    ACCOUNT_DEPOSIT,
    ACCOUNT_TRANSFER,
    ACCOUNT_WITHDRAW;

    public static List<MenuOptions> getMenuOptions(){
        List<MenuOptions> menuOption = new ArrayList<>();
        menuOption.addAll(Arrays.asList(MenuOptions.values()));
        return menuOption;

    }




}
