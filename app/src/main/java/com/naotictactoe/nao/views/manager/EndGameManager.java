package com.naotictactoe.nao.views.manager;

import android.util.Log;

import com.naotictactoe.nao.views.event.EndGameEvent;
import com.naotictactoe.nao.views.event.ErrorCodeEvent;
import com.naotictactoe.nao.views.model.EndGameModel;
import com.naotictactoe.nao.views.service.BusProvider;
import com.naotictactoe.nao.views.service.EndGameService;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Diane
 */

public class EndGameManager {
    private  static final String SERVER_URL = "http://192.168.0.19";
    private EndGameModel endGameModel = null;

    public EndGameModel EndGameGet(int id_partie){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(SERVER_URL)
                .build();

        EndGameService EndgameService = retrofit.create(EndGameService.class);
        Call<EndGameModel> call = EndgameService.getEndGameService(id_partie);

        call.enqueue(new Callback<EndGameModel>() {
            @Override
            public void onResponse(Call<EndGameModel> call, Response<EndGameModel> response) {
                BusProvider.getInstance().post(new EndGameEvent());

                //Vérifier transmission de la réponse !!
                endGameModel = response.body();

                Log.d("EndGameModel(manager)","Success");
            }

            @Override
            public void onFailure(Call<EndGameModel> call, Throwable t) {
                t.printStackTrace();
                // handle execution failures like no internet connectivity
                BusProvider.getInstance().post(new ErrorCodeEvent(-2,t.getMessage()));
            }
        });

        return endGameModel;
    }
}
