package com.example.modoapoyo;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class InicioSesion extends AppCompatActivity {

    private EditText etCorreo;
    private EditText etContrasena;
    private ImageButton btnRegresar;
    private ImageButton btnIngresar;
    private ImageButton btnRegistroAlumno, btnRegistroDocente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inicio_sesion);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etCorreo = findViewById(R.id.editTextTextEmailAddress2);
        etContrasena = findViewById(R.id.editTextNumberPassword);
        btnRegresar = findViewById(R.id.btnRegresar);
        btnIngresar = findViewById(R.id.btnIniciar);

        btnRegistroDocente = findViewById(R.id.btnRegistroDocente);
        btnRegistroAlumno = findViewById(R.id.btnRegistroAlumno);

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarLogin();
            }
        });

        btnRegistroDocente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InicioSesion.this, CrearCuenta.class);
                startActivity(intent);
            }
        });

        btnRegistroAlumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InicioSesion.this, CrearCuentaAlum.class);
                startActivity(intent);
            }
        });

    }

    private void validarLogin() {
        String correo = etCorreo.getText().toString().trim();
        String pass = etContrasena.getText().toString().trim();

        if (correo.isEmpty() || pass.isEmpty()) {
            Toast.makeText(this, "Por favor ingresa correo y contraseña", Toast.LENGTH_SHORT).show();
            return;
        }

        if (correo.equals("usuario@gmail.com") && pass.equals("1234")) {
            Toast.makeText(this, "¡Bienvenido!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }
    }

}