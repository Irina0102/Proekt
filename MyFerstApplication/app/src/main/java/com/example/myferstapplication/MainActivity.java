package com.example.myferstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * calculytor
 */
public class MainActivity extends AppCompatActivity {

    //кнопки
    Button mbt1;
    Button mbt2;
    Button mbt3;
    Button mbt4;
    Button mbt5;
    Button mbt6;
    Button mbt7;
    Button mbt8;
    Button mbt9;
    Button mbt10;
    Button mbtplus;
    Button mbtmin;
    Button mbtumn;
    Button mbtchas;
    Button mbtrav;
    Button mbt11;
    Button mbt12;
    Button mbtproc;
    Button mbtdel;
    Button mbtc;
    TextView mtablo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbt1=findViewById(R.id.bt1);
        mbt2=findViewById(R.id.bt2);
        mbt3=findViewById(R.id.bt3);
        mbt4=findViewById(R.id.bt4);
        mbt5=findViewById(R.id.bt5);
        mbt6=findViewById(R.id.bt6);
        mbt7=findViewById(R.id.bt7);
        mbt8=findViewById(R.id.bt8);
        mbt9=findViewById(R.id.bt9);
        mbt10=findViewById(R.id.bt10);
        mbt11=findViewById(R.id.bt11);
        mbt12=findViewById(R.id.bt12);
        mbtplus=findViewById(R.id.btplus);
        mbtmin=findViewById(R.id.btmin);
        mbtchas=findViewById(R.id.btchas);
        mbtumn=findViewById(R.id.btumn);
        mbtrav=findViewById(R.id.btrav);
        mbtproc=findViewById(R.id.btproc);
        mbtdel=findViewById(R.id.btdel);
        mbtc=findViewById(R.id.btc);
        mtablo=findViewById(R.id.tablo);
        View.OnClickListener numberListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberClick(v);
            }

        };
        //подписки
        mbt1.setOnClickListener(numberListener);
        mbt2.setOnClickListener(numberListener);
        mbt3.setOnClickListener(numberListener);
        mbt4.setOnClickListener(numberListener);
        mbt5.setOnClickListener(numberListener);
        mbt6.setOnClickListener(numberListener);
        mbt7.setOnClickListener(numberListener);
        mbt8.setOnClickListener(numberListener);
        mbt9.setOnClickListener(numberListener);
        mbt10.setOnClickListener(numberListener);
               /**
         * обработка нажатия на чисовую кнопку
         * @param button - кнопка
         */
        public void onNumberClick(View button);
        {
            String number=((Button)button).getText().toString();
            String tablo=mtablo.getText().toString();
            if(tablo.equals("0"))
                tablo=number;
            else tablo+=number;
            mtablo.setText(tablo);
        }
        View.OnClickListener operatorListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorListener(v);
            }
        };
        mbtplus.setOnClickListener(operatorListener);
        mbtmin.setOnClickListener(operatorListener);
        mbtchas.setOnClickListener(operatorListener);
        mbtumn.setOnClickListener(operatorListener);

//состояние калькулятора
        float mValue=0;
        String mOperator="";
        /**
         * обрабртка нажатия на калькулятор
         * @param button - кнопка
         */
public void onOperatorListeren(View button){
    //1
            String operator=((Button)button).get.Text().toString();
            mOperator=operator;
            //2
            String tablo=mtablo.getText().toString();
            mValue=Float.parseFloat(tablo);
            //3
            mtablo.setText("0");
        }
        View.OnClickListener resultListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onResultListener(v);
            }
        };
        mrav.setOnClickListener(resultListener);
public void onResultListener(View button){
    //1
            String tablo=mtablo.getText().toString();
            float value=Float.parseFloat(tablo);
            //2
            float result=value
                    //3
            switch (mOperator)
            {
                case "+": {
                    result = value + mValue;
                    break;

                    //TODO: другие операторы
                }
            }
            //4
            DecimalFormat format=new DecimalFormat(pattern: "0.#####");
            format.setRoundingMode(RoundingMode.DOWN);
            String resultText=format.format(value);
            //5
            mtablo.setText(resultText);
            //6
            mValue=result;
            mOperator="";
        }
    }
}
