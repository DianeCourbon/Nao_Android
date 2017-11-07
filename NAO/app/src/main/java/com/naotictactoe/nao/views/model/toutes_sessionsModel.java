package com.naotictactoe.nao.views.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Diane on 07/11/2017.
 */

public class toutes_sessionsModel implements Serializable {
    @SerializedName("nbr_parties_gagnees_joueurs")
    private int nbr_parties_gagnees_joueurs;
    @SerializedName("nbr_parties_totales")
    private int nbr_parties_totales;
    @SerializedName("c_pourcentage_victoires")
    private int c_pourcentage_victoires;
    @SerializedName("id_robot")
    private  int 	id_robot;

    public toutes_sessionsModel(int nbr_parties_gagnees_joueurs, int nbr_parties_totales, int c_pourcentage_victoires, int id_robot) {
        this.nbr_parties_gagnees_joueurs = nbr_parties_gagnees_joueurs;
        this.nbr_parties_totales = nbr_parties_totales;
        this.c_pourcentage_victoires = c_pourcentage_victoires;
        this.id_robot = id_robot;
    }

    //Get
    public int getNbr_parties_gagnees_joueurs() {
        return nbr_parties_gagnees_joueurs;
    }

    public int getNbr_parties_totales() {
        return nbr_parties_totales;
    }

    public int getC_pourcentage_victoires() {
        return c_pourcentage_victoires;
    }

    public int getId_robot() {
        return id_robot;
    }

    //Set
    public void setNbr_parties_gagnees_joueurs(int nbr_parties_gagnees_joueurs) {
        this.nbr_parties_gagnees_joueurs = nbr_parties_gagnees_joueurs;
    }

    public void setNbr_parties_totales(int nbr_parties_totales) {
        this.nbr_parties_totales = nbr_parties_totales;
    }

    public void setC_pourcentage_victoires(int c_pourcentage_victoires) {
        this.c_pourcentage_victoires = c_pourcentage_victoires;
    }

    public void setId_robot(int id_robot) {
        this.id_robot = id_robot;
    }
}
