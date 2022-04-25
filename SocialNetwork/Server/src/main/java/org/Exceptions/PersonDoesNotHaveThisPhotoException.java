package org.Exceptions;

public class PersonDoesNotHaveThisPhotoException extends Exception{
    public PersonDoesNotHaveThisPhotoException(String name, String surname) {
        super("Person with name = "+name+" and surname = "+surname+" does not have this photo");
    }
}
