package org.Exceptions;

public class PersonAlreadyHasGiftException extends Exception{
    public PersonAlreadyHasGiftException(String name, String surname) {
        super("Person with name = "+name+" and surname = "+surname+" already has such gift");
    }
}
