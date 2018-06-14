package com.example.lenovo.proyectosqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NegocioMantenedorCliente extends SQLiteOpenHelper
{
    private static final int VERSION_BASEDATOS = 1;
    private static final String NOMBRE_BASEDATOS = "PruebaDB";
    private static final String TABLA_CLIENTE = "CREATE TABLE cliente (rut TEXT PRIMARY KEY, nombre TEXT)";

   public NegocioMantenedorCliente(Context context){
       super(context,NOMBRE_BASEDATOS,null,VERSION_BASEDATOS);
   }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_CLIENTE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS cliente");
        onCreate(db);
    }

    //Método para insertar datos
    public void insertarDatos(Cliente cliente){
       SQLiteDatabase db = getWritableDatabase();
       if  (db!=null){
           db.execSQL("INSERT INTO cliente (rut,nombre) VALUES ('"+cliente.getRut()+"','"+cliente.getNombre()+"')");
       }
       db.close();
    }//Fin insertar
}
