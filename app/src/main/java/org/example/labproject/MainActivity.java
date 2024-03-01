package org.example.labproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private Button login;
    private Button registrar;
    private Button cerrarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.iniciarSesionPantalla);
        registrar = findViewById(R.id.Registro);
        cerrarSesion = findViewById(R.id.cerrarSesion);

        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser()!=null){
            login.setVisibility(View.GONE);
            registrar.setVisibility(View.GONE);
            cerrarSesion.setVisibility(View.VISIBLE);
        }

    }
    public void Iniciar(View view){
        Intent i = new Intent(this,IniciarSesionActivity.class);
        startActivity(i);
    }

    public void Registrarse(View view){
        Intent i = new Intent(this, RegistrarUsuarioActivity.class);
        startActivity(i);
    }

    public void cerrarSesion(View view){
        auth.signOut();
        if (auth.getCurrentUser()==null){
            login.setVisibility(View.VISIBLE);
            registrar.setVisibility(View.VISIBLE);
            cerrarSesion.setVisibility(View.GONE);
            Toast.makeText(getApplicationContext(),"Has cerrado sesión exitosamente",Toast.LENGTH_SHORT).show();
        }
    }

}