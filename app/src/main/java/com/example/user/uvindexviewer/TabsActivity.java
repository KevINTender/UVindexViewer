package com.example.user.uvindexviewer;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;

public class TabsActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SetStyle();

        final TabHost tabHost = getTabHost();
        TabHost.TabSpec spec;  // Resusable TabSpec for each tab
        Intent intent;
        final Button forecastButton = (Button) findViewById(R.id.forecastTab);
        final Button homeButton = (Button) findViewById(R.id.homeTab);
        final Button tanButton = (Button) findViewById(R.id.tanTab);
        final Button settingsButton = (Button) findViewById(R.id.settingTab);

        intent = new Intent().setClass(TabsActivity.this, HomeActivity.class);
        spec = tabHost.newTabSpec("home").setIndicator("Home").setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(TabsActivity.this, ForecastActivity.class);
        spec = tabHost.newTabSpec("forecast").setIndicator("Forecast").setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(TabsActivity.this, TanActivity.class);
        spec = tabHost.newTabSpec("tan").setIndicator("Tan").setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(TabsActivity.this, SettingsActivity.class);
        spec = tabHost.newTabSpec("settings").setIndicator("Settings").setContent(intent);
        tabHost.addTab(spec);
        homeButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {
                homeButton.setTextColor(getResources().getColor(R.color.homeColor));
                forecastButton.setTextColor(getResources().getColor(R.color.textdefault));
                tanButton.setTextColor(getResources().getColor(R.color.textdefault));
                settingsButton.setTextColor(getResources().getColor(R.color.textdefault));
                tabHost.setCurrentTab(0);
            }

        });
        forecastButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {
                homeButton.setTextColor(getResources().getColor(R.color.textdefault));
                forecastButton.setTextColor(getResources().getColor(R.color.forecastColor));
                tanButton.setTextColor(getResources().getColor(R.color.textdefault));
                settingsButton.setTextColor(getResources().getColor(R.color.textdefault));
                tabHost.setCurrentTab(1);
            }

        });
        tanButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {
                homeButton.setTextColor(getResources().getColor(R.color.textdefault));
                forecastButton.setTextColor(getResources().getColor(R.color.textdefault));
                tanButton.setTextColor(getResources().getColor(R.color.tanColor));
                settingsButton.setTextColor(getResources().getColor(R.color.textdefault));
                tabHost.setCurrentTab(2);
            }

        });
        settingsButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {
                homeButton.setTextColor(getResources().getColor(R.color.textdefault));
                forecastButton.setTextColor(getResources().getColor(R.color.textdefault));
                tanButton.setTextColor(getResources().getColor(R.color.textdefault));
                settingsButton.setTextColor(getResources().getColor(R.color.settingsColot));
                tabHost.setCurrentTab(3);
            }

        });

    }
    public  void  SetStyle()
    {
        // поиск кнопок по ид
        TextView b1 = (TextView) findViewById(R.id.homeTab);
        TextView b2 = (TextView) findViewById(R.id.forecastTab);
        TextView b3 = (TextView) findViewById(R.id.tanTab);
        TextView b4 = (TextView) findViewById(R.id.settingTab);

        // задание отображения
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/solid.ttf");
        b1.setTypeface(typeFace);
        b2.setTypeface(typeFace);
        b3.setTypeface(typeFace);
        b4.setTypeface(typeFace);


        b1.setText("\uF015");
        b2.setText("\uF080");
        b3.setText("\uF185");
        b4.setText("\uF7D9");
    }
}
