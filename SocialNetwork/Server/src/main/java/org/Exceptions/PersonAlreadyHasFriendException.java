package org.Exceptions;

public class PersonAlreadyHasFriendException extends Exception{
    public PersonAlreadyHasFriendException(String name, String surname, String friendName, String friendSurname) {
        super("Person with name = "+name+" and surname = "+surname+" already has friend with name = "+friendName+" and surname = "+friendSurname);
    }
}
