package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Menu implements MenuCommand {


    Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void displayMenuOptions() {
        for (Menu)
    }

    public void execute(){



    }
}
