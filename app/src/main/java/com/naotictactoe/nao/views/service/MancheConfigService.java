package com.naotictactoe.nao.views.service;

import com.naotictactoe.nao.views.model.PartieJoueeModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;

import retrofit2.http.POST;

/**
 * Created by Diane on 06/11/2017.
 */

public interface MancheConfigService {
    @FormUrlEncoded
    @POST("/nao/post-partie.php")
    Call<Void> post(
            @Field("symbole_joueur") boolean symbole_joueur,
            @Field("joueur_tour_1") boolean joueur_tour_1,
            @Field("gagnant_joueur") boolean gagnant_joueur,
            @Field("id_robot") int id_robot,
            @Field("id_session") int id_session);

}



  /*//This method is used for "GET"
    @GET("/api.php")
    Call<ServerResponse> get(
            @Query("method") String method,
            @Query("username") String username,
            @Query("password") String password
    );

}*/

