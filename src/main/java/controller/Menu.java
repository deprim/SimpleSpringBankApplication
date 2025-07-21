package controller;

import commands.MenuCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.UserInputReader;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Menu  {


    private final UserInputReader userInputReader;
    private final Map<String, MenuCommand> menuCommandHashMap = new HashMap<>();


    @Autowired
    public Menu(UserInputReader userInputReader,
                List<MenuCommand> menuCommandList) {
        this.userInputReader = userInputReader;

        for(MenuCommand menuCommand : menuCommandList){
             menuCommandHashMap.put(menuCommand.getCommandName(), menuCommand);
        }

    }


    public void start() {
        String selectedMenuOption;
        while (true) {
            System.out.println("Please enter one of operation type: ");
            List<MenuOptions> menuOptionList = MenuOptions.getMenuOptions();
            for (MenuOptions menuOption : menuOptionList) {
                System.out.println(menuOption);
            }

            selectedMenuOption = userInputReader.readString();
            execute(selectedMenuOption);
        }
    }


    public void execute(String selectedMenuOption) {
        if (menuCommandHashMap.containsKey(selectedMenuOption)) {
            MenuCommand menuCommand = menuCommandHashMap.get(selectedMenuOption);
            System.out.println("Menu option selected: " + selectedMenuOption);
            menuCommand.execute();
        }





    }

}
