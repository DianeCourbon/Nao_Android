package com.naotictactoe.nao.views.event;

import com.naotictactoe.nao.views.model.PartieJoueeModel;

/**
 * Created by Diane on 07/11/2017.
 */

public class MancheConfigEvent {
    private PartieJoueeModel partie;

    public MancheConfigEvent(PartieJoueeModel partie) {
        this.partie = partie;
    }

    public PartieJoueeModel getPartie() {
        return partie;
    }

    public void setPartie(PartieJoueeModel partie) {
        this.partie = partie;
    }
}
