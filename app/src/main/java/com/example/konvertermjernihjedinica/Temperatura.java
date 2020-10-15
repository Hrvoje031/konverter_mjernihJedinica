package com.example.konvertermjernihjedinica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.BreakIterator;

public class Temperatura extends AppCompatActivity {
    private Button back;
    private EditText enterValue;
    private TextView resultTexT, resultView;
    Spinner spinnerFrom, spinnerTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatura);

        spinnerFrom = findViewById(R.id.spinner_IZ);
        String [] arraySpinnerFrom = new String[] {"Odaberi jedinicu", "Celsius(°C)", "Fahrenheit(°F)", "Kelvin(K)"};
        ArrayAdapter<String> lengthTemp = new ArrayAdapter<>(this, R.layout.spinner_style, arraySpinnerFrom);
        lengthTemp.setDropDownViewResource(R.layout.spinner_dropdown_style);
        spinnerFrom.setAdapter(lengthTemp);

        spinnerTo = findViewById(R.id.spinner_U);
        String [] arraySpinnerTo = new String[] {"Odaberi jedinicu", "Celsius(°C)", "Fahrenheit(°F)", "Kelvin(K)"};
        ArrayAdapter<String> lengthTo = new ArrayAdapter<>(this, R.layout.spinner_style, arraySpinnerFrom);
        lengthTemp.setDropDownViewResource(R.layout.spinner_dropdown_style);
        spinnerTo.setAdapter(lengthTemp);


        resultTexT = findViewById(R.id.textView_unesiteiznos);
        enterValue = findViewById(R.id.EditText_result);
        resultView = findViewById(R.id.resultView);

        enterValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                if (!enterValue.getText().toString().equals("-") && enterValue.getText().toString().length() != 0)
                {
                    double input = Double.parseDouble(enterValue.getText().toString());
                    Calculation();
                }


            }
        });
        AdapterView.OnItemSelectedListener selector = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Calculation();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        back = findViewById(R.id.backButton_temp);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Temperatura.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
    public void Calculation() {
        int f = spinnerFrom.getSelectedItemPosition();
        int to = spinnerTo.getSelectedItemPosition();
        double result = 0.0;

        switch (f) {
            case 1:
                if (to == 2) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = (value) / 5 * 9 + 32;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "°F");
                    }
                } else if (to == 3) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {

                        if (enterValue.getText().toString().equals("0")) {
                            double value = Double.parseDouble(enterValue.getText().toString());
                            resultView.setText("273.15 K.");
                        } else {
                            double value = Double.parseDouble(enterValue.getText().toString());
                            result = (value) * 274.15;
                            String strDouble = String.format("%.2f", result);
                            resultView.setText(strDouble + " K.");
                        }

                    }
                }
                break;
            case 2:
                if (to == 1) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = (value) - 32 * 5 / 9;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "°C");
                    }
                } else if (to == 3) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = (value) * 255.9277;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + " K.");
                    }
                }
                break;
            case 3:
                if (to == 1) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = (value) * (-272.15);
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "°C");
                    }
                } else if (to == 2) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = (value) * (-457.87);
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + " °F");
                    }
                }
                break;
        }

} }