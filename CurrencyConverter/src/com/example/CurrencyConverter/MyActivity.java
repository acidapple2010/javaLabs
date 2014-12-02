/**
 * Разработать конвертер валют (5-10 валютных пар), прямое и обратное преобразование.
 * Царенко А.В. АП-71
 * Постановка задачи...
 * Данная задача была реализована с помощью матрицы coefficient, так как вызов элементов(коэффициентов)
 * самый удобный, потому по координатам.
 * Вводятся все значения в белый экранчик (поле ввода) EditText.
 * Выводится все в темный экранчик под кнопкой (поле вывода) TextView.
 * Реализованы 2 кнопки, которые с помощью обработчика события .setOnClickListener
 * считает и выводит результат (Button buttonDesign) и меняет spinner местами Button buttonChange.
 */

package com.example.CurrencyConverter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MyActivity extends Activity {

    public float[] coefficientUSD = {(float) 1, (float) 47.88, (float) 0.8072, (float) 0.6316, (float) 195.0875, (float) 6.1229};
    public float[] coefficientRUB = {(float) 0.0209, (float) 1, (float) 0.0169, (float) 0.0132, (float) 4.07, (float) 0.1279};
    public float[] coefficientEUR = {(float) 1.2389, (float) 59.32, (float) 1, (float) 0.7825, (float) 241.6939, (float) 7.5857};
    public float[] coefficientGBP = {(float) 1.5833, (float) 75.8043, (float) 1.278, (float) 1, (float) 308.8821, (float) 9.6944};
    public float[] coefficientKZT = {(float) 0.005126, (float) 0.2454, (float) 0.004137, (float) 0.003237, (float) 1, (float) 0.0031385};
    public float[] coefficientCNY = {(float) 0.1633, (float) 7.8194, (float) 0.1318, (float) 0.1032, (float) 31.8619, (float) 1};

    public float[][] coefficient = {coefficientUSD, coefficientRUB, coefficientEUR, coefficientGBP,coefficientKZT,coefficientCNY};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        final Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.currecy_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);

        final Button buttonChange = (Button) findViewById(R.id.buttonChange);
        buttonChange.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int s = spinner1.getSelectedItemPosition();
                spinner1.setSelection(spinner2.getSelectedItemPosition());
                spinner2.setSelection(s);
            }
        });

        final Button buttonDesign = (Button) findViewById(R.id.buttonDesign);
        buttonDesign.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText editT = (EditText) findViewById(R.id.editText);
                TextView textV = (TextView) findViewById(R.id.textView);
                textV.setText("");
                try {
                    int s1 = spinner1.getSelectedItemPosition();
                    int s2 = spinner2.getSelectedItemPosition();

                    float n;
                    n = (Float.valueOf(editT.getText().toString())) * coefficient[s1][s2];
                    textV.setText("" + n);
                }
                catch(Exception e){

                }
            }
        });
    }

    /**
     * Разобрался в построении пользовательского инитерф
     * для приложен для андроид.
     * Интерфейс приложения для конвертации валют.
     */
}
