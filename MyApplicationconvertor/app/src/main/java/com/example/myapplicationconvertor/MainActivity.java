package com.example.myapplicationconvertor;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etFah,etCel;
    Button btnConvert,btnClear;
RadioGroup rg;
RadioButton rbCtf, rbFtC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etFah= findViewById(R.id.temF);
        etCel= findViewById(R.id.temCelsius);
        btnConvert=findViewById(R.id.convert);
        btnClear= findViewById(R.id.clear);
 rg = findViewById(R.id.radio);
 rbCtf= findViewById(R.id.btncel);
 rbFtC= findViewById(R.id.btnfah);

        //button as ClickListener
        btnClear.setOnClickListener(this);
        btnConvert.setOnClickListener(this);
    }
    public void onClick(View v)
    {
        switch (v.getId()){
            case R.id.clear:
                etFah.setText("");
                etCel.setText("");
                break;
            case R.id.convert:
                if(rbCtf.isChecked()){
                    //convert from celsius to Fahrenheit
                    if(!etCel.getText().toString().equalsIgnoreCase("")){
                    double cel= Double.parseDouble(etCel.getText().toString());
                    double fah= cel*(9.0/5.0)+32;

                    Double result = new Double(fah);
                    String strDouble = String.format("%.2f", result);
                    etFah.setText(strDouble);}
                    else
                        Toast.makeText(getApplicationContext(),"Please enter the celsius  Temperature to convert...!",Toast.LENGTH_LONG).show();

                }else if(rbFtC.isChecked()){

                    //convert from Fahrenheit to celsius
                    if(!etFah.getText().toString().equalsIgnoreCase("")){
                    double fah= Double.parseDouble(etFah.getText().toString());
                    double cel= (fah-32)*(5.0/9.0);
                    Double result = new Double(cel);
                    String strDouble = String.format("%.2f", result);
                    etCel.setText(strDouble);}
                    else
                        Toast.makeText(getApplicationContext(),"Please enter the  Fahrenheit Temperature to convert...!",Toast.LENGTH_LONG).show();
                }




        }
    }
}
