package com.example.basiccrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.basiccrud.dal.SerieDAL;
import com.example.basiccrud.dto.Serie;

public class MainActivity extends AppCompatActivity {
    private SerieDAL serieDAL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.serieDAL = new SerieDAL(getApplicationContext(), new Serie());

        Button boton = findViewById(R.id.bt2);
        final EditText text1 = findViewById(R.id.txt1);
        final EditText text2 = findViewById(R.id.txt2);
        final EditText text3 = findViewById(R.id.txt4);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serieDAL.insertar(
                        text1.getText().toString(),
                        text2.getText().toString(),
                        Integer.parseInt(text3.getText().toString())
                );
            }
        });

        // Testing (No lo hagan en casa)
/*
        // TEST DE ELIMINAR
        if(serieDAL.eliminar(1)) {
            Toast.makeText(
                    getApplicationContext(),
                    "Se eliminó!",
                    Toast.LENGTH_LONG
            ).show();
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    "NO se eliminó!",
                    Toast.LENGTH_LONG
            ).show();
        }*/

/*
        // TEST INSERTAR
        Serie s = new Serie("The boys", "Sci-Fi", 8);
        this.serieDAL = new SerieDAL(getApplicationContext(), s);

        if(serieDAL.insertar()) {
            Toast.makeText(getApplicationContext(), "OK! Insertó", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "MAL! NO Insertó", Toast.LENGTH_LONG).show();

        }*/

    }
}
