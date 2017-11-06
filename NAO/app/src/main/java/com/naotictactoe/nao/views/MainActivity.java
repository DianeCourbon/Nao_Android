package com.naotictactoe.nao.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.naotictactoe.nao.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Cyci on 17/10/2017.
 */

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.gameButt) Button gameButton;
    @BindView(R.id.StatButt) Button statButton;
    @BindView(R.id.EtatRobot) Button etatRobotButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.mainactivity_layout);
        ButterKnife.bind(this);

        gameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MancheConfig.class);
                startActivity(i);
            }
        });
        statButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, StatistiquesJeu.class);
                startActivity(i);
            }
        });
        etatRobotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, EtatRobot.class);
                startActivity(i);
            }
        });
    }
}