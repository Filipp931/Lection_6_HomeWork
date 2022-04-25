package org;

import GiftsService.Gift;
import PhotoService.Photo;
import org.Exceptions.*;

import java.util.List;
import java.util.NoSuchElementException;

public class DAO {
    private static Data data;

    /**
     * Поиск человека по ID
     * @param id
     * @return Person
     * @throws PersonNotFoundException если человек не найден
     */

    public static Person getPersonById(Long id) throws PersonNotFoundException, PersonNotFoundException {
        Person personLookingFor;
        try {
            personLookingFor = data.getPeople().stream().filter(person -> person.getId() == id).findAny().get();
        } catch (NoSuchElementException e) {
            throw new PersonNotFoundException(id);
        }
            return personLookingFor;
    }

    /**
     * Получение списка всех людей
     * @return List<Person>
     */
    public static List<Person> getAllPersons(){
        return data.getPeople();
    }

    /**
     * Поиск человека по имени и фимилии
     * @param name
     * @param surname
     * @return person
     * @throws PersonNotFoundException если человек не найден
     */
    public static Person getPersonByName(String name, String surname) throws PersonNotFoundException {
        Person personLookingFor;
        try {
            personLookingFor = data.getPeople().stream().filter(person ->
                    person.getName().equals(name) && person.getSurname().equals(surname))
                    .findAny().get();
        } catch (NoSuchElementException e) {
            throw new PersonNotFoundException(name, surname);
        }
        return personLookingFor;
    }

