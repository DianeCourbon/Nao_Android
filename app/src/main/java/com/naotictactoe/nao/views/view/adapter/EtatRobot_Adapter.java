package com.naotictactoe.nao.views.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.naotictactoe.nao.R;

import java.util.ArrayList;

/**
 * Created by Cyci on 05/11/2017.
 */

public class EtatRobot_Adapter extends BaseAdapter implements AdapterView.OnItemClickListener {

    ArrayList<Motor_Object> myList = new ArrayList<>();
    Context context;

    // on passe le context afin d'obtenir un LayoutInflater pour utiliser row_layout.xml, j'ai créé one_contact.xml
    // on passe les valeurs de notre  l'adapter
    public EtatRobot_Adapter(Context context, ArrayList<Motor_Object> myList) {
        this.myList = myList;
        this.context = context;
    }

    // retourne le nombre d'objet present dans notre liste
    @Override
    public int getCount() {
        return myList.size();
    }

    // retourne un elem de notre liste en fonction de sa position
    @Override
    public Motor_Object getItem(int position) {
        return myList.get(position);
    }

    // retourne l'id d'un Ã©lÃ©ment de notre liste en fonction de sa position
    @Override
    public long getItemId(int position) {
        return myList.indexOf(getItem(position));
    }

    // retourne la vue d'un Ã©lÃ©ment de la liste
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder mViewHolder = null;

        // premier coup ConvertView est null, on inflate notre layout
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            convertView = mInflater.inflate(R.layout.etatrobot_list, parent, false);

            // on place dans MyViewHolder les vues de notre layout
            mViewHolder = new MyViewHolder();
            //mViewHolder.textViewName = (TextView) convertView.findViewById(R.id.nom);
            mViewHolder.idMoteur = (EditText) convertView.findViewById(R.id.idmoteur);
            mViewHolder.idPosition = (EditText) convertView.findViewById(R.id.idposition);
            mViewHolder.idTemperature = (EditText) convertView.findViewById(R.id.idtemperature);
            mViewHolder.idEtat = (Button) convertView.findViewById(R.id.idetat);

            // on donne le tag MyViewHolder Ã  convertView
            convertView.setTag(mViewHolder);
        } else {
            // non null, on recupere notre objet MyViewHolder
            mViewHolder = (MyViewHolder) convertView.getTag();
        }

        // on recupere l'item de la liste demandÃ© par getView
        Motor_Object listItem = (Motor_Object) getItem(position);

        // on attribu les valeurs de l'Ã©lÃ©ment de la liste
        //mViewHolder.textViewName.setText(listItem.getName());
        mViewHolder.idMoteur.setText(Integer.toString(listItem.getNumeroMoteur()));
        mViewHolder.idPosition.setText(Double.toString(listItem.getPositionMoteur()));
        mViewHolder.idTemperature.setText(Double.toString(listItem.getTemperatureMoteur()));
        if(listItem.getEtatRobot()){
            mViewHolder.idEtat.setBackgroundColor(Color.GREEN);
        } else {
            mViewHolder.idEtat.setBackgroundColor(Color.RED);
        }


        // nous retournos la vue de l'item demandÃ©
        return convertView;
    }

    // MyViewHolder va nous permettre de ne pas devoir rechercher
    // les vues Ã  chaque appel de getView, nous gagnons ainsi en performance
    private class MyViewHolder {
        EditText idMoteur, idPosition, idTemperature;
        Button idEtat;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

}
