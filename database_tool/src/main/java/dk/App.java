package dkk;

import dkk.database.DatabaseManipulator;
// import dk.aau.persons.Person;
import dkk.persons.PersonsHandler;

/**
 * Use this class to run the example code 
 */
public class App {

    /**
     * Example code execution
     * @param args Input argument for the main method. Just leave them blank
     */
    public static void main(String[] args) {
        // Make a new personshandler
        PersonsHandler ph = new PersonsHandler();
        // Use the database manipulator to make a query
        DatabaseManipulator.executeQueryWithResultSet(ph);
        
        ph.getPersonList().stream().forEach(p -> {
            System.out.println(p.toString());
        });

        
        //Person kasper = ph.getPersonList().get(0);
        
        /** 
         * UPDATE EXAMPLE 
        
        kasper.firstName = "Ost";
        System.out.println(kasper.returnSqlUpdate());
        DatabaseManipulator.executeUpdateQuery(kasper);
        */

        /** 
         * INSERT EXAMPLE 
        
        System.out.println(kasper.returnSqlQuery());
        DatabaseManipulator.executeInsertQuery(kasper);
        */

        /** 
         * FETCH DATA EXAMPLE 
        
        Person lars = new Person(2);
        DatabaseManipulator.executeQueryWithResultSet(lars);
        System.out.println(lars.toString());
        */
    }
}
