package com.naotictactoe.nao.views.manager;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.naotictactoe.nao.views.event.ErrorCodeEvent;
import com.naotictactoe.nao.views.event.MancheConfigEvent;
import com.naotictactoe.nao.views.model.PartieJoueeModel;
import com.naotictactoe.nao.views.service.BusProvider;
import com.naotictactoe.nao.views.service.MancheConfigService;
import com.squareup.otto.Produce;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Diane on 06/11/2017.
 */

public class MancheConfigManager {
    private  static final String SERVER_URL = "http://192.168.215.98/nao/";

    public void MancheConfigPost(boolean symbole_joueur, boolean joueur_tour_1, boolean gagnant_joueur, int id_robot, int id_session){
        //Here a MancheConfig interceptor is created
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        //The logging interceptor will be added to the http client
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        //The Retrofit builder will have the client attached, in order to get connection logs
        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(SERVER_URL)
                .build();

        MancheConfigService mancheConfigService = retrofit.create(MancheConfigService.class);

        Call<PartieJoueeModel> call = mancheConfigService.post(symbole_joueur,joueur_tour_1,gagnant_joueur,id_robot,id_session);

        call.enqueue(new Callback<PartieJoueeModel>() {
            @Override
            public void onResponse(Call<PartieJoueeModel> call, Response<PartieJoueeModel> response) {
                BusProvider.getInstance().post(new MancheConfigEvent(response.body()));
                Log.e("Configuration(manager)","Success");
            }

            @Override
            public void onFailure(Call<PartieJoueeModel> call, Throwable t) {
                // handle execution failures like no internet connectivity
                BusProvider.getInstance().post(new ErrorCodeEvent(-2,t.getMessage()));
            }
        });
    }

    @Produce
    public MancheConfigEvent produceServerEvent(PartieJoueeModel serverResponse) {
        return new MancheConfigEvent(serverResponse);
    }

    @Produce
    public ErrorCodeEvent produceErrorEvent(int errorCode, String errorMsg) {
        return new ErrorCodeEvent(errorCode, errorMsg);
    }
}

