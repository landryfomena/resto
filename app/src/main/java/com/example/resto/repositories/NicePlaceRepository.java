package com.example.resto.repositories;


import androidx.lifecycle.MutableLiveData;

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
    public MutableLiveData<List<NicePlace>> getNicePlaces(ArrayList<NicePlace> dataSet){
        MutableLiveData<List<NicePlace>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }

}












