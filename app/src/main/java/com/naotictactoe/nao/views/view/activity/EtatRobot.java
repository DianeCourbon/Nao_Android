package com.naotictactoe.nao.views.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.naotictactoe.nao.R;

import java.util.ArrayList;
import java.util.List;

import com.naotictactoe.nao.views.event.MancheConfigEvent;
import com.naotictactoe.nao.views.event.MoteurListEvent;
import com.naotictactoe.nao.views.event.RobotEvent;
import com.naotictactoe.nao.views.manager.MoteurManager;
import com.naotictactoe.nao.views.manager.RobotManager;
import com.naotictactoe.nao.views.model.MoteurModel;
import com.naotictactoe.nao.views.model.RobotModel;
import com.naotictactoe.nao.views.service.BusProvider;
import com.naotictactoe.nao.views.view.adapter.EtatRobot_Adapter;
import com.naotictactoe.nao.views.view.adapter.Motor_Object;
import com.squareup.otto.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Cyci on 04/11/2017.
 */
public class EtatRobot extends AppCompatActivity {
    @BindView(R.id.idBatterie) TextView getBatterie;
    @BindView(R.id.listMoteur) ListView listMotorState;

    ArrayList<Motor_Object> moteurList;
    EtatRobot_Adapter etatRobotAdapter;

    //transmettre les données, identifiant robot (Cynthia)
    int id_robot = 1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.etatrobot_layout);
        ButterKnife.bind(this);

        RobotManager robotManager = new RobotManager();
        robotManager.getRobotModel(id_robot);

        MoteurManager moteurManager = new MoteurManager();
        moteurManager.AllMoteurManagerGet();
    }

    @Override
    public void onResume(){
        super.onResume();
        BusProvider.getInstance().register(this);
    }

    @Override
    public void onPause(){
        super.onPause();
        BusProvider.getInstance().unregister(this);
    }

    @Subscribe()
    public void onReceiveRobotModel(RobotEvent robotEvent){

        if(robotEvent.getRobotModel()==null){
            Toast.makeText(getApplicationContext(),"Problème de connexion BDD",Toast.LENGTH_SHORT).show();
        }else{
            getBatterie.setText(Integer.toString(robotEvent.getRobotModel().getNiv_batterie()));}
    }


    @Subscribe()
    public void onReceiveListMoteur(MoteurListEvent moteurListEvent){

        moteurList = new ArrayList<>();

        for (int i = 0; i < moteurListEvent.getMoteurList().size(); i++) {
            moteurList.add(new Motor_Object(moteurListEvent.getMoteurList().get(i).getId_moteur(),moteurListEvent.getMoteurList().get(i).getInclinaison(),moteurListEvent.getMoteurList().get(i).getTemperature()));
        }

        etatRobotAdapter = new EtatRobot_Adapter(getApplicationContext(),moteurList);
        listMotorState.setAdapter(etatRobotAdapter);
    }


}
