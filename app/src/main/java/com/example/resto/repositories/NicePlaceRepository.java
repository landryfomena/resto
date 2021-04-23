package com.example.resto.repositories;


import androidx.lifecycle.MutableLiveData;

import com.example.resto.R;
import com.example.resto.models.NicePlace;

import java.util.ArrayList;
import java.util.List;


public class NicePlaceRepository {

    private static NicePlaceRepository instance;
    private ArrayList<NicePlace> dataSet = new ArrayList<>();

    public static NicePlaceRepository getInstance(){
        if(instance == null){
            instance = new NicePlaceRepository();
        }
        return instance;
    }


    // Pretend to get data from a webservice or online source
    public MutableLiveData<List<NicePlace>> getNicePlaces(){
        setNicePlaces();
        MutableLiveData<List<NicePlace>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }

    private void setNicePlaces(){
        dataSet.add(
                new NicePlace(R.drawable.ic_burger,
                        "Burger")
        );
        dataSet.add(
                new NicePlace(R.drawable.ic_american,
                        "American")
        );
        dataSet.add(
                new NicePlace(R.drawable.ic_pizza,
                        "Pizza")
        );
        dataSet.add(
                new NicePlace(R.drawable.ic_barbecue,
                        "Barbecue")
        );
        dataSet.add(
                new NicePlace(R.drawable.ic_burger,
                        "Burger")
        );
        dataSet.add(
                new NicePlace(R.drawable.ic_american,
                        "American")
        );
    }
}












