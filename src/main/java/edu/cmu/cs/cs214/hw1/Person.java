package edu.cmu.cs.cs214.hw1;

/**
 * This class represents a person
 * 
 * @author Kathleen.
 *
 */
public class Person{
    private String name;
    /**
     * Constructor to initialize Person with the name.
     * 
     * @param personName Name given to Person object by client.
     */
    public Person(String personName) {
        name = personName;
    }

    /**
     * Method to allow retrieval of the private variable name's value.
     * 
     * @return name of Person object.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Compares two Person objects for equality, assumes names are unique.
     * 
     * @param other The person to be compared to.
     * @return true if names are the same, false otherwise.
     */
    public boolean isEqual(Person other) {
        return this.name == other.name;
    }

}
