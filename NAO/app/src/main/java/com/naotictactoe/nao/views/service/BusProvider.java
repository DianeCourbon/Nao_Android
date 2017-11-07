package com.naotictactoe.nao.views.service;

import com.squareup.otto.Bus;

/**
 * Created by Diane on 07/11/2017.
 */

public class BusProvider {
    private static final Bus BUS = new Bus();

    public static Bus getInstance(){
        return BUS;
    }

    public BusProvider(){}
}
