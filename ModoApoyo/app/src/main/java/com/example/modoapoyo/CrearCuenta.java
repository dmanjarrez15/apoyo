package com.example.modoapoyo;

import android.os.Bundle;
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

public class CrearCuenta extends AppCompatActivity {

    private EditText etNombreCompleto;
    private EditText etNumAcceso;
    private EditText etCurp;
    private EditText etCorreo;
    private EditText etContrasena;
    private EditText etTelefono;

    private Spinner spinnerNumAcceso;
    private Spinner spinnerCurp;

    private ImageButton btnRegresar;
    private ImageButton btnIniciarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_crear_cuenta);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNombreCompleto = findViewById(R.id.etNombreCompleto);
        etNumAcceso = findViewById(R.id.etNumAcceso);
        etCurp = findViewById(R.id.etCurp);
        etCorreo = findViewById(R.id.etCorreo);
        etContrasena = findViewById(R.id.etContrasena);
        etTelefono = findViewById(R.id.etTelefono);

        spinnerNumAcceso = findViewById(R.id.spinnerNumAcceso);
        spinnerCurp = findViewById(R.id.spinnerCurp);

        btnRegresar = findViewById(R.id.btnRegresar);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);

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

    private void configurarSpinners() {
        if (spinnerNumAcceso == null || spinnerCurp == null) return;

        String[] opcionesAcceso = {"Seleccionar...", "Docente", "Administrativo", "Externo"};
        ArrayAdapter<String> adapterAcceso = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opcionesAcceso);
        adapterAcceso.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNumAcceso.setAdapter(adapterAcceso);

        String[] opcionesCurp = {"Seleccionar...", "Validado", "Pendiente"};
        ArrayAdapter<String> adapterCurp = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opcionesCurp);
        adapterCurp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCurp.setAdapter(adapterCurp);
    }

    private void registrarUsuario() {
        if (etNombreCompleto == null || etCorreo == null || etContrasena == null || spinnerNumAcceso == null) return;

        String nombre = etNombreCompleto.getText().toString().trim();
        String correo = etCorreo.getText().toString().trim();
        String contrasena = etContrasena.getText().toString().trim();
        String selAcceso = spinnerNumAcceso.getSelectedItem().toString();

        if (nombre.isEmpty() || correo.isEmpty() || contrasena.isEmpty()) {
            Toast.makeText(this, "Por favor, llena los campos obligatorios (Nombre, Correo y Contraseña)", Toast.LENGTH_SHORT).show();
            return;
        }

        if (selAcceso.equals("Seleccionar...")) {
            Toast.makeText(this, "Por favor, selecciona un tipo de acceso válido", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, "Registro guardado para: " + nombre, Toast.LENGTH_LONG).show();

        finish();
    }
}