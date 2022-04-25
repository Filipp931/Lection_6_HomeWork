package org.Exceptions;

public class PersonDoesNotHaveThisGiftException extends Exception{
    public PersonDoesNotHaveThisGiftException(String name, String surname) {
        super("Person with name = "+name+" and surname = "+surname+" does not have this gift");
    }
}
