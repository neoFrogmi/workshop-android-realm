package com.inzpiral.realmworkshop.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by inzpiral on 1/28/16.
 */
public class PersonModel extends RealmObject {

    @PrimaryKey
    private String rut;
    private String name;
    private int age;

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
