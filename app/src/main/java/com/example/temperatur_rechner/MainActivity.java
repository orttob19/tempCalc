package com.example.temperatur_rechner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edCelsius;
    private TextView tvTempFahrenheit;
    private TextView tvTempKelvin;
    private float resultKelvin;
    private float resultFahrenheit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTempFahrenheit = (TextView) findViewById(R.id.tvTempFahrenheit);
        tvTempKelvin = (TextView) findViewById(R.id.tvTempKelvin);
        edCelsius = (EditText) findViewById(R.id.edCelsius);

        edCelsius.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                resultKelvin = ctoK(Float.parseFloat(edCelsius.getText().toString()));
                resultFahrenheit = ctoF(Float.parseFloat(edCelsius.getText().toString()));

                tvTempFahrenheit.setText(String.format("%.2f Fahrenheit", resultFahrenheit));
                tvTempKelvin.setText(String.format("%.2f Kelvin", resultKelvin));
            }
        });
    }

    public float ctoK(float temp){
        float kelvin = temp + 273.15f;
        return kelvin;
    }

    public float ctoF(float temp){
        float fahrenheit = (temp * 9/5) + 32;
        return fahrenheit;
    }
}