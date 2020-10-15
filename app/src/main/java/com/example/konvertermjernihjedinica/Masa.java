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

public class Masa extends AppCompatActivity {

    private Button back;
    private EditText enterValue;
    private TextView resultTexT, resultView;
    Spinner spinnerFrom, spinnerTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masa);
        // dodavanje komponenti u spinner objekt
        spinnerFrom = findViewById(R.id.spinner_IZ);
        String [] arraySpinnerFrom = new String[] {"Odaberi jedinicu", "Kilogram(kg)", "Gram(g)", "Miligram(mg)", "Unca(oc)","Pound(lb)"};
        ArrayAdapter<String> lengthTemp = new ArrayAdapter<>(this, R.layout.spinner_masa, arraySpinnerFrom);
        lengthTemp.setDropDownViewResource(R.layout.spinner_drop_masa);
        spinnerFrom.setAdapter(lengthTemp);


        spinnerTo = findViewById(R.id.spinner_U);
        String [] arraySpinnerTo = new String[] {"Odaberi jedinicu", "Kilogram(kg)", "Gram(g)", "Miligram(mg)", "Unca(oc)","Pound(lb)"};
        ArrayAdapter<String> lengthTo = new ArrayAdapter<>(this,  R.layout.spinner_masa, arraySpinnerFrom);
        lengthTemp.setDropDownViewResource(R.layout.spinner_drop_masa);
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
                Intent i = new Intent(Masa.this, MainActivity.class);
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
                        resultView.setText(strDouble + " g.");
                    }
                } else if (to == 3) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 1000000;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + " mg.");
                    }
                } else if (to == 4) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 35.274;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + " oz.");
                    }
                } else if ( to == 5) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 2.2046;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + "lb.");
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
                        resultView.setText(strDouble + " kg.");
                    }
                } else if (to == 3) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 1000;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + " mg.");
                    }
                } else if (to == 4) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.0353;
                        String strDouble = String.format("%.4f", result);
                        resultView.setText(strDouble + " oz.");
                    }
                } else if (to == 5) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.00220;
                        String strDouble = String.format("%.5f", result);
                        resultView.setText(strDouble + " lb.");
                    }
                }
                break;
            case 3:
                if (to == 1) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.0000001;
                        String strDouble = String.format("%.7f", result);
                        resultView.setText(strDouble + " kg.");
                    }
                } else if (to == 2) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.001;
                        String strDouble = String.format("%.3f", result);
                        resultView.setText(strDouble + " g.");
                    }
                } else if (to == 4) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.00000353;
                        String strDouble = String.format("%.8f", result);
                        resultView.setText(strDouble + " oz.");
                    }
                } else if (to == 5) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.0000002205;
                        String strDouble = String.format("%.10f", result);
                        resultView.setText(strDouble + " lb.");
                    }
                }
                break;
            case 4:
                if (to == 1) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.02835;
                        String strDouble = String.format("%.5f", result);
                        resultView.setText(strDouble + " kg.");
                    }
                } else if (to == 2) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 28.35;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + " g.");
                    }
                } else if (to == 3) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 28349.52;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + " mg.");
                    }
                } else if (to == 5) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.0625;
                        String strDouble = String.format("%.4f", result);
                        resultView.setText(strDouble + " lb.");
                    }
                }
                break;
            case 5:
                if (to == 1) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.4536;
                        String strDouble = String.format("%.4f", result);
                        resultView.setText(strDouble + " kg.");
                    }
                } else if (to == 2) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 453.592;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + " g.");
                    }
                } else if (to == 3) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 453592.37;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + " mg.");
                    }
                } else if (to == 4) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 16;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + " oz.");
                    }
                }
                break;
        }
    }
}