package com.naotictactoe.nao.views.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Diane on 06/11/2017.
 */

public class RobotModel implements Serializable {
    @SerializedName("niv_batterie")
    private int niv_batterie;

    @SerializedName("id_robot")
    private int id_robot;

    public RobotModel(int niv_batterie, int id_robot) {
        this.niv_batterie = niv_batterie;
        this.id_robot = id_robot;
    }

    //Get
    public int getNiv_batterie() {
        return niv_batterie;
    }

    public int getId_robot() {
        return id_robot;
    }
    //Set
    public void setNiv_batterie(int niv_batterie) {
        this.niv_batterie = niv_batterie;
    }

    public void setId_robot(int id_robot) {
        this.id_robot = id_robot;
    }
}
