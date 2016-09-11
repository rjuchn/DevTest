/**
 * Created by Rafal on 2016-08-06.
 */
public class Main {

    public static void main(String [ ] args) throws Exception {

        // 1. Create object that will handle all logic that is in main function
        // 2. Add validation. Create interface i.e. interfaces.Validator. Create some classes that implement it.
        //    Read about 'chain of responsability', 'strategy' and 'command' design patterns They could be useful.
        // 3. Create at least 3 distinc interfaces and classes that implement it (i.e. interfaces.Validator, Connector, Parser)
        // 4. Use try/catch/finally properly. Read about exception handling in Java. Read about 'try with resources' in Java 7.

        App myApp = new App(args);
        myApp.generateCsvFile();

    }
}
