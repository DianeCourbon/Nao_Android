package com.naotictactoe.nao.views.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Diane on 06/11/2017.
 */

public class RobotModel implements Serializable {
    @SerializedName("niv_batterie")
    private int niv_batterie;

    public RobotModel(int id_robot, int niv_batterie) {
        this.niv_batterie = niv_batterie;
    }

    //Get

    public int getNiv_batterie() {
        return niv_batterie;
    }

    //Set
    public void setNiv_batterie(int niv_batterie) {
        this.niv_batterie = niv_batterie;
    }
}
