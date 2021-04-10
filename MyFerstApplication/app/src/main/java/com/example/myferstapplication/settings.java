package com.example.myferstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

import static com.example.myferstapplication.ThemeManager.THEME_1;
import static com.example.myferstapplication.ThemeManager.THEME_2;

public class settings extends AppCompatActivity
{
    settings context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThemeManager.setTheme(this);
        setContentView(R.layout.activity_main3);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        context = this;

        {
            Button item = findViewById(R.id.button);
            View.OnClickListener buttonClickListener = new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    ThemeManager.changeTo(context, ThemeManager.THEME_1);
                }
            };
            item.setOnClickListener(buttonClickListener);
        }
        {
            Button item = findViewById(R.id.button2);
            View.OnClickListener buttonClickListener = new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    ThemeManager.changeTo(context, ThemeManager.THEME_2);

                }
            };
            item.setOnClickListener(buttonClickListener);
        }



    }
}



