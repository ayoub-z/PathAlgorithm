package com.Ayoub;


import java.util.List;

class Step implements Comparable<Step> {

    private List<Graph> edges;
    private Character id;
    private Integer distance;

    public Step(Character id, Integer distance) {
        super();
        this.id = id;
        this.distance = distance;
    }

    public Character getId() {
        return id;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setId(Character id) {
        this.id = id;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public String toString() {
        return "Step: " + id + ", distance=" + distance + "";
    }

    public int compareTo(Step o) {
        if (this.distance < o.distance)
            return -1;
        else if (this.distance > o.distance)
            return 1;
        else
            return this.getId().compareTo(o.getId());
    }

}