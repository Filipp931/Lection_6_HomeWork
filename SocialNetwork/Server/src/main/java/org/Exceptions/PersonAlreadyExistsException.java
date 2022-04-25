package org.Exceptions;

public class PersonAlreadyExistsException extends Exception{
    public PersonAlreadyExistsException(String name, String surname) {
        super("Person with name = "+name+" and surname = "+surname+" already exists.");
    }
}