    /**
     * Проверка наличия человека по имени и фамилии
     * @param name - имя человека
     * @param surname - фамилия
     * @return true - если найден
     */
    public static Boolean containsPersonByName(String name, String surname) {
        try {
            data.getPeople().stream().filter(person ->
                    person.getName().equals(name) && person.getSurname().equals(surname))
                    .findAny().get();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    /**
     * Проверка наличия человека
     * @param person  - то, что ищем
     * @return true если найден
     */
    private static Boolean containsPerson(Person person) {
        return data.getPeople().contains(person);
    }
    /**
     * Добавление нового человека в базу
     * @param person - человек, которого ищем в базе
     */
    public static void addNewPerson(Person person) throws PersonAlreadyExistsException {
        if(containsPersonByName(person.getName(), person.getSurname())){
            throw new PersonAlreadyExistsException(person.getName(), person.getSurname());
        } else {
            data.addPerson(person);
        }
    }

    /**
     * Установка фото профиля
     * @param photo - фото
     * @param person - человек, в профиле которого устанавливаем
     * @throws PersonNotFoundException - если такого человека не существует
     */
    public static void setProfilePhoto(Photo photo, Person person) throws PersonNotFoundException {
        if(containsPerson(person)){
            person.setProfilePhoto(photo);
        } else throw new PersonNotFoundException(person.getName(), person.getSurname());
    }

    /**
     * Проверка наличия фото у человека
     * @param photo - фото
     * @param person - человек
     * @return true - если у человека уже есть такое фото
     * @throws PersonAlreadyExistsException
     */
    private static Boolean photoCheck(Photo photo, Person person) throws PersonNotFoundException {
        if(containsPerson(person)){
            return person.getPhotos().contains(photo);
        } else {
            throw new PersonNotFoundException(person.getName(), person.getSurname());
        }
    }

    /**
     * Добавление дополнительного фото в профиль
     * @param photo - фото
     * @param person - человек
     * @throws PersonNotFoundException - если такого человека не найдено
     * @throws PersonAlreadyHasPhotoException - если у человека уже имеется такое фото
     */
    public static void addPhoto(Photo photo, Person person) throws PersonNotFoundException, PersonAlreadyHasPhotoException {
        if(!photoCheck(photo, person)){
            person.getPhotos().add(photo);
        } else throw new PersonAlreadyHasPhotoException(person.getName(), person.getSurname());
    }

    public static void deletePhoto(Photo photo, Person person) throws PersonNotFoundException, PersonDoesNotHaveThisPhotoException {
        if(photoCheck(photo, person)) {
            person.getPhotos().remove(photo);
        } else {
            throw new PersonDoesNotHaveThisPhotoException(person.getName(), person.getSurname());
        }

    }


    /**
     * Проверка наличия подарка у человека
     * @param gift - подарок
     * @param person - человек
     * @return true  - если такой подарок есть у человека
     * @throws PersonNotFoundException - если такого человека нет в базе
     */
    private static Boolean checkGift(Gift gift, Person person) throws PersonNotFoundException {
        if(containsPerson(person)){
            return person.getGifts().contains(gift);
        } else {
            throw new PersonNotFoundException(person.getName(), person.getSurname());
        }
    }

    /**
     * Добавление подарка человеку
     * @param gift - подарок
     * @param person - человек
     * @throws PersonAlreadyHasGiftException - если у человека уже существует такой подарок
     * @throws PersonNotFoundException - если такого человека нет в базе
     */
    public static void addGift(Gift gift, Person person) throws PersonAlreadyHasGiftException, PersonNotFoundException {
        if(checkGift(gift, person)) {
            throw new PersonAlreadyHasGiftException(person.getName(), person.getSurname());
        } else {
            person.getGifts().add(gift);
        }
    }
    public static void removeGift(Gift gift, Person person) throws PersonNotFoundException, PersonDoesNotHaveThisGiftException {
        if(checkGift(gift, person)) {
            person.getGifts().remove(gift);
        } else {
            throw new PersonDoesNotHaveThisGiftException(person.getName(), person.getSurname());
        }
    }

  /*  *//**
     * Проверка наличия рекоммендации у человека
     * @param recommendation - рекоммендация
     * @param person - человек
     * @return true - если есть
     * @throws PersonNotFoundException - если такого человека нет в базе
     *//*
    private Boolean checkRecommendation(Recommendation recommendation, Person person) throws PersonNotFoundException {
        if(containsPerson(person)) {
            return person.getRecommendationList().contains(recommendation);
        } else {
            throw new PersonNotFoundException(person.getName(), person.getSurname());
        }

    }

    *//**
     * Добавление рекоммендации
     * @param recommendation - рекоммендация
     * @param person - человек
     * @throws PersonAlreadyHasRecommendation - если у человека уже существует такая рекоммендация
     * @throws PersonNotFoundException - если такого человека нет в базе
     *//*
    public void addRecommendation(Recommendation recommendation, Person person) throws PersonAlreadyHasRecommendation, PersonNotFoundException {
        if(checkRecommendation(recommendation, person)){
            throw new PersonAlreadyHasRecommendation(person.getName(), person.getSurname());
        } else {
            person.getRecommendationList().add(recommendation);
        }
    }*/

    /**
     * Проверка наличия друга у человека
     * @param friend - друг
     * @param person - человек
     * @return true - если такой друг есть
     * @throws PersonNotFoundException - если кто-то из людей не найден в базе
     */
    private static boolean checkFriend(Person friend, Person person) throws PersonNotFoundException {
        if (!containsPerson(friend)) {
            throw new PersonNotFoundException(friend.getName(), friend.getSurname());
        } else {
            if (!containsPerson(person)) {
                throw new PersonNotFoundException(person.getName(), person.getSurname());
            } else {
                if (person.getFriends().contains(friend)) {
                    return true;
                }
                return false;
            }
        }
    }

    /**
     * Добавление друга
     * @param friend - друг
     * @param person - человек, кому добавляем друга
     * @throws PersonNotFoundException  - если такого человека/друга нет в базе
     * @throws PersonAlreadyHasFriendException - если у человека уже есть этот друг
     */
    public static void addFriend(Person friend, Person person) throws PersonNotFoundException, PersonAlreadyHasFriendException {
        if(checkFriend(friend, person)){
            throw  new PersonAlreadyHasFriendException(person.getName(), person.getSurname(), friend.getName(), friend.getSurname());
        } else {
            person.getFriends().add(friend);
        }
    }

    /**
     * Удаление друга из списка друзей человека
     * @param friend - друг
     * @param person - человек
     * @throws PersonNotFoundException
     */
    public static void deleteFriend(Person friend, Person person) throws PersonNotFoundException, PersonDoesNotHaveThisFriendException {
        if(!checkFriend(friend, person)){
            person.getFriends().remove(friend);
        } else {
            throw new PersonDoesNotHaveThisFriendException(person.getName(), person.getSurname(), friend.getName(), friend.getSurname());
        }
    }

}
