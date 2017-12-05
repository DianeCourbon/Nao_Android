package com.naotictactoe.nao.views.event;

import com.naotictactoe.nao.views.model.MoteurModel;

import java.util.List;

/**
 * Created by Diane on 03/12/2017.
 */

public class MoteurListEvent {
    List<MoteurModel> moteurList;

    public MoteurListEvent(List<MoteurModel> moteurList) {
        this.moteurList = moteurList;
    }

    public List<MoteurModel> getMoteurList() {
        return moteurList;
    }

    public void setMoteurList(List<MoteurModel> moteurList) {
        this.moteurList = moteurList;
    }
}
