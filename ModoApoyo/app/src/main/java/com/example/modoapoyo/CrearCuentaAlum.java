package com.example.modoapoyo;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CrearCuentaAlum extends AppCompatActivity {

    private EditText etNombre, etBoleta, etGrupo, etCorreo, etContrasena, etTelefono;
    private Spinner spinnerBoleta, spinnerGrupo;
    private ImageButton btnRegresar, btnIniciarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_crear_cuenta_alum);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inicializarComponentes();

        configurarSpinners();

        if (btnRegresar != null) {
            btnRegresar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }

        if (btnIniciarSesion != null) {
            btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    registrarUsuario();
                }
            });
        }
    }

    private void inicializarComponentes() {
        etNombre = findViewById(R.id.etNombreCompleto);
        etBoleta = findViewById(R.id.etBoleta);
        etGrupo = findViewById(R.id.etGrupo);
        etCorreo = findViewById(R.id.etCorreo);
        etContrasena = findViewById(R.id.etContrasena);
        etTelefono = findViewById(R.id.etTelefono);

        spinnerBoleta = findViewById(R.id.spinnerBoleta);
        spinnerGrupo = findViewById(R.id.spinnerGrupo);

        btnRegresar = findViewById(R.id.btnRegresar);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
    }

    private void configurarSpinners() {
        if (spinnerBoleta == null || spinnerGrupo == null) return;

        String[] opcionesBoleta = {"Seleccionar...", "Opción 1", "Opción 2", "Opción 3"};
        ArrayAdapter<String> adapterBoleta = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opcionesBoleta);
        adapterBoleta.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBoleta.setAdapter(adapterBoleta);

        String[] opcionesGrupo = {"Seleccionar...", "Grupo A", "Grupo B", "Grupo C"};
        ArrayAdapter<String> adapterGrupo = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opcionesGrupo);
        adapterGrupo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGrupo.setAdapter(adapterGrupo);
    }

    private void registrarUsuario() {
        if (etNombre == null || etCorreo == null || etContrasena == null || spinnerBoleta == null || spinnerGrupo == null) return;

        String nombre = etNombre.getText().toString().trim();
        String correo = etCorreo.getText().toString().trim();
        String contrasena = etContrasena.getText().toString().trim();

        String selBoleta = spinnerBoleta.getSelectedItem().toString();
        String selGrupo = spinnerGrupo.getSelectedItem().toString();

        if (TextUtils.isEmpty(nombre) || TextUtils.isEmpty(correo) || TextUtils.isEmpty(contrasena)) {
            Toast.makeText(this, "Por favor, llena los campos obligatorios (Nombre, Correo y Contraseña)", Toast.LENGTH_LONG).show();
            return;
        }

        if (selBoleta.equals("Seleccionar...") || selGrupo.equals("Seleccionar...")) {
            Toast.makeText(this, "Por favor, selecciona una opción válida en los menús", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, "Datos validados correctamente. ¡Creando cuenta!", Toast.LENGTH_SHORT).show();

        finish();
    }
}