package org.Exceptions;

public class PersonAlreadyHasPhotoException extends Exception{
    public PersonAlreadyHasPhotoException(String name, String surname) {
        super("Person with name = "+name+" and surname = "+surname+" already has such photo");
    }
}
