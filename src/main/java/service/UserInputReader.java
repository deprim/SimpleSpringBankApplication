package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Scanner;


@Service
public class UserInputReader {

    private Scanner input;

    @Autowired
    public UserInputReader(Scanner input) {
        this.input = input;
    }


    public String readString(){
        return input.nextLine();

    }

    public Integer readInt(){
        Integer value = input.nextInt();
        input.nextLine();
        return value;
    }
}
