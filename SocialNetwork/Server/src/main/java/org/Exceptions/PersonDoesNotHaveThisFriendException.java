package org.Exceptions;

public class PersonDoesNotHaveThisFriendException extends Exception{
    public PersonDoesNotHaveThisFriendException(String name, String surname, String friendName, String friendSurname) {
        super("Person with name = "+name+" and surname = "+surname+" does not have friend with name = "+friendName+" and surname = "+friendSurname);
    }
}
