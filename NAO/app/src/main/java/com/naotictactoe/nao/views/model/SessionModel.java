package com.naotictactoe.nao.views.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Diane on 06/11/2017.
 */

public class SessionModel implements Serializable{
    @SerializedName("nbr_parties_gagnees_joueur")
    private int nbr_parties_gagnees_joueur;
    @SerializedName("nbr_parties_totales")
    private int nbr_parties_totales;
    @SerializedName("c_pourcentage_victoire")
    private float c_pourcentage_victoire;
    @SerializedName("id_tt_session")
    private int id_tt_session;

    public SessionModel(int id_session, int nbr_parties_gagnees_joueur, int nbr_parties_totales, float c_pourcentage_victoire, int id_tt_session) {
        this.nbr_parties_gagnees_joueur = nbr_parties_gagnees_joueur;
        this.nbr_parties_totales = nbr_parties_totales;
        this.c_pourcentage_victoire = c_pourcentage_victoire;
        this.id_tt_session = id_tt_session;
    }

    //Get
    public int getNbr_parties_gagnees_joueur() {
        return nbr_parties_gagnees_joueur;
    }

    public int getNbr_parties_totales() {
        return nbr_parties_totales;
    }

    public float getC_pourcentage_victoire() {
        return c_pourcentage_victoire;
    }

    public int getId_tt_session() {
        return id_tt_session;
    }

    //Set
    public void setNbr_parties_gagnees_joueur(int nbr_parties_gagnees_joueur) {
        this.nbr_parties_gagnees_joueur = nbr_parties_gagnees_joueur;
    }

    public void setNbr_parties_totales(int nbr_parties_totales) {
        this.nbr_parties_totales = nbr_parties_totales;
    }

    public void setC_pourcentage_victoire(float c_pourcentage_victoire) {
        this.c_pourcentage_victoire = c_pourcentage_victoire;
    }

    public void setId_tt_session(int id_tt_session) {
        this.id_tt_session = id_tt_session;
    }
}
