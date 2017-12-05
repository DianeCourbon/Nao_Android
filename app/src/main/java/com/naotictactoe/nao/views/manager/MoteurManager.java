package com.naotictactoe.nao.views.manager;

import com.naotictactoe.nao.views.event.ErrorCodeEvent;
import com.naotictactoe.nao.views.event.MoteurListEvent;
import com.naotictactoe.nao.views.model.MoteurModel;
import com.naotictactoe.nao.views.service.BusProvider;
import com.naotictactoe.nao.views.service.MoteursService;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Diane
 */

public class MoteurManager {
    private  static final String SERVER_URL = "http://192.168.0.19";

    public void AllMoteurManagerGet(){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(SERVER_URL)
                .build();

        MoteursService moteursService = retrofit.create(MoteursService.class);
        Call<List<MoteurModel>> call = moteursService.getAllMoteursModel();

        call.enqueue(new Callback<List<MoteurModel>>() {
            @Override
            public void onResponse(Call<List<MoteurModel>> call, Response<List<MoteurModel>> response) {
                BusProvider.getInstance().post(new MoteurListEvent(response.body()));
            }

            @Override
            public void onFailure(Call<List<MoteurModel>> call, Throwable t) {
                t.printStackTrace();
                // handle execution failures like no internet connectivity
                BusProvider.getInstance().post(new ErrorCodeEvent(-2,t.getMessage()));
            }
        });}
        }
