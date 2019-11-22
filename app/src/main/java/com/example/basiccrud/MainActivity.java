package com.example.basiccrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.basiccrud.dal.SerieDAL;
import com.example.basiccrud.dto.Serie;

public class MainActivity extends AppCompatActivity {
    private SerieDAL serieDAL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Testing (No lo hagan en casa)
        Serie s = new Serie("The boys", "Sci-Fi", 8);
        this.serieDAL = new SerieDAL(getApplicationContext(), s);

        boolean r = serieDAL.insertar();

        if(r) {
            Toast.makeText(getApplicationContext(), "OK! Insertó", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "MAL! NO Insertó", Toast.LENGTH_LONG).show();

        }

    }
}
