package com.Ayoub;

import java.util.ArrayList;
import java.util.List;

public class Trip {
    Integer distance;
    private List<Step> path = new ArrayList<>();

    public Trip(Step step, String tripType){
    }

    public Integer getDistance(){
        return this.distance;
    }

}
