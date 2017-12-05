package com.naotictactoe.nao.views.view.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.naotictactoe.nao.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

import butterknife.ButterKnife;

/**
 * Created by Cyci on 17/10/2017.
 */

public class StatistiquesJeu extends AppCompatActivity {
    PieChart mChart;
    PieChart mChart2;
    // Ajouter les valeurs dans la pie chart dans les crochers.
    // un tableau avec dans l'ordre : parties perdues, gagnées et nulles
    private int[] yValues = {21, 2, 2}; //sur la partie en cours
    private String[] xValues = {"Parties perdues", "Parties gagnées", "Parties nulles"};
    private int[] yValues2 = {10, 5, 2}; //global sur toutes les parties
    private String[] xValues2 = {"Parties perdues", "Parties gagnées", "Parties nulles"};

    // colors for different sections in pieChart
    public static  final int[] MY_COLORS = {
            Color.rgb(45,196,225), Color.rgb(53,91,183), Color.rgb(225,0,0)
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.statistiquesjeu_mayout);
        ButterKnife.bind(this);

        mChart = (PieChart) findViewById(R.id.chart1);
        mChart2 = (PieChart) findViewById(R.id.chart2);

        mChart.getDescription().setEnabled(false);
        mChart2.getDescription().setEnabled(false);

        mChart.setRotationEnabled(true);
        mChart2.setRotationEnabled(true);

        mChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {

            @Override
            public void onValueSelected(Entry e, Highlight h) {
                if (e == null)
                    return;

                Toast.makeText(getApplicationContext(), xValues[(int)e.getData()] + "", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected() {

            }

        });
        mChart2.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {

            @Override
            public void onValueSelected(Entry e, Highlight h) {
                if (e == null)
                    return;

                Toast.makeText(getApplicationContext(), xValues2[(int)e.getData()] + "", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected() {

            }

        });
            // setting sample Data for Pie Chart
        setDataForPieChart(mChart, yValues, xValues);
        setDataForPieChart(mChart2, yValues2, xValues2);
    }
    public void setDataForPieChart(PieChart mChart, int[] yValues, String[] xValues) {
        ArrayList<PieEntry> entries = new ArrayList<PieEntry>();

        for (int i = 0; i < yValues.length; i++)
            entries.add(new PieEntry(yValues[i], i));

        ArrayList<String> xVals = new ArrayList<String>();

        for (int i = 0; i < xValues.length; i++)
            xVals.add(xValues[i]);

        // create pieDataSet
        PieDataSet dataSet = new PieDataSet(entries,"");
        dataSet.setSliceSpace(3);
        dataSet.setSelectionShift(5);

        // adding colors
        ArrayList<Integer> colors = new ArrayList<Integer>();

        // Added My Own colors
        for (int c : MY_COLORS)
            colors.add(c);


        dataSet.setColors(colors);

        //  create pie data object and set xValues and yValues and set it to the pieChart
        PieData data = new PieData(dataSet);

        data.setValueFormatter(new MyValueFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);

        mChart.setData(data);

        // undo all highlights
        mChart.highlightValues(null);

        // refresh/update pie chart
        mChart.invalidate();

        // animate piechart
        mChart.animateXY(1400, 1400);

        // Legends to show on bottom of the graph
        Legend l = mChart.getLegend();
        l.setPosition(Legend.LegendPosition.BELOW_CHART_CENTER);
        l.setXEntrySpace(7);
        l.setYEntrySpace(5);
    }


    public class MyValueFormatter implements IValueFormatter {

        private DecimalFormat mFormat;

        public MyValueFormatter() {
            mFormat = new DecimalFormat("###,###,##0"); // use one decimal if needed
        }

        @Override
        public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
            // write your logic here
            return mFormat.format(value) + ""; // e.g. append a dollar-sign
        }
    }

}
