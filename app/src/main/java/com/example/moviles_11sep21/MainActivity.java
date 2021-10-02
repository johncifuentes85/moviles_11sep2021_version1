package com.example.moviles_11sep21;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.moviles_11sep21.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //se declaran las variables
    //EditText etEmail, etPass;
    //Button btnLogin, btnTest;

    // con esta linea hacemos el view binding
    private ActivityMainBinding mainBinding;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // con esta linea hacemos el view binding asi la llamamos
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view =mainBinding.getRoot();
        setContentView(view);

        //etEmail = findViewById(R.id.etEmail);
        //etPass = findViewById(R.id.etPass);
        //btnLogin = findViewById(R.id.btnLogin);
        //btnTest = findViewById(R.id.btnTest);
        //btnTest.setOnClickListener(this);//que este pendiente del evento click aqui mismo.
        //btnLogin.setOnClickListener(this);
    }
    //metodo
    public void login(){
        //String email = etEmail.getText().toString();//trae el valor de campo email
        // asi llamamos a los id con view biding
        String email = mainBinding.etEmail.getText().toString();//trae el valor de campo email
        String pass = mainBinding.etPass.getText().toString();
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

    //metodo para agregar informacion a firebase
    public  void createUser(View view){
        Map<String, Object> userData = new HashMap<>();
        String email = etEmail.getText().toString();//trae el valor de campo email
        String pass = etPass.getText().toString();

        userData.put("email",email); // se envia la informacion
        userData.put("password",pass);


        db.collection("users")
                .add(userData)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        //Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                        Toast.makeText(getApplicationContext(), "Usuario agregado", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //Log.w(TAG, "Error adding document", e);
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                    }
                });

    }
}