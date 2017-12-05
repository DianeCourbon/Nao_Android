package com.naotictactoe.nao.views.view.activity;

/**
 * Created by Cyci on 04/11/2017.
 * Modified by Diane on 06/11/2017
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.naotictactoe.nao.R;
import com.naotictactoe.nao.views.manager.EndGameManager;
import com.naotictactoe.nao.views.model.EndGameModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EndGameActivity extends AppCompatActivity {

    @BindView(R.id.idResult) EditText result;
    @BindView(R.id.idNbPartiesGagnees) EditText nbMatchWon;

    //Transmettre identifiant de la partie (Cynthia
    int id_partie =0;

    @OnClick(R.id.replayButt) public void Replay(){
        Intent i = new Intent(EndGameActivity.this,MancheConfigActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.quitButt) public void BackToMain(){
        Intent i = new Intent(EndGameActivity.this,MainActivity.class);
        startActivity(i);
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.endgame_layout);
        ButterKnife.bind(this);

        /*EndGameManager endGameManager = new EndGameManager();
        EndGameModel endGameModel = endGameManager.EndGameGet(id_partie);

        //Vérifier cette méthode
        if(endGameModel==null){
            Toast.makeText(getApplicationContext(),"Problème de connexion BDD",Toast.LENGTH_SHORT).show();
        }else{
             if(endGameModel.isGagnant_joueur() == false){
                result.setText("Félicitations !");}
             else{
                 result.setText("Perdu...");}

                 //voir ac Cynthia
                 //nbMatchWon.setText(endGameModel.get);
        }*/
    }
}
