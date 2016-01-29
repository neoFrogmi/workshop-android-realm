package com.inzpiral.realmworkshop;

import android.content.Context;
import android.os.AsyncTask;

import com.inzpiral.realmworkshop.models.CarModel;

import java.util.Random;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by inzpiral on 1/29/16.
 */
public class RealmUtils {

    private final Context mContext;
    private String[] sRandomCarBrands = {"Peugeot", "Suzuki", "Lada", "Skoda", "Chevrolet", "Toyota"};
    private Realm mRealm;

    public RealmUtils(Context context) {
        mContext = context;
        mRealm = Realm.getInstance(context.getApplicationContext());
    }

    /**
     * Create a Card with random data
     */
    public void createRandomCar() {
        mRealm.beginTransaction();
        createRandomCar(mRealm);
        mRealm.commitTransaction();
    }

    /**
     * Create a Card with random data
     * @param realm
     */
    public void createRandomCar(Realm realm) {
        final Random random = new Random();

        CarModel car = realm.createObject(CarModel.class);
        car.setCar_id((int) System.currentTimeMillis());
        car.setModelName(sRandomCarBrands[random.nextInt(sRandomCarBrands.length)]);
        car.setDoors(random.nextInt(4) + 1);
        car.setYear(2016);
        car.setEngineStatus(CarModel.ENGINE_STATUS_OFF);
    }

    /**
     * Create a large number of random cars
     */
    public void createRandomCars() {

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                Realm realm = Realm.getInstance(mContext.getApplicationContext());
                realm.beginTransaction();
                for (int i = 0; i < 1000; i++) {
                    createRandomCar(realm);
                }
                realm.commitTransaction();

                return null;
            }
        }.execute();
    }

    /*
     * Get all cars stored
     */
    public RealmResults<CarModel> getAllCars() {
        RealmResults<CarModel> results = mRealm.allObjects(CarModel.class);
        return results;
    }

    /**
     * Destroy every Car stored
     */
    public void clearCars() {
        Realm realm = Realm.getInstance(mContext.getApplicationContext());
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.clear(CarModel.class);
            }
        });
    }
}
