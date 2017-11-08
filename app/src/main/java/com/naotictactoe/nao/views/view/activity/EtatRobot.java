package com.naotictactoe.nao.views.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.naotictactoe.nao.R;

import java.util.ArrayList;

import com.naotictactoe.nao.views.view.adapter.EtatRobot_Adapter;
import com.naotictactoe.nao.views.view.adapter.Motor_Object;
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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.etatrobot_layout);
        ButterKnife.bind(this);

        getBatterie.setText("6%");

        moteurList = new ArrayList<>();
        moteurList.add(new Motor_Object(1,true, 13.4, 25.4));
        moteurList.add(new Motor_Object(2, false,14.6,40.8));

        etatRobotAdapter = new EtatRobot_Adapter(getApplicationContext(),moteurList);
        listMotorState.setAdapter(etatRobotAdapter);
    }
}
