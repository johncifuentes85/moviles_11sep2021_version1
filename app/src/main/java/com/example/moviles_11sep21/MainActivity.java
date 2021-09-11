package com.example.moviles_11sep21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //se declaran las variables
    EditText etEmail, etPass;
    Button btnLogin, btnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);
        btnLogin = findViewById(R.id.btnLogin);
        btnTest = findViewById(R.id.btnTest);
        btnTest.setOnClickListener(this);//que este pendiente del evento click aqui mismo.
        btnLogin.setOnClickListener(this);
    }
    //metodo
    public void login(){
        String email = etEmail.getText().toString();//trae el valor de campo email
        String pass = etPass.getText().toString();
        Toast.makeText(this, "email + pass", Toast.LENGTH_SHORT).show();
        if (email.equals("")){
            Toast.makeText(this, "Email Vacio", Toast.LENGTH_SHORT).show();
        }
        else if (pass.length() ==0){
            Toast.makeText(this, "Passwork Vacio", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Login Correcto", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public  void onClick(View view){
        switch (view.getId()){
            case R.id.btnLogin:
                login();//se llama la funcion
                //Toast.makeText(this, "login", Toast.LENGTH_SHORT).show();
            case R.id.btnTest:
                Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
                break;
        }//se hace un caso y el selector es el id del boton que va a ejecutar la accion con getID obtiene el id del boton qu hace click
    }
}