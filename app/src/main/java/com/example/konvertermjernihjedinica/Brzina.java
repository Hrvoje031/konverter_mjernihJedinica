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

public class Brzina extends AppCompatActivity {

    private Button back;
    private EditText enterValue;
    private TextView resultTexT, resultView;
    Spinner spinnerFrom, spinnerTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brzina);
        // dodavanje komponenti u spinner objekt
        spinnerFrom = findViewById(R.id.spinner_IZ);
        String [] arraySpinnerFrom = new String[] {"Odaberi jedinicu", "Kilometar po satu", "Kilometar po sekundi", "Metar po sekundi", "Milja po satu", "Mach"};
        ArrayAdapter<String> lengthTemp = new ArrayAdapter<>(this, R.layout.brzina_spinner, arraySpinnerFrom);
        lengthTemp.setDropDownViewResource(R.layout.spinner_drop_brzina);
        spinnerFrom.setAdapter(lengthTemp);


        spinnerTo = findViewById(R.id.spinner_U);
        String [] arraySpinnerTo = new String[] {"Odaberi jedinicu", "Kilometar po satu", "Kilometar po sekundi", "Metar po sekundi", "Milja po satu", "Mach"};
        ArrayAdapter<String> lengthTo = new ArrayAdapter<>(this,  R.layout.brzina_spinner, arraySpinnerFrom);
        lengthTemp.setDropDownViewResource(R.layout.spinner_drop_brzina);
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
            public void afterTextChanged(Editable s) {
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
                Intent i = new Intent(Brzina.this, MainActivity.class);
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
                        result = value * 0.00028;
                        String strDouble = String.format("%.5f", result);
                        resultView.setText(strDouble + " km/s.");
                    }
                } else if (to == 3) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.2778;
                        String strDouble = String.format("%.5f", result);
                        resultView.setText(strDouble + " m/s.");
                    }
                } else if (to == 4) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.62134;
                        String strDouble = String.format("%.5f", result);
                        resultView.setText(strDouble + " milja/h.");
                    }
                } else if (to == 5) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.00084;
                        String strDouble = String.format("%.5f", result);
                        resultView.setText(strDouble + " mach.");
                    }
                }
                break;
            case 2:
                if (to == 1) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 3600;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + " km/h.");
                    }
                } else if (to == 3) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 1000;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + " m/s");
                    }
                } else if (to == 4) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {

                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 2236.94;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + " milja/h.");
                    }
                } else if (to == 5) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {

                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 3.01695;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + " mach.");
                    }
                }
                break;
            case 3:
                if (to == 1) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 3.6;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + " km/h.");
                    }
                } else if (to == 2) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.001;
                        String strDouble = String.format("%.3f", result);
                        resultView.setText(strDouble + " km/s.");
                    }
                } else if (to == 4) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 2.23694;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + " milja/h.");
                    }
                } else if (to == 5) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.00302;
                        String strDouble = String.format("%.5f", result);
                        resultView.setText(strDouble + " mach.");
                    }
                }
                break;
            case 4:
                if (to == 1) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 1.609;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + " km/h.");
                    }
                } else if (to == 2) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.000447;
                        String strDouble = String.format("%.6f", result);
                        resultView.setText(strDouble + " km/s.");
                    }
                } else if (to == 3) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.447;
                        String strDouble = String.format("%.3f", result);
                        resultView.setText(strDouble + " m/s.");
                    }
                } else if (to == 5) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.001349;
                        String strDouble = String.format("%.6f", result);
                        resultView.setText(strDouble + " mach.");
                    }
                }
                break;
            case 5:
                if (to == 1) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 1193.258;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + " km/h.");
                    }

        } else if (to == 2) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.33146;
                        String strDouble = String.format("%.5f", result);
                        resultView.setText(strDouble + " mach.");
                    }
                } else if (to == 3) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 331.461;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + " m/s.");
                    }
                } else if (to == 4) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 741.46;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + " milja/h.");
                    }
                }
                break;
    }
} }