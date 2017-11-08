package com.naotictactoe.nao.views.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Diane on 06/11/2017.
 */

public class PartieJoueeModel implements Serializable {
    @SerializedName("symbole_joueur")
    private boolean symbole_joueur;
    @SerializedName("joueur_tour_1")
    private boolean joueur_tour_1;
    @SerializedName("gagnant_joueur")
    private boolean gagnant_joueur;
    @SerializedName("id_robot")
    private int id_robot;
    @SerializedName("id_session")
    private int id_session;

    public PartieJoueeModel(boolean symbole_joueur, boolean joueur_tour_1, boolean gagnant_joueur, int id_robot, int id_session) {
        this.symbole_joueur = symbole_joueur;
        this.joueur_tour_1 = joueur_tour_1;
        this.gagnant_joueur = gagnant_joueur;
        this.id_robot = id_robot;
        this.id_session = id_session;
    }

    //GET

    public boolean isSymbole_joueur() {
        return symbole_joueur;
    }

    public boolean isJoueur_tour_1() {
        return joueur_tour_1;
    }

    public boolean isGagnant_joueur() {
        return gagnant_joueur;
    }

    public int getId_robot() {
        return id_robot;
    }

    public int getId_session() {
        return id_session;
    }

    //SET
    public void setSymbole_joueur(boolean symbole_joueur) {
        this.symbole_joueur = symbole_joueur;
    }

    public void setJoueur_tour_1(boolean joueur_tour_1) {
        this.joueur_tour_1 = joueur_tour_1;
    }

    public void setGagnant_joueur(boolean gagnant_joueur) {
        this.gagnant_joueur = gagnant_joueur;
    }

    public void setId_robot(int id_robot) {
        this.id_robot = id_robot;
    }

    public void setId_session(int id_session) {
        this.id_session = id_session;
    }
}
