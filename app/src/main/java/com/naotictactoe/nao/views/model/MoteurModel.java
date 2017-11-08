package com.naotictactoe.nao.views.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Diane on 07/11/2017.
 */

public class MoteurModel implements Serializable {
    @SerializedName("temperature")
    private int temperature;
    @SerializedName("inclinaison")
    private int inclinaison;
    @SerializedName("id_robot")
    private int id_robot;

    public MoteurModel(int id_moteur, int temperature, int inclinaison, int id_robot) {
        this.temperature = temperature;
        this.inclinaison = inclinaison;
        this.id_robot = id_robot;
    }

    //Get
    public int getTemperature() {
        return temperature;
    }

    public int getInclinaison() {
        return inclinaison;
    }

    public int getId_robot() {
        return id_robot;
    }

    //Set
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setInclinaison(int inclinaison) {
        this.inclinaison = inclinaison;
    }

    public void setId_robot(int id_robot) {
        this.id_robot = id_robot;
    }
}
