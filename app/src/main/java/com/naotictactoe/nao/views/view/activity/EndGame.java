package com.naotictactoe.nao.views.view.activity;

/**
 * Created by Cyci on 04/11/2017.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.naotictactoe.nao.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EndGame extends AppCompatActivity {

    @BindView(R.id.idResult) EditText result;
    @BindView(R.id.idNbPartiesGagnees) EditText nbMatchWon;

    @OnClick(R.id.replayButt) public void Replay(){
        Intent i = new Intent(EndGame.this,MancheConfig.class);
        startActivity(i);
    }

    @OnClick(R.id.quitButt) public void BackToMain(){
        Intent i = new Intent(EndGame.this,MainActivity.class);
        startActivity(i);
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.endgame_layout);
        ButterKnife.bind(this);

        result.setText("Vous avez perdu !! ou gagner... c'est pas encore codé");
        nbMatchWon.setText("13");
    }
}
