package org.Exceptions;

public class PersonAlreadyHasRecommendation extends Exception{
    public PersonAlreadyHasRecommendation(String name, String surname) {
        super("Person with name = "+name+" and surname = "+surname+" already has such recommendation");
    }
}
