package com.juchnicki;

import com.juchnicki.controllers.SaveToDatabase;
import com.juchnicki.controllers.SaveToFile;
import com.juchnicki.data.Constants;
import com.juchnicki.interfaces.Savable;

import java.util.Scanner;

//import com.juchnicki.controllers.SaveToFile;

/**
 * Created by Rafal on 2016-08-06.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        // 1. Create object that will handle all logic that is in main function
        // 2. Add validation. Create interface i.e. com.juchnicki.validators.Validatable. Create some classes that implement it.
        //    Read about 'chain of responsability', 'strategy' and 'command' design patterns They could be useful.
        // 3. Create at least 3 distinc com.juchnicki.interfaces and classes that implement it (i.e. com.juchnicki.validators.Validatable, Connector, Parser)
        // 4. Use try/catch/finally properly. Read about exception handling in Java. Read about 'try with resources' in Java 7.

        App myApp = new App();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose if You want to save to: \n\t1. File \n\t2. Database\nEnter selection: ");
        int selection = scanner.nextInt();
        Savable saveStrategy = null;

        switch (selection) {
            case 1:
                saveStrategy = myApp.getBean(SaveToFile.class, Constants.STRATEGY_SAVE_TO_FILE);
                break;
            case 2:
                saveStrategy = myApp.getBean(SaveToDatabase.class, Constants.STRATEGY_SAVE_TO_DATABASE);
                break;
            default:
                saveStrategy = myApp.getBean(SaveToFile.class, Constants.STRATEGY_SAVE_TO_FILE);
                System.out.println("Wrong selection, will be saved to file...");
        }
        myApp.setSaveStrategy(saveStrategy);

        myApp.generateCsvFile(args);

    }
}
