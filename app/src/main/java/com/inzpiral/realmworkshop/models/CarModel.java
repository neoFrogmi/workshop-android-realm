package com.inzpiral.realmworkshop.models;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * Created by inzpiral on 1/28/16.
 */
public class CarModel extends RealmObject {

    @Ignore public static int ENGINE_STATUS_ON;
    @Ignore public static int ENGINE_STATUS_OFF;
    @Ignore public static int ENGINE_STATUS_IDLE;

    private int car_id;

    private int engineStatus;
    private String modelName;
    private int year;
    private int doors;

    private RealmList<PersonModel> currentPassengers;

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public int getEngineStatus() {
        return engineStatus;
    }

    public void setEngineStatus(int engineStatus) {
        this.engineStatus = engineStatus;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public RealmList<PersonModel> getCurrentPassengers() {
        return currentPassengers;
    }

    public void setCurrentPassengers(RealmList<PersonModel> currentPassengers) {
        this.currentPassengers = currentPassengers;
    }
}
