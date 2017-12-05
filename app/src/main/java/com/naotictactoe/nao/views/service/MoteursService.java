package com.naotictactoe.nao.views.service;

import com.naotictactoe.nao.views.model.MoteurModel;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

/**
 * Created by Diane
 */

public interface MoteursService {
    @GET("/nao/get-robot-moteur-info.php")
    Call<List<MoteurModel>> getAllMoteursModel();

}
