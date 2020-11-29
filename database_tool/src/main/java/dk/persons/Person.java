package dkk.persons;

import java.sql.ResultSet;
import java.sql.SQLException;

import dkk.database.Queryable;

/**
 * Simple example of a Person Class with first and last name
 */
public class Person implements Queryable {

    /**
     * First name of the person
     */
    public String firstName;
    /**
     * Last name of the person
     */
    public String lastName;
    /**
     * ID of the person
     */
    public int ID;

    /**
     * Constructor with input for first and last name and ID
     * @param firstName First name
     * @param lastName  Last name
     * @param ID        ID of the person
     */
    public Person(String firstName, String lastName, int ID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
    }

    /**
     * Constructor with input for first and last name
     * @param firstName First name
     * @param lastName Last name
     */
    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Constructor for Person with only ID
     * @param ID ID of the Person
     */
    public Person(int ID){
        this.ID = ID;
    }

    /**
     * Return a String with the persons ID, First and Last name
     */
    @Override
    public String toString() {
        return "ID: " + Integer.toString(this.ID) + " Name: " + this.firstName + " " + this.lastName;
    }

    /**
     * Method that sets the First and Last Name of the person
     * based on the resultset from the database
     */
    @Override
    public void processResultSet(ResultSet rs) throws SQLException {
        rs.next();
        this.firstName = rs.getString("FirstName");
        this.lastName = rs.getString("LastName");
    }

    /**
     * Method for inserting a Person object into the database
     * NOTE: The Person will be added with no ID number. This will be
     * assigned by the database.
     */
    @Override
    public String returnSqlQuery() {
        String sqlQuery = "SELECT FirstName, LastName FROM Persons WHERE ID='" + this.ID + "'";
        return sqlQuery;
    }

    /**
     * Method that updates the Person entry in the database
     */
    @Override
    public String returnSqlUpdate() {
        
        String sqlQuery = "UPDATE Persons SET FirstName='" + this.firstName + "', LastName='" + this.lastName + "' WHERE id=" + this.ID;
        return sqlQuery;

    }

}