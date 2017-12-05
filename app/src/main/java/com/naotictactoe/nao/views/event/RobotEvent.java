package com.naotictactoe.nao.views.event;

import com.naotictactoe.nao.views.model.RobotModel;

/**
 * Created by Diane on 03/12/2017.
 */

public class RobotEvent {
    RobotModel robotModel;

    public RobotEvent(RobotModel robotModel) {
        this.robotModel = robotModel;
    }

    public RobotModel getRobotModel() {
        return robotModel;
    }

    public void setRobotModel(RobotModel robotModel) {
        this.robotModel = robotModel;
    }
}
