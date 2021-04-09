package com.example.myferstapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.MenuItem;
import android.content.ClipData;
import android.content.ClipboardManager;

import androidx.appcompat.app.AppCompatActivity;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import static android.content.ClipDescription.MIMETYPE_TEXT_PLAIN;

/**
 * calculytor
 */
public class MainActivity extends AppCompatActivity
{   //кнопки
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
    Button mbtznak;
    Button mbttoch;
    Button mbtdel;
    Button mbtcl;
    TextView mtablo;

    //состояние калькулятора
    float mValue = 0;
    String mOperator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThemeManager.setTheme(this);
        setContentView(R.layout.activity_main);
        mbt1 = findViewById(R.id.bt1);
        mbt2 = findViewById(R.id.bt2);
        mbt3 = findViewById(R.id.bt3);
        mbt4 = findViewById(R.id.bt4);
        mbt5 = findViewById(R.id.bt5);
        mbt6 = findViewById(R.id.bt6);
        mbt7 = findViewById(R.id.bt7);
        mbt8 = findViewById(R.id.bt8);
        mbt9 = findViewById(R.id.bt9);
        mbt10 = findViewById(R.id.bt10);
        mbtznak = findViewById(R.id.btznak);
        mbttoch = findViewById(R.id.bttoch);
        mbtplus = findViewById(R.id.btplus);
        mbtmin = findViewById(R.id.btmin);
        mbtchas = findViewById(R.id.btchas);
        mbtumn = findViewById(R.id.btumn);
        mbtrav = findViewById(R.id.btrav);
        mbtdel = findViewById(R.id.btdel);
        mbtcl = findViewById(R.id.btcl);
        mtablo = findViewById(R.id.tablo);

        View.OnClickListener numberListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberClick(v);
            }

            public void onNumberClick(View button) {
                String number = ((Button) button).getText().toString();
                String tablo = mtablo.getText().toString();
                if (tablo.equals("0"))
                    tablo = number;
                else tablo += number;
                mtablo.setText(tablo);
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


        View.OnClickListener operatorListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorClick(v);
            }

            public void onOperatorClick(View button) {
                //1
                String operator = ((Button) button).getText().toString();
                mOperator = operator;
                //2
                String tablo = mtablo.getText().toString();
                mValue = Float.parseFloat(tablo);
                //3
                mtablo.setText("0");
            }
        };
        mbtplus.setOnClickListener(operatorListener);
        mbtmin.setOnClickListener(operatorListener);
        mbtchas.setOnClickListener(operatorListener);
        mbtumn.setOnClickListener(operatorListener);

        View.OnClickListener resultListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onResultListener(v);
            }

            public void onResultListener(View button) {
                //1
                String tablo = mtablo.getText().toString();
                //2
                float value = Float.parseFloat(tablo);
                float result = value;
                boolean a = false;
                //3
                switch (mOperator)
                // сложение
                {
                    case "+": {
                        result = value + mValue;
                        break;
                    }
                    //вычитание
                    case "-":
                    {
                        result = value - mValue;
                        break;
                    }
                    //умножение
                    case "*":
                    {
                        result = value * mValue;
                        break;
                    }
                    //деление
                    case "/":
                     {
                        if (value == 0) {
                            a = true;
                        } else {
                            a = false;
                            result = value / mValue;
                        }
                        break;
                    }
                }
                ;
                //4
                DecimalFormat format = new DecimalFormat("0.#####");
                format.setRoundingMode(RoundingMode.DOWN);
                String resultText = format.format(value);
                //5
                mtablo.setText(resultText);
                //6
                mValue = result;
                mOperator = "";
            }
        };
        mbtrav.setOnClickListener(resultListener);
        //кнопка с "."
        View.OnClickListener tochListener= new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                onTochListener(v);
            }

            public void onTochListener(View button) {
                String text = mtablo.getText().toString();
                String tablo = text + ".";
                mtablo.setText(tablo);
            }
        };
              mbttoch.setOnClickListener(tochListener);
// кнопка удаления знака
        View.OnClickListener delListener= new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                onDelListener(v);
            }

            public void onDelListener(View button) {
                String text = mtablo.getText().toString();
                if(text.length()>1)
                {
                    text = text.substring(0, text.length() - 1);
                    mtablo.setText(text);
                }
                else if (text.length()<=1)
                 {
                    mtablo.setText("0");
                 }
            }
        };
        mbtdel.setOnClickListener(delListener);
// кнопка очистки экрана
        View.OnClickListener clListener= new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                onClListener(v);
            }

            public void onClListener(View button) {
                mValue=0;
                mOperator="";
                mtablo.setText("0");
            }
        };
        mbtcl.setOnClickListener(clListener);

    }
    /**
     * создание меню
     * @param menu - объект меню
     * @return успешность обработки
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {  getMenuInflater().inflate(R.menu.menu,menu);
       return true;
    }
    /**
     * обработка нажатий на меню
     * @param item - элемент меню
     * @return успешность обработки
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {//обработка вариантов значений
        switch (item.getItemId())
        {// Нажатие на кнопку "Настройки"
            case R.id.action_settings:
                startSettings();
                return true;
                //Нажаите на окно "О калькуляторе"
            case R.id.about:
                about();
                return true;
                //Нажатие на окно "Копировать"
            case R.id.copy:
                copy();
                return true;
                //Нажатие на окно "Вставить"
            case R.id.paste:
                paste();
                return true;
                //Неизвестное значение обрабатывается родителем
            default:
            return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Скопировать текст с дисплея в буфер обмена
     */
    private void copy() {// получаем менеджера
        ClipboardManager clipboard = (ClipboardManager)
                getSystemService(Context.CLIPBOARD_SERVICE);
        // убедимся что менеджер доступен
        if (clipboard != null) {//создаем вырезанные данные из текста
            ClipData clip = ClipData.newPlainText("", mtablo.getText());
            //устанавливаем данные в буфер обмена
            clipboard.setPrimaryClip(clip);
        }
    }
    /**
     * проверка строки на число
     * @param text - текст на проверку
     * @return успешность проверки
     */
    public static boolean isNumberic(String text)
    {//если текст пустой то провал
        if (text == null)
            return false;
        //попробуем сделатьь конвертацию
        try {//метод  бросает исключение
            Double.parseDouble(text);
        }
        //ловим исключение
        catch (NumberFormatException e)
        {//конвертацця не удалась
            return false;
        }
        //конвертация удалась
        return true;
    }

    private void paste()
    {//получаем менеджера
        ClipboardManager clipboard=(ClipboardManager)
                getSystemService(Context.CLIPBOARD_SERVICE);
        // убедимся что менеджер доступен
        if(clipboard!=null) {//проверим что в буфере есть текст
            if (clipboard.hasPrimaryClip()
                    && clipboard.getPrimaryClipDescription().hasMimeType(MIMETYPE_TEXT_PLAIN))
            {//получим данные
                ClipData.Item item = clipboard.getPrimaryClip().getItemAt(0);
                //преобразуем данные в строке
                String pasteData = item.getText().toString();
                //проверим является ли наша строка числом
                //и толлько тогда установим на экран
                if (isNumberic(pasteData))
                    mtablo.setText(pasteData);
            }
        }
    }

    private void about()
    {//создаем намерение на вызов экрана About
        Intent activityIntent=new Intent(getApplicationContext(), about.class);
        //запускаем экран
        startActivity(activityIntent);
    }

    private void startSettings()
    {//создаем намерение на вызов экрана Settings
        Intent activityIntent=new Intent(getApplicationContext(), settings.class);
        //запускаем экран
        startActivity(activityIntent);
    }
}


