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

public class Volumen extends AppCompatActivity {

    private Button back;
    private EditText enterValue;
    private TextView resultTexT, resultView;
    Spinner spinnerFrom, spinnerTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumen);
        // dodavanje komponenti u spinner objekt
        spinnerFrom = findViewById(R.id.spinner_IZ);
        String [] arraySpinnerFrom = new String[] {"Odaberi jedinicu", "Litra(l)", "Centilitar(cl)", "Mililitar(mg)", "Kubični metar","Kubični centimetar", "Decilitar(dcl)"};
        ArrayAdapter<String> lengthTemp = new ArrayAdapter<>(this, R.layout.spinnervolumen, arraySpinnerFrom);
        lengthTemp.setDropDownViewResource(R.layout.spinnervolumen_drop);
        spinnerFrom.setAdapter(lengthTemp);


        spinnerTo = findViewById(R.id.spinner_U);
        String [] arraySpinnerTo = new String[] {"Odaberi jedinicu", "Litra(l)", "Centilitar(cl)", "Mililitar(mg)", "Kubični metar","Kubični centimetar", "Decilitar(dcl)"};
        ArrayAdapter<String> lengthTo = new ArrayAdapter<>(this,  R.layout.spinnervolumen, arraySpinnerFrom);
        lengthTemp.setDropDownViewResource(R.layout.spinnervolumen_drop);
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
                Intent i = new Intent(Volumen.this, MainActivity.class);
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
                        result = value * 100;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + " cl.");
                    }
                } else if (to == 3) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 1000;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + " ml.");
                    }
                } else if (to == 4) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.001;
                        String strDouble = String.format("%.3f", result);
                        resultView.setText(strDouble + " kub.m.");
                    }
                } else if ( to == 5) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 1000;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + " kub.cm.");
                    }
                } else if ( to == 6) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 10;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + " dcl.");
                    }
                }
                break;
            case 2:
                if (to == 1) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.01;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + " l.");
                    }
                } else if (to == 3) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 10;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + " ml.");
                    }
                } else if (to == 4) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.0003531;
                        String strDouble = String.format("%.7f", result);
                        resultView.setText(strDouble + " kub.m..");
                    }
                } else if (to == 5) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 10;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + " kub.cm");
                    }
                } else if ( to == 6) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.10;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + " dcl.");
                    }
                }
                break;
            case 3:
                if (to == 1) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.0001;
                        String strDouble = String.format("%.4f", result);
                        resultView.setText(strDouble + " l.");
                    }
                } else if (to == 2) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.01;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + " cl.");
                    }
                } else if (to == 4) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.0000001;
                        String strDouble = String.format("%.7f", result);
                        resultView.setText(strDouble + " kub.m.");
                    }
                } else if (to == 5) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 1;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + " kub.cm");
                    }
                }else if ( to == 6) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.01;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + " dcl.");
                    }
                }
                break;
            case 4:
                if (to == 1) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 1000;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + " l.");
                    }
                } else if (to == 2) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 100000;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + " cl.");
                    }
                } else if (to == 3) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 1000000;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + " ml.");
                    }
                } else if (to == 5) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 1000000;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + " kub.cm.");
                    }
                } else if ( to == 6) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 10000;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + " dcl.");
                    }
                }
                break;
            case 5:
                if (to == 1) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.0001;
                        String strDouble = String.format("%.4f", result);
                        resultView.setText(strDouble + " l.");
                    }
                } else if (to == 2) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.10;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + " cl.");
                    }
                } else if (to == 3) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 1;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + " ml.");
                    }
                } else if (to == 4) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.0000001;
                        String strDouble = String.format("%.7f", result);
                        resultView.setText(strDouble + " kub.m..");
                    }
                } else if ( to == 6) {
                    if (enterValue.getText().toString().equals("")) {
                        resultView.setText("0");
                    } else {
                        double value = Double.parseDouble(enterValue.getText().toString());
                        result = value * 0.01;
                        String strDouble = String.format("%.2f", result);
                        resultView.setText(strDouble + " dcl.");
                    }
                }
                break;
        }
    }
}