package org.Exceptions;

public class PersonNotFoundException extends Exception {
    public PersonNotFoundException(Long id) {
        super("Person with id ="+id+" not found");
    }
    public PersonNotFoundException(String name, String surname) {
        super("Person with name = "+name+" and surname = "+surname+" not found");
    }
}
