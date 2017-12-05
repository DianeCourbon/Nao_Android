package com.naotictactoe.nao.views.manager;

import android.util.Log;

import com.naotictactoe.nao.views.event.ErrorCodeEvent;
import com.naotictactoe.nao.views.event.MancheConfigEvent;
import com.naotictactoe.nao.views.event.RobotEvent;
import com.naotictactoe.nao.views.model.EndGameModel;
import com.naotictactoe.nao.views.model.RobotModel;
import com.naotictactoe.nao.views.service.BusProvider;
import com.naotictactoe.nao.views.service.EndGameService;
import com.naotictactoe.nao.views.service.EtatRobotService;
import com.naotictactoe.nao.views.service.MancheConfigService;

import org.greenrobot.eventbus.EventBus;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Diane
 */

public class RobotManager {
    private  static final String SERVER_URL = "http://192.168.0.19";

    public void getRobotModel(int id_robot){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(SERVER_URL)
                .build();

        EtatRobotService robotService =retrofit.create(EtatRobotService.class);
        Call<RobotModel> call = robotService.getRobotModel(id_robot);

        call.enqueue(new Callback<RobotModel>() {
            @Override
            public void onResponse(Call<RobotModel> call, Response<RobotModel> response) {
                BusProvider.getInstance().post(new RobotEvent(response.body()));

                    /*//on poste le robotmodel
                    EventBus.getDefault().post(robotModel);
                    //On peut ajouter un eventconnexion, et lui ajouter en attribut le robotmodel*/

                    Log.d("Etat du robot (manager)","Success");

            }

            @Override
            public void onFailure(Call<RobotModel> call, Throwable t) {
                t.printStackTrace();
                // handle execution failures like no internet connectivity
                BusProvider.getInstance().post(new ErrorCodeEvent(-2,t.getMessage()));
            }
        });

}}
