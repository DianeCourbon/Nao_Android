package com.naotictactoe.nao.views.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Diane on 07/11/2017.
 */

public class MoteurModel implements Serializable {
    @SerializedName("temperature")
    private Double temperature;
    @SerializedName("inclinaison")
    private Double inclinaison;
    @SerializedName("id_moteur")
    private int id_moteur;

    public MoteurModel(int id_moteur, Double temperature, Double inclinaison){
        this.temperature = temperature;
        this.inclinaison = inclinaison;
        this.id_moteur = id_moteur;
    }

    //Get
    public Double getTemperature() {
        return temperature;
    }
    public Double getInclinaison() {
        return inclinaison;
    }
    public int getId_moteur() {
        return id_moteur;
    }

    //Set
    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }
    public void setInclinaison(Double inclinaison) {
        this.inclinaison = inclinaison;
    }
    public void setId_moteur(int id_moteur) {
        this.id_moteur = id_moteur;
    }
}
