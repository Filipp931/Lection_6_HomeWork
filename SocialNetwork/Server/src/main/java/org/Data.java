package org;


import java.util.List;

/**
 * Хранилище данных людей в формате класса Person
 */
public class Data {
    private List<Person> people;
    protected List<Person> getPeople(){
        return people;
    }
    protected void addPerson(Person person) {
        people.add(person);
    }
}
