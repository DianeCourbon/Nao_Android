package com.naotictactoe.nao.views.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.naotictactoe.nao.R;
import com.naotictactoe.nao.views.event.MancheConfigEvent;
import com.naotictactoe.nao.views.manager.MancheConfigManager;
import com.naotictactoe.nao.views.service.BusProvider;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Cyci on 04/11/2017.
 * Modified by Diane on 06/11/2017
 */

public class MancheConfigActivity extends AppCompatActivity {

    private MancheConfigManager mancheConfigManager;
    public static Bus bus;

    //partie de test, à voir avec Cynthia
    //uniquement pour la connection bdd
    private boolean symbole_joueur = false;
    private boolean joueur_tour_1 = false;
    private boolean gagnant_joueur = false;
    private int id_robot=1;
    private int id_session=1;


    //Déclaration des variables
    private int symbol;
    private int tour;
    private String robotIP;

    //Déclaration des views
    @BindView(R.id.goButt) Button gameButton;
    @BindView(R.id.ipRobot) EditText ipRobot;
    @BindView(R.id.RadioGroup1) RadioGroup rgSymbol;
    private RadioButton radSymbol;
    @BindView(R.id.radioGroup2) RadioGroup rgTour;
    private RadioButton radTour;

    @OnClick(R.id.goButt) public void StartPlay(){
        symbol = rgSymbol.getCheckedRadioButtonId();
        radSymbol = (RadioButton) findViewById(symbol);
        tour = rgTour.getCheckedRadioButtonId();
        radTour = (RadioButton) findViewById(tour);
        robotIP = ipRobot.getText().toString();
        //String text = radSymbol.getText().toString(); //utiliser le append du prof
        //Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();

        mancheConfigManager.MancheConfigPost(symbole_joueur, joueur_tour_1,gagnant_joueur,id_robot,id_session);

    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mancheconfig_layout);
        ButterKnife.bind(this);

        mancheConfigManager = new MancheConfigManager();
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
    public void start(MancheConfigEvent mancheConfigEvent){
        Toast.makeText(getApplicationContext(),"Configuration envoyée",Toast.LENGTH_SHORT).show();
        Intent i = new Intent(MancheConfigActivity.this,EndGameActivity.class);
        startActivity(i);
    }

    /*@Subscribe
    public void onServerEvent(MancheConfigEvent serverEvent){
        Toast.makeText(this, ""+serverEvent.getServerResponse().getMessage(), Toast.LENGTH_SHORT).show();
        if(serverEvent.getServerResponse().getUsername() != null){
            information.setText("Username: "+serverEvent.getServerResponse().getUsername() + " || Password: "+serverEvent.getServerResponse().getPassword());
        }
        extraInformation.setText("" + serverEvent.getServerResponse().getMessage());
    }

    @Subscribe
    public void onErrorEvent(ErrorCodeEvent errorEvent){
        Toast.makeText(this,""+errorEvent.getErrorCodeMessage(),Toast.LENGTH_SHORT).show();
    }*/


}