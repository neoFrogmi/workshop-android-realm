package com.inzpiral.realmworkshop.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.inzpiral.realmworkshop.R;
import com.inzpiral.realmworkshop.models.CarModel;

import io.realm.RealmBaseAdapter;
import io.realm.RealmResults;

/**
 * Created by inzpiral on 1/28/16.
 */
public class CarsAdapter extends RealmBaseAdapter<CarModel> {

    public CarsAdapter(Context context, RealmResults<CarModel> realmResults, boolean automaticUpdate) {
        super(context, realmResults, automaticUpdate);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        CarModelHolder holder;
        if (view == null) {
            holder = new CarModelHolder();
            view = LayoutInflater.from(context).inflate(R.layout.car_item, viewGroup, false);
            holder.mBrandTextView = (TextView) view.findViewById(R.id.car_brand_textview);
            holder.mPassengers = (TextView) view.findViewById(R.id.car_passengers_textview);
            holder.mYearTextView = (TextView) view.findViewById(R.id.car_year_textview);
            holder.mCarDoorsView = (TextView) view.findViewById(R.id.car_doors_textview);

            view.setTag(holder);
        } else {
            holder = (CarModelHolder) view.getTag();
        }

        CarModel car = realmResults.get(i);
        holder.mBrandTextView.setText(car.getModelName());
        holder.mPassengers.setText(String.format("Passengers inside: %s", car.getCurrentPassengers().size()));
        holder.mYearTextView.setText(String.format("Year: %s", car.getYear()));
        holder.mCarDoorsView.setText(String.format(String.format("Doors: %s", car.getDoors())));
        return view;
    }

    class CarModelHolder {
        TextView mBrandTextView;
        TextView mYearTextView;
        TextView mCarDoorsView;
        TextView mPassengers;
    }
}
