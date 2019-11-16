package com.example.basiccrud.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.basiccrud.dto.Serie;
import com.example.basiccrud.helpers.DatabaseHelper;

public class SerieDAL {
    private DatabaseHelper dbHelper; // obtener el helper
    private Serie serie;

    public SerieDAL(Context context) {
        this.dbHelper = new DatabaseHelper(context);
        this.serie = new Serie();
    }

    public SerieDAL(Context context, Serie serie) {
        this.dbHelper = new DatabaseHelper(context);
        this.serie = serie;
    }

    public boolean insertar() {
        return this.tryInsert();

    }

    public boolean insertar(String nombre, String categoria, int capitulos)
    {
        this.serie.setNombre(nombre);
        this.serie.setCategoria(categoria);
        this.serie.setCapitulos(capitulos);

        return this.tryInsert();
    }

    private boolean tryInsert() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

/*
        String[] argumentos = new String[]{"Breaking Bad","Suspenso","36"};
        db.execSQL("INSERT INTO serie(nombre,categoria,capitulos) VALUES(?,?,?);", argumentos);
*/

        ContentValues c = new ContentValues(); // Objeto tipo clave-valor
        c.put("nombre", this.serie.getNombre());
        c.put("categoria", this.serie.getCategoria());
        c.put("capitulos", this.serie.getCapitulos());

        try {
            db.insert("serie", null, c);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
