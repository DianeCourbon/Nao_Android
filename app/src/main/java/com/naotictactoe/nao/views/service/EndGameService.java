package com.naotictactoe.nao.views.service;

import com.naotictactoe.nao.views.model.EndGameModel;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Diane
 */

public interface EndGameService {
    @FormUrlEncoded
    @GET("/nao/get-partie.php")
    Call<EndGameModel> getEndGameService(
            @Query("id_partie") int id_partie
    );

}
