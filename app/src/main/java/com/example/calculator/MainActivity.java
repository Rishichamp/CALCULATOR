package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    EditText editnum1;
    EditText editnum2;
    Button btn;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editnum1=(EditText) findViewById(R.id.editTextNumberDecimal);
        editnum2=(EditText) findViewById(R.id.editTextNumberDecimal2);
        btn=(Button) findViewById(R.id.button);
        result=(TextView) findViewById(R.id.textView);
        result.setVisibility(View.INVISIBLE);
        Spinner spinner=(Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.operators, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l)
            {
                btnx(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {
                    result.setText("Wrong Input");
            }
        });
    }
    void btnx(int position)
    {
        btn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if(editnum1.getText().toString().isEmpty()||editnum2.getText().toString().isEmpty())
                {
                    result.setText("Number Fields Can Not be Empty");
                }
                else
                {
                    result.setVisibility(View.VISIBLE);
                    String value = editnum1.getText().toString();
                    String value2 = editnum2.getText().toString();
                    double a = Double.parseDouble(value);
                    double b = Double.parseDouble(value2);


                    if (position == 0)
                    {
                        double r = a + b;
                        result.setText(String.format("Answer= %.2f", r));
                    }
                    if (position == 1)
                    {
                        double r = a - b;
                        result.setText(String.format("Answer= %.2f", r));
                    }
                    if (position == 2)
                    {
                        double r = a * b;
                        result.setText(String.format("Answer= %.2f", r));
                    }
                    if (position == 3)
                    {
                        double r = a / b;
                        result.setText(String.format("Answer= %.2f", r));
                    }
                    if(position==4)
                    {
                        double r=a%b;
                        result.setText(String.format("Answer=%.2f",r));
                    }
                }


            }
        });

    }
}