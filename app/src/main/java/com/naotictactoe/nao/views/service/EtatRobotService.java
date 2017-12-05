package com.naotictactoe.nao.views.service;

import com.naotictactoe.nao.views.model.EndGameModel;
import com.naotictactoe.nao.views.model.RobotModel;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Diane
 */

public interface EtatRobotService {
    @GET("/nao/get-robot-info.php")
    Call<RobotModel> getRobotModel(
            @Query("id_robot") int id_robot
    );
}
