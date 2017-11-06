package com.naotictactoe.nao.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.CompoundButton;

import com.naotictactoe.nao.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Cyci on 04/11/2017.
 */

public class MancheConfig extends AppCompatActivity {
    private int symbol;
    private int tour;
    private String robotIP;

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

        String text = radSymbol.getText().toString(); //utiliser le append du prof
        Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();

        Intent i = new Intent(MancheConfig.this,EndGame.class);
        startActivity(i);

    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mancheconfig_layout);
        ButterKnife.bind(this);

    }
}