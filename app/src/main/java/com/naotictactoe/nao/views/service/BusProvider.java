package com.naotictactoe.nao.views.service;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * Created by Diane on 07/11/2017.
 */

public class BusProvider {
    private static final Bus BUS = new Bus(ThreadEnforcer.MAIN);

    public static Bus getInstance(){
        return BUS;
    }

    public BusProvider(){}
}
