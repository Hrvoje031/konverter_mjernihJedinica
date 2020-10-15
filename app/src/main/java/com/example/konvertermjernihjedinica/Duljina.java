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

public class Duljina extends AppCompatActivity {

    private Button back;
    private EditText enterValue;
    private TextView resultTexT, resultView;
    Spinner spinnerFrom, spinnerTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duljina);
        // dodavanje komponenti u spinner objekt
        spinnerFrom = findViewById(R.id.spinner_IZ);
        String [] arraySpinnerFrom = new String[] {"Odaberi jedinicu", "Kilometar(km)", "Metar(m)", "Centimetar(cm)", "Decimetar(dm)","Milimetar(mm)", "Stopa(ft)", "Jard(yd)", "Milja(mi)", "Palac(in)" };
        ArrayAdapter<String> lengthTemp = new ArrayAdapter<>(this, R.layout.spinner_duljina, arraySpinnerFrom);
        lengthTemp.setDropDownViewResource(R.layout.spinnerdrop_duljina);
        spinnerFrom.setAdapter(lengthTemp);


        spinnerTo = findViewById(R.id.spinner_U);
        String [] arraySpinnerTo = new String[] {"Odaberi jedinicu", "Kilometar(km)", "Metar(m)", "Centimetar(cm)", "Decimetar(dm)","Milimetar(mm)", "Stopa(ft)", "Jard(yd)", "Milja(mi)", "Palac(in)"};
        ArrayAdapter<String> lengthTo = new ArrayAdapter<>(this, R.layout.spinner_duljina, arraySpinnerFrom);
        lengthTemp.setDropDownViewResource(R.layout.spinnerdrop_duljina);
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
                Intent i = new Intent(Duljina.this, MainActivity.class);
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
                        result = value * 1000;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "m.");
                    }
                } else if (to == 3) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 100000;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "cm.");
            }
                 } else if (to == 4) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 10000;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "dm.");
                    }
                } else if ( to == 5) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 10000000;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "mm.");
                    }
                } else if (to == 6) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 3280.84;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "ft.");
                    }
                } else if (to == 7) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 1093.61;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "yd.");
                    }
                } else if (to == 8) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.62;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "mi.");
                    }
                } else if (to == 9) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 39370.0787;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "in.");
                    }
                }
                break;
            case 2:
                if (to == 1) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.001;
                        String strDouble = String.format("%.3f", result);
                        resultView.setText(strDouble + "km.");
                    }
                } else if (to == 3) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 100;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "cm.");
                    }
                } else if (to == 4) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 10;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "dm.");
                    }
                } else if (to == 5) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 1000;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "mm.");
                    }
                } else if ( to == 6) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.032808;
                        String strDouble = String.format("%.6f", result);
                        resultView.setText(strDouble + "ft.");
                    }
                } else if (to == 7) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value *0.011;
                        String strDouble = String.format("%.3f", result);
                        resultView.setText(strDouble + "yd.");
                    }
                } else if (to == 8) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.000000621;
                        String strDouble = String.format("%.9f", result);
                        resultView.setText(strDouble + "cm.");
                    }
                } else if (to == 9) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.39;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "in.");
                    }
                }
                break;
            case 3:
                if (to == 1) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.000001;
                        String strDouble = String.format("%.6f", result);
                        resultView.setText(strDouble + "km.");
                    }
                } else if (to == 2) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.01;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "mm.");
                    }
                } else if (to == 4) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.1;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "dm.");
                    }
                } else if (to == 5) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 10;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "cm.");
                    }
                } else if (to == 6) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.033;
                        String strDouble = String.format("%.3f", result);
                        resultView.setText(strDouble + "ft.");
                    }
                } else if (to == 7) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.01;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "yd.");
                    }
                } else if (to == 8) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.00000062;
                        String strDouble = String.format("%.8f", result);
                        resultView.setText(strDouble + "mi.");
                    }
                } else if (to == 9) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.39;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "in.");
                    }
                }
                break;
            case 4:
                if (to == 1) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.001;
                        String strDouble = String.format("%.3f", result);
                        resultView.setText(strDouble + "km.");
                    }
                } else if (to == 2) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.1;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "m.");
                    }
                } else if (to == 3) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 10;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "cm.");
                    }
                } else if (to == 5) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 100;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "mm.");
                    }
                } else if (to == 6) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.32808399;
                        String strDouble = String.format("%.8f", result);
                        resultView.setText(strDouble + "ft.");
                    }
                }  else if (to == 7) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.1094;
                        String strDouble = String.format("%.4f", result);
                        resultView.setText(strDouble + "yd.");
                    }
                }  else if (to == 8) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.000006213;
                        String strDouble = String.format("%.9f", result);
                        resultView.setText(strDouble + "mi.");
                    }
                }  else if (to == 9) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 3.937;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "in.");
                    }
                }
                break;
            case 5:
                if (to == 1) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.0000001;
                        String strDouble = String.format("%.7f", result);
                        resultView.setText(strDouble + "km.");
                    }
                } else if (to == 2) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.001;
                        String strDouble = String.format("%.3f", result);
                        resultView.setText(strDouble + "m.");
                    }
                } else if (to == 3) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.1;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "cm.");
                    }
                } else if (to == 4) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.01;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "dm.");
                    }
                } else if (to == 6) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.00328;
                        String strDouble = String.format("%.5f", result);
                        resultView.setText(strDouble + "ft.");
                    }
                } else if (to == 7) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.0010936;
                        String strDouble = String.format("%.7f", result);
                        resultView.setText(strDouble + "yd.");
                    }
                } else if (to == 8) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.000000062;
                        String strDouble = String.format("%.9f", result);
                        resultView.setText(strDouble + "mi.");
                    }
                } else if (to == 9) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.0394;
                        String strDouble = String.format("%.4f", result);
                        resultView.setText(strDouble + "in.");
                    }
                }
                break;
            case 6:
                if (to == 1) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.0003048;
                        String strDouble = String.format("%.7f", result);
                        resultView.setText(strDouble + "km.");
                    }
                }
                else if (to == 2) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.3048;
                        String strDouble = String.format("%.4f", result);
                        resultView.setText(strDouble + "m.");
                    }
                } else if (to == 3) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 30.48;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "cm.");
                    }
                } else if (to == 4) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 3.05;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "dm.");
                    }
                } else if (to == 5) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 304.5;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "mm.");
                    }
                } else if (to == 7) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.0333333;
                        String strDouble = String.format("%.7f", result);
                        resultView.setText(strDouble + "yd.");
                    }
                } else if (to == 8) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.000189;
                        String strDouble = String.format("%.6f", result);
                        resultView.setText(strDouble + "mi.");
                    }
                } else if (to == 9) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 12;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "in.");
                    }
                }
                break;
            case 7:
                if (to == 1) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.0009144;
                        String strDouble = String.format("%.7f", result);
                        resultView.setText(strDouble + "km.");
                    }
                } else if (to == 2) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.9144;
                        String strDouble = String.format("%.4f", result);
                        resultView.setText(strDouble + "m.");
                    }
                } else if (to == 3) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 91.44;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "cm.");
                    }
                }
                else if (to == 4) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 9.144;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "dm.");
                    }
                } else if (to == 5) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 914.4;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "mm.");
                    }
                } else if (to == 6) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 3;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "ft.");
                    }
                } else if (to == 8) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.000568;
                        String strDouble = String.format("%.6f", result);
                        resultView.setText(strDouble + "mi.");
                    }
                } else if (to == 9) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 36;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "in.");
                    }
                }
                break;
            case 8:
                if (to == 1) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 1.609344;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "km.");
                    }
                } else if (to == 2) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 1609.344;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "m.");
                    }
                } else if (to == 3) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 160934.4;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "cm.");
                    }
                } else if (to == 4) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 16093.44;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "dm.");
                    }
                } else if (to == 5) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 1609344;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "mm.");
                    }
                } else if (to == 6) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 5280;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "ft.");
                    }
                } else if (to == 7) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 1760;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "yd.");
                    }
                } else if (to == 9) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 63360;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "in.");
                    }
                }
                break;
            case 9:
                if (to == 1) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.0000254;
                        String strDouble = String.format("%.7f", result);
                        resultView.setText(strDouble + "km.");
                    }
                }  else if (to == 2) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.0254;
                        String strDouble = String.format("%.4f", result);
                        resultView.setText(strDouble + "m.");
                    }
                }  else if (to == 3) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 2.54;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "cm.");
                    }
                } else if (to == 4) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.254;
                        String strDouble = String.format("%.3f", result);
                        resultView.setText(strDouble + "dm.");
                    }
                }  else if (to == 5) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 25.4;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "mm.");
                    }
                }  else if (to == 6) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.083333;
                        String strDouble = String.format("%.6f", result);
                        resultView.setText(strDouble + "ft.");
                    }
                }  else if (to == 7) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.2777;
                        String strDouble = String.format("%.4f", result);
                        resultView.setText(strDouble + "yd.");
                    }
                } else if (to == 8) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.00000158;
                        String strDouble = String.format("%.8f", result);
                        resultView.setText(strDouble + "mi.");
                    }
                }
                break;

        }
} }