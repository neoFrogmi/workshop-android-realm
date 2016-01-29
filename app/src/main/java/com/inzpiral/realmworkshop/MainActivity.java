package com.inzpiral.realmworkshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.inzpiral.realmworkshop.adapters.CarsAdapter;
import com.inzpiral.realmworkshop.models.CarModel;

import java.util.Random;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    public static final int CURRENT_REALM_VERSION = 0;
    private Button mAddACarButton;
    private Button mAdd10CarsButton;
    private ListView mListView;
    private CarsAdapter mAdapter;

    private RealmUtils mRealmUtils;
    private Button mClearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRealmUtils = new RealmUtils(this);
        mAddACarButton   = (Button) findViewById(R.id.add_a_car_button);
        mAdd10CarsButton = (Button) findViewById(R.id.add_10_cars_button);
        mClearButton     = (Button) findViewById(R.id.clear_cars_button);
        mListView        = (ListView) findViewById(R.id.list_view);

        setUpUiWidgets();
    }

    private void setUpUiWidgets() {
        mAdapter = new CarsAdapter(this, mRealmUtils.getAllCars(), true);
        mListView.setAdapter(mAdapter);

        // Action to add a new Car
        mAddACarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRealmUtils.createRandomCar();
            }
        });

        // Action to create a lot of cars
        mAdd10CarsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRealmUtils.createRandomCars();
            }
        });

        // Action to destroy every Car
        mClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRealmUtils.clearCars();
            }
        });
    }

}
