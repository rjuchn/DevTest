import controllers.SaveToDatabase;
import controllers.SaveToFile;

import java.util.Scanner;

/**
 * Created by Rafal on 2016-08-06.
 */
public class Main {

    public static void main(String [ ] args) throws Exception {

        // 1. Create object that will handle all logic that is in main function
        // 2. Add validation. Create interface i.e. validators.Validatable. Create some classes that implement it.
        //    Read about 'chain of responsability', 'strategy' and 'command' design patterns They could be useful.
        // 3. Create at least 3 distinc interfaces and classes that implement it (i.e. validators.Validatable, Connector, Parser)
        // 4. Use try/catch/finally properly. Read about exception handling in Java. Read about 'try with resources' in Java 7.

        App myApp = new App();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose if You want to save to: \n\t1. File \n\t2. Database\nEnter selection: ");
        int selection = scanner.nextInt();

        switch(selection) {
            case 1:
                myApp.setSaveStrategy(new SaveToFile());
                break;
            case 2:
                myApp.setSaveStrategy(new SaveToDatabase());
                break;
            default:
                myApp.setSaveStrategy(new SaveToFile());
                System.out.println("Wrong selection, will be saved to file.");
        }

        myApp.generateCsvFile(args);

    }
}
