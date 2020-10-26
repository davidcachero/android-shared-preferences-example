package com.example.myactividadguardardatos

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("EjemploShared", Context.MODE_PRIVATE)
        var nombre = sharedPreferences.getString("nombre", "")
        var apellido = sharedPreferences.getString("apellido", "")

        var editTextNombre = findViewById<EditText>(R.id.editTextNombre)
        var editTextApellido = findViewById<EditText>(R.id.editTextApellido)

        editTextNombre.setText(nombre)
        editTextApellido.setText(apellido)
    }

    fun onGuardar(view: View) {
        var editTextNombre = findViewById<EditText>(R.id.editTextNombre)
        var editTextApellido = findViewById<EditText>(R.id.editTextApellido)

        var nombre = editTextNombre.text.toString()
        var apellido = editTextApellido.text.toString()


        var editor = sharedPreferences.edit()
        editor.putString("nombre", nombre)
        editor.putString("apellido", apellido)

        editor.commit()
    }

    fun onBorrar(view: View) {
        var editor = sharedPreferences.edit()
        editor.clear()
        editor.commit()
    }
}