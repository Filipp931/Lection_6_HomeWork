package org;

import GiftsService.Gift;
import PhotoService.Photo;


import java.time.LocalDate;
import java.util.List;

public class Person {
    private long id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private List<Person> friends;
    private List<Gift> gifts;
    private Photo profilePhoto;
    private List<Photo> photos;


    public Person(long id, String name, String surname, LocalDate birthDate, List<Person> friends, List<Gift> gifts, Photo profilePhoto, List<Photo> photos) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.friends = friends;
        this.gifts = gifts;
        this.profilePhoto = profilePhoto;
        this.photos = photos;
    }

    public long getId() {
        return id;
    }

    protected String getName() {
        return name;
    }

    protected String getSurname() {
        return surname;
    }

    protected LocalDate getBirthDate() {
        return birthDate;
    }

    protected List<Person> getFriends() {
        return friends;
    }

    protected List<Gift> getGifts() {
        return gifts;
    }

    protected Photo getProfilePhoto() {
        return profilePhoto;
    }

    protected List<Photo> getPhotos() {
        return photos;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setSurname(String surname) {
        this.surname = surname;
    }

    protected void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    protected void setProfilePhoto(Photo profilePhoto) {
        this.profilePhoto = profilePhoto;
    }


}
