package com.example.testandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnConvert;
    int posFrom;
    int posTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.unitati_de_masura);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.unitatiDeMsaura, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemClickListener((parent, view, position, id) -> {
            posFrom = position;
        });

        spinner = (Spinner) findViewById(R.id.unitati_de_masura_2);

        adapter = ArrayAdapter.createFromResource(this,
                R.array.unitatiDeMsaura, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        spinner.setOnItemClickListener((parent, view, position, id) -> {
            posTo = position;
        });

        btnConvert.setOnClickListener(v -> {
            EditText ed = findViewById(R.id.inDim);
            double dim = Integer.parseInt(ed.toString());

            if (posTo == posFrom) {
                Toast.makeText(this ,"Same conversion detected", Toast.LENGTH_SHORT).show();
                return;
            }

            // km m cm mm inch

            switch (posFrom) {
                case 0:
                    dim = dim * 10000; // cm
                    break;
                case 1:
                    dim = dim * 100;
                case 2:
                    break;

                case 3:
                    dim = dim / 10;
                    break;

                case 4:
                    dim = dim / 2.54;
                    break;
            }

            switch (posTo) {
                case 0:
                    dim = dim / 10000; // cm
                    break;
                case 1:
                    dim = dim / 100;
                case 2:
                    break;

                case 3:
                    dim = dim * 10;
                    break;

                case 4:
                    dim = dim * 2.54;
                    break;
            }

            Log.d("milea", "Dim calculata este" + dim);


        });

    }


    private void convert() {

    }

}